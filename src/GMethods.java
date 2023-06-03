import javax.swing.*;
import java.awt.*;

public class GMethods <T extends JFrame>{

    public T setupWindow(T obj, Dimension position){
        obj.setVisible(true);
        obj.setSize(
                (int) (ModelOptions.dimension.getWidth()*ModelOptions.WIDTH_PARAMETR/ModelOptions.WIDTH_SPLIT),
                (int) (ModelOptions.dimension.getHeight()*ModelOptions.HEIGHT_PARAMETR/ModelOptions.HEIGHT_SPLIT)
        );
        obj.setLocation(
                (int) (position.getWidth()*ModelOptions.dimension.getWidth()*
                        ModelOptions.WIDTH_PARAMETR/ModelOptions.WIDTH_SPLIT),
                (int) (position.getHeight()*ModelOptions.dimension.getHeight()*
                        ModelOptions.HEIGHT_PARAMETR/ModelOptions.HEIGHT_SPLIT)
        );
        return obj;
    }
}
