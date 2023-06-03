import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ViewRules extends JFrame implements IView {

    static ViewRules obj;
    static Dimension POSITION = new Dimension(0, 1);

    public static void on() throws Exception {
        if (ViewRules.obj == null) {
            obj = new GMethods<ViewRules>().setupWindow(new ViewRules(), ViewRules.POSITION);
            obj.setTitle("AREA INTRUDERS - Zasady gry");
            obj.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    ControllerView.actionExitRules();
                }
            });
            JPanel l = new JPanel();
            l.setLayout(new FlowLayout());
            l.add(new JLabel("AREA INTRUDERS - Zasady gry"));
            l.add(new JLabel("1. Pokonaj wrogów z wykorzystaniem swojego czołgu,"));
            l.add(new JLabel(" możesz strzelać korzystając z klawisza W."));
            l.add(new JLabel("2. Poruszać się możesz klawiszami A i D."));
            l.add(new JLabel("Powodzenia"));
            obj.add(l);
        } else {
            throw new Exception("ViewMenu exist");
        }
    }
}
