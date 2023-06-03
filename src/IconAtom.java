import java.awt.*;

public class IconAtom implements IDrawable{
    public int x;
    public int y;
    public int width;
    public int height;
    public Dimension offset;
    Color color;

    IconAtom(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.offset = new Dimension(0,0);
    }

    public void setOffset(Dimension offset){
        this.offset = (Dimension) offset.clone();
    }

    public void draw(Graphics g){
        g.setColor(this.color);
        g.fillRect(
                offset.width + (int) (x*ModelOptions.ZOOM_GRAPHICS),
                offset.height + (int) (y*ModelOptions.ZOOM_GRAPHICS),
                (int) (width*ModelOptions.ZOOM_GRAPHICS),
                (int) (height*ModelOptions.ZOOM_GRAPHICS)
        );
    }
}
