import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class LabelTextPositionFrame extends JFrame {
   private JButton button0, button1, button2, button3, button4, button5;
   private JLabel label;

   LabelTextPositionFrame() {
      setLayout(new FlowLayout());

      label = new JLabel("Testo e icona");
      label.setIcon(new ImageIcon(getClass().getResource("computer.png")));
      label.setHorizontalTextPosition(SwingConstants.RIGHT);
      label.setVerticalTextPosition(SwingConstants.CENTER);
      add(label, SwingConstants.CENTER);

      button0 = new JButton("Horizontal SX");
      button0.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            label.setHorizontalTextPosition(SwingConstants.LEFT);
            validate();
         }
      });

      button1 = new JButton("Horizontal Center");
      button1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            label.setHorizontalTextPosition(SwingConstants.CENTER);
            validate();
         }
      });

      button2 = new JButton("Horizontal DX");
      button2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            label.setHorizontalTextPosition(SwingConstants.RIGHT);
            validate();
         }
      });

      button3 = new JButton("Vertical Top");
      button3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            label.setVerticalTextPosition(SwingConstants.TOP);
            validate();
         }
      });

      button4 = new JButton("Vertical Center");
      button4.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            label.setVerticalTextPosition(SwingConstants.CENTER);
            validate();
         }
      });

      button5 = new JButton("Vertical Bottom");
      button5.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            label.setVerticalTextPosition(SwingConstants.BOTTOM);
            validate();
         }
      });

      add(button0);
      add(button1);
      add(button2);
      add(button3);
      add(button4);
      add(button5);

      setSize(500, 250);
      setVisible(true);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
