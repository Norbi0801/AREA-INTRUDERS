import java.awt.*;

public class Enemy extends Entity{

    Enemy(int Id, Icon Icon, Collider Collider, Dimension Position, int Hp) {
        super(Id, Icon, Collider, Position, Hp);
        System.out.println(Position);
    }

    @Override
    public void move(int x, int y) {
        super.move(x, y);
        maybeShot();
    }

    public void maybeShot(){
        if((int)(Math.random()*ModelOptions.ENEMY_CHANCE_SHOT) == 0){
            Engine.enemyShots.add(
                    new Shot(
                            Engine.enemyShots.size(),
                            ModelIcons.getShot(TypeShot.NORMAL),
                            new Collider(Engine.enemyShots.size(), "enemyShot") {
                                @Override
                                public void onEnter(Collider other) {

                                    if(other.name.equals("Player")){
                                        Engine.enemyShots.remove(this.obj);
                                        FireCollider.colliders.remove(this);
                                    }
                                }
                            },
                            this.position
                    )
            );
        }
    }
}
