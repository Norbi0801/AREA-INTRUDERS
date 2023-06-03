import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewGame extends JFrame implements IView{
    static ViewGame obj;
    static JPanel map;
    static JPanel statistics;
    static JPanel controls;

    static JLabel Score = new JLabel("Score: 0");
    static JLabel Nick = new JLabel("Nick: Norbert");
    static Timer timer = new Timer((int) (1/ModelOptions.FPS*1000), new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            map.repaint(); // Odśwież panel, co spowoduje wywołanie metody paintComponent()
        }
    });
    static Dimension POSITION = new Dimension(2, 0);

    public static void on() throws Exception {
        if (ViewGame.obj == null) {
            obj = new GMethods<ViewGame>().setupWindow(new ViewGame(), ViewGame.POSITION);
            Dimension size = obj.getSize();
            obj.setSize((int) (ModelOptions.MAP_RESOLUTION.getWidth()), (int)(ModelOptions.MAP_RESOLUTION.getHeight()));
            obj.setTitle("AREA INTRUDERS");
            obj.setLayout(new BorderLayout());
            obj.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    ControllerView.actionExitGame();
                }
            });
            Engine.start();
            map = new JPanel(){
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Engine.draw(g);
                }
            };
            map.setSize(new Dimension(ModelOptions.MAP_RESOLUTION));
            map.setMaximumSize(new Dimension(ModelOptions.MAP_RESOLUTION));
            statistics = new JPanel();
            statistics.setSize((int)(ModelOptions.MAP_RESOLUTION.getWidth()), (int)(ModelOptions.MAP_RESOLUTION.getHeight()*1/3));
            statistics.add(Score);
            statistics.add(Nick);
            controls = new JPanel();

            JButton left = new JButton("<-");
            left.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Engine.actionMoveLeft();
                }
            });
            JButton shoot = new JButton("shoot");
            shoot.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Engine.actionShot();
                }
            });

            JButton right = new JButton("->");
            right.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Engine.actionMoveRight();
                }
            });
            JButton pause = new JButton("Pause");
            pause.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Engine.actionPause();
                }
            });

            Action aLeft = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Engine.actionMoveLeft();
                }
            };
            Action aRight = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Engine.actionMoveRight();
                }
            };
            Action aShoot = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Engine.actionShot();
                }
            };
            Action aPause = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Engine.actionPause();
                }
            };

            left.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('a'), "aLeft");
            right.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('d'), "aRight");
            shoot.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('w'), "aShoot");
            pause.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('p'), "aPause");

            left.getActionMap().put("aLeft",aLeft);
            right.getActionMap().put("aRight",aRight);
            shoot.getActionMap().put("aShoot",aShoot);
            pause.getActionMap().put("aPause",aPause);

            controls.add(left);
            controls.add(shoot);
            controls.add(right);
            controls.add(pause);

            obj.add(map, BorderLayout.CENTER);
            obj.add(statistics, BorderLayout.NORTH);
            obj.add(controls, BorderLayout.SOUTH);
            timer.start();
        } else {
            throw new Exception("ViewMenu exist");
        }
    }
}
