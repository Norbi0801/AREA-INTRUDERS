import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewStart extends JFrame implements IView {

    static JPanel ico= new JPanel(){
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
    };
    static ViewStart obj;
    static Dimension POSITION = new Dimension(0,0);
    static Timer timer = new Timer((int) (1/ModelOptions.FPS*1000), new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ico.repaint(); // Odśwież panel, co spowoduje wywołanie metody paintComponent()
        }
    });

    public static void on() throws Exception {
        if(ViewStart.obj == null){
            obj = new GMethods<ViewStart>().setupWindow(new ViewStart(), ViewStart.POSITION);
            obj.setTitle("AREA INTRUDERS");
            obj.add(ico);
            timer.start();

        }else{
            throw new Exception("ViewStart exist");
        }
    }
}
