import java.awt.*;
import java.util.ArrayList;

public class FireCollider {
    public static ArrayList<Collider> colliders = new ArrayList<>();

    public static void add(Collider Collider){
        colliders.add(Collider);
    }

    public static void fireColisions(){
        for (Dimension p:Combinations.comb(colliders.size())) {
            try{
                if(colliders.get((int) p.getWidth()).start.getWidth() >= colliders.get((int) p.getHeight()).start.getWidth()
                && colliders.get((int) p.getWidth()).start.getWidth() <= colliders.get((int) p.getHeight()).end.getWidth()
                && colliders.get((int) p.getWidth()).start.getHeight() >= colliders.get((int) p.getHeight()).start.getHeight()
                && colliders.get((int) p.getWidth()).start.getHeight() <= colliders.get((int) p.getHeight()).end.getHeight()
                        ||
                colliders.get((int) p.getWidth()).end.getWidth() >= colliders.get((int) p.getHeight()).start.getWidth()
                && colliders.get((int) p.getWidth()).end.getWidth() <= colliders.get((int) p.getHeight()).end.getWidth()
                && colliders.get((int) p.getWidth()).end.getHeight() >= colliders.get((int) p.getHeight()).start.getHeight()
                && colliders.get((int) p.getWidth()).end.getHeight() <= colliders.get((int) p.getHeight()).end.getHeight()
                ){
                    colliders.get((int) p.getWidth()).onEnter(colliders.get((int) p.getHeight()));
                    colliders.get((int) p.getHeight()).onEnter(colliders.get((int) p.getWidth()));
                }
            }catch (Exception e){;}
        }

    }
}
