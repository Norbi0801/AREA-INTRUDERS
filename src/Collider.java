import java.awt.*;

public class Collider {
    public Object obj;
    public int id;
    public String name;
    public Dimension start;
    public Dimension end;

    Collider(int Id, String Name){
        id = Id;
        name = Name;
    }
    public void onEnter(Collider other) {
        if(other.name == null) return;
    }

    public void updateCollider(Dimension center, Dimension size){
        start = new Dimension((int) (center.getWidth()-size.getWidth()/2), (int) (center.getHeight()-size.getHeight()/2));
        end = new Dimension((int) (center.getWidth()+size.getWidth()/2), (int) (center.getHeight()+size.getHeight()/2));
    }
}
