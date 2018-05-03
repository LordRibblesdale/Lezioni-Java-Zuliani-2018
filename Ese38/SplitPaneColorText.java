import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SplitPaneColorText extends JFrame {
   private JSplitPane s;
   private JTextArea t;
   private JPanel pane, rgbPanel, fbGroundPanel;
   private JCheckBox r, g, bl;
   private JRadioButton f, b;
   private ButtonGroup group = new ButtonGroup();
   private JButton a;

   SplitPaneColorText() {
      (rgbPanel = new JPanel()).add((r = new JCheckBox("R")));
      rgbPanel.add((g = new JCheckBox("G")));
      rgbPanel.add((bl = new JCheckBox("B")));
      (pane = new JPanel(new GridLayout(0, 1))).add(rgbPanel);


      group.add((f = new JRadioButton("Foreground")));
      group.add((b = new JRadioButton("Background")));
      ((fbGroundPanel = new JPanel())).add(f);
      fbGroundPanel.add(b);
      pane.add(fbGroundPanel);


      (a = new JButton("Apply")).addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (f.isSelected()) {
               t.setForeground(new Color(r.isSelected() ? 255 : 0, g.isSelected() ? 255 : 0, bl.isSelected() ? 255 : 0));
               validate();
            } else {
               t.setBackground(new Color(r.isSelected() ? 255 : 0, g.isSelected() ? 255 : 0, bl.isSelected() ? 255 : 0));
            }
         }
      });
      pane.add(a);

      s = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pane, (t = new JTextArea("Text Field Color Changer")));
      add(s);

      setSize(500, 500);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }

   public static void main(String[] args) {
      SplitPaneColorText sp = new SplitPaneColorText();
   }
}
