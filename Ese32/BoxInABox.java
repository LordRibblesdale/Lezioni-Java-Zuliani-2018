import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoxInABox extends JFrame {
   private JPanel h_box1, h_box2;

   BoxInABox() {
      setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

      h_box1 = new JPanel();
      h_box1.setLayout(new BoxLayout(h_box1, BoxLayout.LINE_AXIS));
      h_box1.add(new JButton("Bottone A"));
      h_box1.add(Box.createRigidArea(new Dimension(5, 10)));
      h_box1.add(new JLabel("Label1"));
      h_box1.add(Box.createRigidArea(new Dimension(5, 10)));
      h_box1.add(new JLabel("Label2"));
      add(h_box1);

      h_box2 = new JPanel();
      h_box2.setLayout(new BoxLayout(h_box2, BoxLayout.LINE_AXIS));
      h_box2.add(new JLabel("Label3"));
      h_box2.add(Box.createRigidArea(new Dimension(5, 10)));
      h_box2.add(new JButton("Bottone B"));
      add(h_box2);

      JTextField t = new JTextField("TextField", 5);
      t.setPreferredSize(new Dimension(200, 15));
      add(t);

      setSize(300, 300);
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
