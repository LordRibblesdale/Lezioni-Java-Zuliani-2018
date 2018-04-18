import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class LabelTextPositionFrame extends JFrame {
   //private JButton button0, button1, button2, button3, button4, button5;
   private JButton[] button = new JButton[6];
   private String[] position = {"Horizontal SX", "Horizontal Center", "Horizontal DX", "Vertical Top", "Vertical Center", "Vertical Bottom"};
   private JPanel panel1, panel2;
   private JLabel label;

   LabelTextPositionFrame() {
      setLayout(new GridLayout(2, 0));

      panel1 = new JPanel(new FlowLayout());

      label = new JLabel("Testo e icona");
      label.setIcon(new ImageIcon(getClass().getResource("computer.png")));
      label.setHorizontalTextPosition(SwingConstants.RIGHT);
      label.setVerticalTextPosition(SwingConstants.CENTER);
      panel1.add(label);
      add(panel1);

      panel2 = new JPanel(new GridLayout(2, 2));

      ActionListener l = new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button[0]) {
               label.setHorizontalTextPosition(SwingConstants.LEFT);
            } else if (e.getSource() == button[1]) {
               label.setHorizontalTextPosition(SwingConstants.CENTER);
            } else if (e.getSource() == button[2]) {
               label.setHorizontalTextPosition(SwingConstants.RIGHT);
            } else if (e.getSource() == button[3]) {
               label.setVerticalTextPosition(SwingConstants.TOP);
            } else if (e.getSource() == button[4]) {
               label.setVerticalTextPosition(SwingConstants.CENTER);
            } else {
               label.setVerticalTextPosition(SwingConstants.BOTTOM);
            }

            validate();
         }
      };

      for (int i = 0; i < button.length; i++) {
         button[i] = new JButton(position[i]);
         button[i].addActionListener(l);
         panel2.add(button[i]);
      }
      
      add(panel2);

      setSize(500, 250);
      setVisible(true);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
