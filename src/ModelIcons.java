import java.awt.*;
import java.util.ArrayList;

public class ModelIcons implements IModel{

    static ArrayList<Icon> iconsGrass = new ArrayList<>();
    static ArrayList<Icon> iconsMap = new ArrayList<>();
    static ArrayList<Icon> iconsEnemy = new ArrayList<>();
    static ArrayList<Icon> iconsPlayer = new ArrayList<>();
    static ArrayList<Icon> iconsShots = new ArrayList<>();
    static ArrayList<Icon> iconsStart = new ArrayList<>();

    public static Icon getEnemy(TypeEnemy Enemy){
        Icon obj = new Icon();
        switch (Enemy) {
            case NORMAL -> {
                obj.addPixel(0, 0, 0, (int) ModelOptions.OBJECT_SIZE.getWidth(), (int) ModelOptions.OBJECT_SIZE.getHeight(), Color.red);
                obj.changeFrame();
                iconsEnemy.add(obj);
            }
            default -> {

            }
        }
        return obj;
    }

    public static Icon getPlayer(TypePlayer Player){
        Icon obj = new Icon();
        switch (Player) {
            case GREEN_PLAYER -> {
                obj.addPixel(0, 0, 0, (int) ModelOptions.OBJECT_SIZE.getWidth(), (int) ModelOptions.OBJECT_SIZE.getHeight(), new Color(0,128,0));
                obj.changeFrame();
                iconsPlayer.add(obj);
            }
            case PINK_PLAYER -> {
                obj.addPixel(0, 0, 0, (int) ModelOptions.OBJECT_SIZE.getWidth(), (int) ModelOptions.OBJECT_SIZE.getHeight(), Color.pink);
                obj.changeFrame();
                iconsPlayer.add(obj);
            }
            default -> {

            }
        }
        return obj;
    }

    public static Icon getShot(TypeShot Shot){
        Icon obj = new Icon();
        switch (Shot) {
            case NORMAL -> {
                obj.addPixel(0, 0, 0, (int) 2, (int) 16, new Color(128,128,0));
                obj.size = new Dimension(2,16);
                obj.changeFrame();
                iconsShots.add(obj);
            }
            default -> {

            }
        }
        return obj;
    }

    public static Icon getMap(TypeMap Map){
        Icon obj = new Icon();
        switch (Map) {
            case NORMAL -> {
                obj.addPixel(0, 0, 0, (int) ModelOptions.MAP_RESOLUTION.getWidth(), (int) ModelOptions.MAP_RESOLUTION.getHeight(), Color.green);
                obj.changeFrame();
                iconsMap.add(obj);
            }
            default -> {

            }
        }
        return obj;
    }
}
