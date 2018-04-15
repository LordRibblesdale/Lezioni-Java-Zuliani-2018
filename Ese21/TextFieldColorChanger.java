import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TextFieldColorChanger extends JFrame {
   private JPanel rgbPanel, fbGroundPanel, buttonPanel, tfPanel;
   private JCheckBox r, g, bl;
   private JRadioButton f, b;
   private ButtonGroup group = new ButtonGroup();
   private JTextField t;
   private JButton a;

   TextFieldColorChanger() {
      setLayout(new GridLayout(0, 1));

      rgbPanel = new JPanel();
      r = new JCheckBox("R");
      g = new JCheckBox("G");
      bl = new JCheckBox("B");
      rgbPanel.add(r);
      rgbPanel.add(g);
      rgbPanel.add(bl);
      add(rgbPanel);

      fbGroundPanel = new JPanel();
      f = new JRadioButton("Foreground");
      b = new JRadioButton("Background");
      group.add(f);
      group.add(b);
      fbGroundPanel.add(f);
      fbGroundPanel.add(b);
      add(fbGroundPanel);

      tfPanel = new JPanel();
      t = new JTextField("Text Field Color Changer");
      tfPanel.add(t);
      add(tfPanel);

      buttonPanel = new JPanel();
      a = new JButton("Apply");
      a.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (f.isSelected()) {
               t.setForeground(new Color(r.isSelected() ? 255 : 0, g.isSelected() ? 255 : 0, bl.isSelected() ? 255 : 0));
               validate();
            } else {
               t.setBackground(new Color(r.isSelected() ? 255 : 0, g.isSelected() ? 255 : 0, bl.isSelected() ? 255 : 0));
            }
         }
      });
      buttonPanel.add(a);
      add(buttonPanel);

      setSize(300, 500);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
}
