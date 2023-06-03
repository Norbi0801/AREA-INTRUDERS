import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewMenu extends JFrame implements IView{

    static JPanel menu = new JPanel();

    static JButton start = new JButton("START");
    static JButton options = new JButton("USTAWIENIA");
    static JButton rules = new JButton("ZASADY");
    static JButton top10 = new JButton("TOP10");
    static ViewMenu obj;
    static Dimension POSITION = new Dimension(1,0);

    public static void on() throws Exception {
        if(ViewMenu.obj == null){
            obj = new GMethods<ViewMenu>().setupWindow(new ViewMenu(), ViewMenu.POSITION);
            obj.setTitle("AREA INTRUDERS - Menu");
            obj.setDefaultCloseOperation(EXIT_ON_CLOSE);

            start.addActionListener((ActionEvent e)->ControllerView.actionStart());
            options.addActionListener((ActionEvent e)->ControllerView.actionOptions());
            rules.addActionListener((ActionEvent e)->ControllerView.actionRules());
            top10.addActionListener((ActionEvent e)->ControllerView.actionTopPlayers());

            menu.setLayout(new GridLayout(4,1));
            menu.add(start);
            menu.add(options);
            menu.add(rules);
            menu.add(top10);

            obj.add(menu);
        }else{
            throw new Exception("ViewMenu exist");
        }
    }
}
