import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterpolationTest extends JFrame {
   private JColorChooser[] c = new JColorChooser[2];
   private JButton[] b = new JButton[2];
   private JScrollPane gradient;
   private JTabbedPane t;
   private JPanel panel, panel0, panel1, pane[] = new JPanel[10];
   private BoxLayout box;
   private int r, g, bl;

   InterpolationTest() {
      t = new JTabbedPane();
      (panel0 = new JPanel()).add(c[0] = new JColorChooser(Color.ORANGE));
      panel0.add((b[0] = new JButton("X Change")), BorderLayout.PAGE_END);
      t.addTab("Colore A", panel0);
      (panel1 = new JPanel()).add(c[1] = new JColorChooser(Color.PINK));
      panel1.add((b[1] = new JButton("Y Change")), BorderLayout.PAGE_END);
      t.addTab("Colore B", panel1);

      ActionListener l = new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < pane.length; i++) {
               r = (1 - (i/pane.length))*c[0].getColor().getRed() + (i/pane.length)*c[1].getColor().getRed();
               g = (1 - (i/pane.length))*c[0].getColor().getGreen() + (i/pane.length)*c[1].getColor().getGreen();
               bl = (1 - (i/pane.length))*c[0].getColor().getBlue() + (i/pane.length)*c[1].getColor().getBlue();
               pane[i].setBackground(new Color(r, g, bl));
            }
            validate();
         }
      };

      b[0].addActionListener(l);
      b[1].addActionListener(l);

      (gradient = new JScrollPane(panel = new JPanel())).setViewportView(panel);
      panel.setLayout(box = new BoxLayout(panel, BoxLayout.PAGE_AXIS));
      gradient.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      gradient.getVerticalScrollBar().setUnitIncrement(10);

      for (int i = 0; i < pane.length; i++) {
         r = ((1 - (i/pane.length))*c[0].getColor().getRed() + (i/pane.length)*c[1].getColor().getRed());
         g = ((1 - (i/pane.length))*c[0].getColor().getGreen() + (i/pane.length)*c[1].getColor().getGreen());
         bl = ((1 - (i/pane.length))*c[0].getColor().getBlue() + (i/pane.length)*c[1].getColor().getBlue());
         (pane[i] = new JPanel()).setPreferredSize(new Dimension(400, 150));
         pane[i].setBackground(new Color(r, g, bl));

         panel.add(pane[i]);
         panel.add(Box.createRigidArea(new Dimension(0, 5)));
      }

      t.addTab("Gradiente", gradient);
      add(t);

      setSize(500, 500);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }

   public static void main(String[] args) {
      InterpolationTest i = new InterpolationTest();
   }
}
