import java.awt.*;

public class Moveable {
    public Icon icon;
    public Collider collider;
    public Dimension position;

    Moveable(Icon Icon, Collider Collider, Dimension Position){
        icon = Icon;
        collider = Collider;
        position = Position;
        icon.setOffset(new Dimension(
                (int) (position.getWidth()-icon.size.getWidth()/2*ModelOptions.ZOOM_GRAPHICS),
                (int) (position.getHeight()-icon.size.getHeight()/2*ModelOptions.ZOOM_GRAPHICS)
        ));
        collider.updateCollider(position, ModelOptions.OBJECT_SIZE);
        FireCollider.add(this.collider);
        Collider.obj = this;
    }

    public void move(int x, int y){
        position = new Dimension(
                (int) (position.getWidth()+x*ModelOptions.ZOOM_GRAPHICS),
                (int) (position.getHeight()+y*ModelOptions.ZOOM_GRAPHICS)
        );
        icon.setOffset(new Dimension(
                (int) (position.getWidth()-icon.size.getWidth()/2*ModelOptions.ZOOM_GRAPHICS),
                (int) (position.getHeight()-icon.size.getHeight()/2*ModelOptions.ZOOM_GRAPHICS)
        ));
        collider.updateCollider(position, ModelOptions.OBJECT_SIZE);
    }
}
