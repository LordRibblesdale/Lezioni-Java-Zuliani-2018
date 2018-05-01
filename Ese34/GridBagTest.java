import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridBagTest extends JFrame {
      GridBagTest() {
         setLayout(new GridBagLayout());

         GridBagConstraints c = new GridBagConstraints();
         c.gridx = 0;
         c.gridy = 0;
         add(new JButton("Bottone A"), c);

         c = new GridBagConstraints();
         c.gridx = 1;
         c.gridy = 0;
         c.insets = new Insets(5, 5, 5, 5);
         add(new JLabel("Label1"), c);

         c = new GridBagConstraints();
         c.gridx = 2;
         c.gridy = 0;
         c.insets = new Insets(5, 5, 5, 5);
         add(new JLabel("Label2"), c);

         c = new GridBagConstraints();
         c.gridx = 0;
         c.gridy = 1;
         c.insets = new Insets(5, 5, 5, 5);
         add(new JLabel("Label3"), c);

         c = new GridBagConstraints();
         c.gridx = 0;
         c.gridy = 2;
         c.fill = GridBagConstraints.HORIZONTAL;
         c.gridwidth = 2;
         c.insets = new Insets(5, 5, 5, 5);
         add(new JTextField("TextField"), c);

         c = new GridBagConstraints();
         c.gridx = 2;
         c.gridy = 1;
         c.fill = GridBagConstraints.VERTICAL;
         c.gridheight = 2;
         c.insets = new Insets(5, 5, 5, 5);
         add(new JButton("Bottone B"), c);

         setSize(300, 300);
         setLocationRelativeTo(null);
         setVisible(true);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
}
