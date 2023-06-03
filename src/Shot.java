import java.awt.*;

public class Shot extends Moveable{
    private int id;

    Shot(int Id, Icon Icon, Collider Collider, Dimension Position) {
        super(Icon, Collider, Position);
        id = Id;

    }
}
