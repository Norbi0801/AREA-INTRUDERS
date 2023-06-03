import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ViewOptions extends JFrame implements IView {
    static ViewOptions obj;
    static Dimension POSITION = new Dimension(1, 1);

    public static void on() throws Exception {
        if (ViewOptions.obj == null) {
            obj = new GMethods<ViewOptions>().setupWindow(new ViewOptions(), ViewOptions.POSITION);
            obj.setTitle("AREA INTRUDERS - Ustawienia");
            obj.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    ControllerView.actionExitOptions();
                }
            });

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(10, 2, 10, 10));

            panel.add(new JLabel("Nick:"));
            JTextField nick= new JTextField();
            panel.add(nick);

            JSlider enemyRows = new JSlider(5,20,7);
            panel.add(new JLabel("Poziom trudności kolumny"));
            panel.add(enemyRows);

            JSlider enemyColumn = new JSlider(1,3,2);
            panel.add(new JLabel("Poziom trudności wiersze"));
            panel.add(enemyColumn);

            JSlider speedEnemy = new JSlider(1,3,2);
            panel.add(new JLabel("Szybkość przesuwania wrofów"));
            panel.add(speedEnemy);

            JCheckBox inpossible = new JCheckBox("Niemożliwe");
            panel.add(new JLabel("Szybkość przesuwania wrofów"));
            panel.add(inpossible);

            JComboBox optionIcon = new JComboBox<TypePlayer>(TypePlayer.values());
            panel.add(optionIcon);

            JButton saveButton = new JButton("Save");
            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ModelOptions.NICK = nick.getText();
                    ModelOptions.ENEMY_RESOLUTION = new Dimension(enemyRows.getValue(), enemyColumn.getValue());
                    ModelOptions.STEP_ENEMY = speedEnemy.getValue();
                    if(inpossible.isSelected()){
                        ModelOptions.ENEMY_CHANCE_SHOT = 20;
                        ModelOptions.ENEMY_RESOLUTION = new Dimension(20, 5);
                    }
                    ModelOptions.activeIconPlayer = optionIcon.getSelectedIndex();
                }
            });
            panel.add(saveButton);
            obj.add(panel);
        } else {
            throw new Exception("ViewMenu exist");
        }
    }
}
