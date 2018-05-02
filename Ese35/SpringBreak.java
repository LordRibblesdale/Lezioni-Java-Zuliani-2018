import javax.swing.*;
import java.awt.*;

public class SpringBreak extends JFrame {
   private JTextField t1, t2, t3, t4;

   SpringBreak() {
      SpringLayout l = new SpringLayout();
      setLayout(l);

      t1 = new JTextField("T1", 20);
      t2 = new JTextField("T2", 20);
      t3 = new JTextField("T3", 20);
      t4 = new JTextField("T4", 20);
      //TODO: fix repeat

      l.putConstraint(SpringLayout.WEST, t1, 5, SpringLayout.WEST, getContentPane());
      l.putConstraint(SpringLayout.NORTH, t1, 5, SpringLayout.NORTH, getContentPane());

      l.putConstraint(SpringLayout.WEST, t2, 5, SpringLayout.EAST, t1);
      //l.putConstraint(SpringLayout.EAST, t2, 5, SpringLayout.EAST, getContentPane());
      l.putConstraint(SpringLayout.NORTH, t2, 5, SpringLayout.SOUTH, t1);

      l.putConstraint(SpringLayout.WEST, t3, 5, SpringLayout.WEST, getContentPane());
      l.putConstraint(SpringLayout.SOUTH, t3, 20, SpringLayout.SOUTH, t2);
      //l.putConstraint(SpringLayout.SOUTH, t3, 0, SpringLayout.NORTH, t4);

      l.putConstraint(SpringLayout.NORTH, t4, 20, SpringLayout.SOUTH, t2);
      //l.putConstraint(SpringLayout.EAST, t4, 5, SpringLayout.EAST, getContentPane());
      l.putConstraint(SpringLayout.WEST, t4, 5, SpringLayout.EAST, t3);

      add(t1);
      add(t2);
      add(t3);
      add(t4);

      setSize(500, 500);
      setLocationRelativeTo(null);
      setVisible(true);
      //setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args) {
      SpringBreak s = new SpringBreak();
   }
}
