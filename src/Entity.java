import java.awt.*;

public class Entity extends Moveable{

    public int id;
    public int hp;

    Entity(int Id,Icon Icon, Collider Collider, Dimension Position, int Hp){
        super(Icon, Collider, Position);
        hp = Hp;
        id = Id;
        Collider.obj = this;
    }


}
