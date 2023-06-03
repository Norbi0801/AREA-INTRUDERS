import java.awt.*;

public class ModelOptions implements IModel{

    public static String NICK = "Man";
    public static final float FPS = 20f;
    public static final int SCORE_KILL = 1;
    public static double ENEMY_CHANCE_SHOT = 100;
    public static final int SPEED_SHOT = 5;

    static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    public static Dimension dimension = new Dimension(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());
    public static int HEIGHT_SPLIT = 2;
    public static int WIDTH_SPLIT = 4;
    public static float HEIGHT_PARAMETR = 0.7f;
    public static float WIDTH_PARAMETR = 0.7f;
    public static float ZOOM_GRAPHICS = 1;
    public static Dimension MAP_RESOLUTION = new Dimension(512, 512);
    public static Dimension OBJECT_SIZE = new Dimension(16,16);
    public static Dimension ENEMY_RESOLUTION = new Dimension(10,2);
    public static float ENEMY_SPACE = (float) (MAP_RESOLUTION.getWidth())*0.8f;
    public static Dimension ENEMY_SPACE_LEFT_CORNER = new Dimension(
            (int)(ModelOptions.MAP_RESOLUTION.getWidth()- ModelOptions.ENEMY_SPACE)/2,
            (int)(ModelOptions.MAP_RESOLUTION.getWidth()- ModelOptions.ENEMY_SPACE)/2
    );
    public static Dimension START_PLAYER_POSITION = new Dimension(
            (int) (ZOOM_GRAPHICS*MAP_RESOLUTION.getWidth()/2),
            (int) (ZOOM_GRAPHICS*MAP_RESOLUTION.getHeight()*7/9));
    public static final int START_PLAYER_HP = 1;
    public static int STEP_ENEMY = 1;
    public static int START_ENEMY_HP = 1;
    public static int COUNT_ENEMY_STEPS = 41;
    public static int activeIconPlayer = 0;
    public static int activeIconMap = 0;
}
