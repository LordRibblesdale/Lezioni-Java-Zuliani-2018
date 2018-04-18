import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PanelAdder extends JFrame {
   private JPanel panel;
   //private JButton button0, button1, button2, button3;
   private JButton[] button = new JButton[4];
   private String[] color = {"RED", "GREEN", "BLUE", "Random"};
   private static int num = 0;

   PanelAdder() {
      setLayout(new FlowLayout());
      panel = new JPanel();
      panel.setLayout(new FlowLayout());



      class NewPanel {
         private JPanel addPanel;
         private JLabel label;

         NewPanel(float r, float g, float b) {
            addPanel = new JPanel();
            num++;
            label = new JLabel("Panel #" + num);
            addPanel.add(label);

            addPanel.setBackground(new Color(r, g, b));
            add(addPanel);
         }
      }

      ActionListener l = new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button[0]) {
               NewPanel p = new NewPanel(1, 0, 0);
            } else if (e.getSource() == button[1]) {
               NewPanel p = new NewPanel(0, 1, 0);
            } else if (e.getSource() == button[2]) {
               NewPanel p = new NewPanel(0, 0, 1);
            } else {
               NewPanel p = new NewPanel((float)Math.random(), (float)Math.random(), (float)Math.random());
            }

            validate();
         }
      };

      for (int i = 0; i < button.length; i++) {
         button[i] = new JButton(color[i]);
         button[i].addActionListener(l);
         panel.add(button[i]);
      }

      add(panel);

      setSize(500, 500);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);

      setVisible(true);
   }
}
