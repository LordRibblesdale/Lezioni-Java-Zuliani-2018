import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GroupOn extends JFrame {
   private JButton a, b;
   private JLabel l1, l2, l3;
   private JTextField t;

   GroupOn() {
      GroupLayout l = new GroupLayout(getContentPane());
      setLayout(l);
      l.setAutoCreateGaps(true);
      l.setAutoCreateContainerGaps(true);

      GroupLayout.SequentialGroup h = l.createSequentialGroup();
      h.addGroup(l.createParallelGroup(GroupLayout.Alignment.TRAILING).
                  addComponent(a = new JButton("Bottone A")).
                  addComponent(l3 = new JLabel("Label3")));

      h.addGroup(l.createParallelGroup(GroupLayout.Alignment.TRAILING).
                  addComponent(l1 = new JLabel("Label1")).
                  addComponent(t = new JTextField("TextField", 10)));

      h.addGroup(l.createParallelGroup(GroupLayout.Alignment.TRAILING).
                  addComponent(l2 = new JLabel("Label2")).
                  addComponent(b = new JButton("Bottone B")));

      l.setHorizontalGroup(h);

      GroupLayout.SequentialGroup v = l.createSequentialGroup();
      v.addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE).
                  addComponent(a).
                  addComponent(l1).
                  addComponent(l2));

      v.addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE).
                  addComponent(l3).
                  addComponent(b));

      v.addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE).
                  addComponent(t));

      l.setVerticalGroup(v);

      setSize(300, 300);
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
