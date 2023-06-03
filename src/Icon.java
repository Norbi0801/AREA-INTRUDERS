
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Icon implements IDrawable{
    public ArrayList<ArrayList<IconAtom>> frames;
    public Dimension size = ModelOptions.OBJECT_SIZE;
    public int currentFrame;
    Timer timer;
    TimerTask task;
    Dimension offset;

    Icon(Dimension offset){
        this.offset = offset;
        frames = new ArrayList<>();
        frames.add(new ArrayList<>());
        currentFrame = 0;
    }
    Icon(){
        this.offset = new Dimension(0,0);
        frames = new ArrayList<>();
        frames.add(new ArrayList<>());
        currentFrame = 0;
    }
    public void startAnimation(float FPS){
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(() -> {
                    changeFrame();
                });
            }
        };

        timer.scheduleAtFixedRate(task, 0, (long) (1/FPS*1000));
    }

    public void startAnimation(){
        float FPS = ModelOptions.FPS;
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(() -> {
                    changeFrame();
                });
            }
        };

        timer.scheduleAtFixedRate(task, 10, (long)(1/FPS*1000));
    }
    public void addFrame(){
        frames.add(new ArrayList<>());
    }
    public void addPixel(int frame,int x, int y, int width, int height, Color color){
        frames.get(frame).add(new IconAtom(x,y,width,height,color));
    }
    @Override
    public void draw(Graphics g) {
        frames.get(currentFrame).forEach((x)->x.draw(g));
    }

    public void changeFrame() {
            currentFrame = (currentFrame+1)%frames.size();
    }

    public void setOffset(Dimension offset){
        frames.forEach((x)->x.forEach((y)->y.setOffset(offset)));
        this.offset = offset;
    }

    public Dimension getOffset(){
        return offset;
    }
}
