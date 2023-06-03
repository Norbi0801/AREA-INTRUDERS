import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.xml.stream.events.EndDocument;

public class Engine implements IModel{
    public static Icon map;
    public static ArrayList<Enemy> enemies;
    public static ArrayList<Shot> enemyShots;
    public static ArrayList<Shot> playerShots;
    public static Player player;
    public static ArrayList<Grass> grasses;
    public static int Score = 0;

    public static boolean isPause = false;

    public static Timer timer = new Timer((int) (1/ModelOptions.FPS*1000), new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Engine.update(); // Odśwież panel, co spowoduje wywołanie metody paintComponent()
        }
    });

    public static int CounterTick = 0;

    public static void draw(Graphics g) {
        map.draw(g);
        enemies.forEach((x)->x.icon.draw(g));
        enemyShots.forEach((x)->x.icon.draw(g));
        playerShots.forEach((x)->x.icon.draw(g));
        player.icon.draw(g);
    }

    public static void start(){
        map = ModelIcons.getMap(TypeMap.NORMAL);
        enemies = Stream.iterate(0, n -> n + 1)
                .limit((int) (ModelOptions.ENEMY_RESOLUTION.getWidth() * ModelOptions.ENEMY_RESOLUTION.getHeight()))
                .map((i) -> new Enemy(
                                i,
                                ModelIcons.getEnemy(TypeEnemy.NORMAL),
                                new Collider(i, "Enemy") {
                                    @Override
                                    public void onEnter(Collider other) {
                                        if(other.name.equals("playerShot")){
                                            Enemy e = (Enemy) this.obj;
                                            if (--e.hp <= 0){
                                                Engine.enemies.remove(this.obj);
                                                FireCollider.colliders.remove(this);
                                                Engine.actionKillEnemy(ModelOptions.SCORE_KILL);
                                            }
                                        }
                                    }
                                },
                                new Dimension(
                                        (int) ((i % ModelOptions.ENEMY_RESOLUTION.getWidth()) * (ModelOptions.ENEMY_SPACE / (ModelOptions.ENEMY_RESOLUTION.getWidth() - 1)) + ModelOptions.ENEMY_SPACE_LEFT_CORNER.getWidth()),
                                        (int) ((int) (i / ModelOptions.ENEMY_RESOLUTION.getWidth()) * (ModelOptions.ENEMY_RESOLUTION.getHeight() + ModelOptions.OBJECT_SIZE.getHeight() * 3 / 2) + ModelOptions.ENEMY_SPACE_LEFT_CORNER.getHeight())
                                ),
                                ModelOptions.START_ENEMY_HP
                        )
                ).collect(Collectors.toCollection(ArrayList::new));
        player = new Player(
                0,
                ModelIcons.getPlayer(TypePlayer.values()[ModelOptions.activeIconPlayer]),
                new Collider(0,"Player") {
                    @Override
                    public void onEnter(Collider other) {
                        if(other.name.equals("enemyShot")){
                            Engine.actionShotInPlayer();
                        }
                    }
                },
                ModelOptions.START_PLAYER_POSITION,
                ModelOptions.START_PLAYER_HP
        );
        grasses = new ArrayList<>();
        enemyShots = new ArrayList<>();
        playerShots = new ArrayList<>();
        Engine.timer.start();
    }

    public static void update(){
        if(Engine.CounterTick%ModelOptions.COUNT_ENEMY_STEPS == 0){
            enemies.forEach((x)->x.move(0,ModelOptions.STEP_ENEMY));
            if(enemies.stream().anyMatch((x)->x.position.getHeight() == Engine.player.position.getHeight()))
                actionEndGame();
        }else if(Engine.CounterTick%ModelOptions.COUNT_ENEMY_STEPS >= ModelOptions.COUNT_ENEMY_STEPS*3/4) {
            enemies.forEach((x)->x.move(ModelOptions.STEP_ENEMY,0));
        }else if(Engine.CounterTick%ModelOptions.COUNT_ENEMY_STEPS >= ModelOptions.COUNT_ENEMY_STEPS/4){
            enemies.forEach((x)->x.move(-ModelOptions.STEP_ENEMY,0));
        }else {
            enemies.forEach((x)->x.move(ModelOptions.STEP_ENEMY,0));
        }

        enemyShots.forEach((x)->x.move(0,ModelOptions.SPEED_SHOT));
        playerShots.forEach((x)->x.move(0,-ModelOptions.SPEED_SHOT));

        System.out.println(FireCollider.colliders.size());
        FireCollider.fireColisions();
        Engine.CounterTick++;
    }

    public static void close(){
        timer.stop();FireCollider.colliders = new ArrayList<>();
    }

    public static void actionShotInPlayer() {
        if(--player.hp <= 0){
            actionEndGame();
        }
    }
    private static void actionKillEnemy(int Score) {
        Engine.Score+=Score;
        if(Engine.enemies.size() == 0)
            actionEndGame();
    }

    public static void actionEndGame(){
        timer.stop();
        ViewGame.Score.setText("Gratulacje zdobyłeś "+Engine.Score+" punkty.");
    }
    public static void actionMoveRight(){
        Engine.player.move(10,0);
    }
    public static void actionMoveLeft(){
        Engine.player.move(-10,0);
    }
    public static void actionShot(){
        Engine.playerShots.add(
                new Shot(
                        Engine.playerShots.size(),
                        ModelIcons.getShot(TypeShot.NORMAL),
                        new Collider(Engine.playerShots.size(), "playerShot") {
                            @Override
                            public void onEnter(Collider other) {

                                if(other.name.equals("Enemy")){
                                    Engine.playerShots.remove(this.obj);
                                    FireCollider.colliders.remove(this);
                                }
                            }
                        },
                        Engine.player.position
                )
        );
    }
    public static void actionEnemyInBottom(){
        actionEndGame();
    }
    public static void actionPause(){
        if(!isPause) timer.stop(); else timer.start();
    }

}
