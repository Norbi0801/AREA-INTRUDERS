import java.awt.*;

public class Grass {
    public Icon icon;
    public Collider collider;
    public Dimension position;
    public int power;

    Grass(Icon Icon, Collider Collider, Dimension Position, int Power){
        icon = Icon;
        collider = Collider;
        position = Position;
        power = Power;
    }
}
