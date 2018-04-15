import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



class PanelAdder extends JFrame {
   private JPanel panel;
   private JButton button0, button1, button2, button3;
   private static int num = 0;

   PanelAdder() {
      setLayout(new FlowLayout());
      panel = new JPanel();
      panel.setLayout(new FlowLayout());

      button0 = new JButton("RED");
      button1 = new JButton("GREEN");
      button2 = new JButton("BLUE");
      button3 = new JButton("Random");

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

      button0.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            NewPanel p = new NewPanel(1, 0, 0);
            validate();
         }
      });

      button1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            NewPanel p = new NewPanel(0, 1, 0);
            validate();
         }
      });

      button2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            NewPanel p = new NewPanel(0, 0, 1);
            validate();
         }
      });

      button3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            NewPanel p = new NewPanel((float)Math.random(), (float)Math.random(), (float)Math.random());
            validate();
         }
      });

      panel.add(button0);
      panel.add(button1);
      panel.add(button2);
      panel.add(button3);

      add(panel);

      setSize(500, 500);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);

      setVisible(true);
   }
}
