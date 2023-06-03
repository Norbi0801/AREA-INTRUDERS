import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ViewTopPlayers extends JFrame implements IView {
    static ViewTopPlayers obj;
    static Dimension POSITION = new Dimension(0,0);
    public static void on() throws Exception {
        if(ViewTopPlayers.obj == null){
            obj = new GMethods<ViewTopPlayers>().setupWindow(new ViewTopPlayers(), ViewTopPlayers.POSITION);
            obj.setTitle("AREA INTRUDERS - !TOP!");
            obj.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    ControllerView.actionExitTopPlayers();
                }
            });
        }else{
            throw new Exception("ViewTopPlayers exist");
        }
    }
}
