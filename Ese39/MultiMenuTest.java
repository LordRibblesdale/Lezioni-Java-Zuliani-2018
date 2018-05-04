import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MultiMenuTest extends JFrame {
   private JMenuBar m;
   private JToolBar tb;
   private JTextArea ta;
   private JPopupMenu pm;
   private JMenu jm, color, selection, manage;
   private JSeparator s;
   private ButtonGroup bg;
   private JRadioButton[] rb = new JRadioButton[6];
   private JCheckBox[] cb = new JCheckBox[2];
   private String[] colors = {"Red", "Green", "Blue", "Yellow", "Black", "White"};
   private Color[] colorsC = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.BLACK, Color.WHITE};

   MultiMenuTest() {
      m = new JMenuBar();
      m.add((jm = new JMenu("MainMenu")));
      jm.add((color = new JMenu("Colore")));

      bg = new ButtonGroup();
      for (int i = 0; i < rb.length; i++) {
         bg.add((rb[i] = new JRadioButton(colors[i])));
         color.add(rb[i]);
      }

      jm.add((selection = new JMenu("Selezione")));

      for (int i = 0; i < cb.length; i++) {
         String[] bf = {"Background", "Foreground"};
         selection.add((cb[i] = new JCheckBox(bf[i])));
      }

      jm.add(new JSeparator());

      class Apply extends AbstractAction {
         protected JComponent component;
         Apply(String s, JComponent component) {
            this.component = component;
            putValue(Action.NAME, s);
         }

         public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < rb.length; i++) {
               if (rb[i].isSelected()) {
                  if (cb[0].isSelected()) {
                     component.setBackground(colorsC[i]);
                  }
                  if (cb[1].isSelected()) {
                     component.setForeground(colorsC[i]);
                  }
               }
            }
            validate();
         }
      }

      class Reset extends AbstractAction {
         protected JComponent component;
         Reset(String s, JComponent component) {
            this.component = component;
            putValue(Action.NAME, s);
         }

         public void actionPerformed(ActionEvent ev) {
            component.setBackground(Color.WHITE);
            component.setForeground(Color.BLACK);
            validate();
         }
      }

      jm.setMnemonic(KeyEvent.VK_M);
      selection.setMnemonic(KeyEvent.VK_S);
      cb[0].setMnemonic(KeyEvent.VK_B);
      cb[1].setMnemonic(KeyEvent.VK_F);

      ta = new JTextArea("Menuception");
      Apply apply = new Apply("Applica", ta);
      Reset reset = new Reset("Reset", ta);
      jm.add(apply);
      jm.add(reset);
      setJMenuBar(m);

      ta.add((pm = new JPopupMenu()));
      pm.add(new AbstractAction("Cancella Testo") {
         public void actionPerformed(ActionEvent eve) {
            ta.setText("");
            validate();
         }
      });
      pm.add((manage = new JMenu("Gestisci Colore")));
      manage.add(apply);
      manage.add(reset);
      ta.setComponentPopupMenu(pm);
      add(ta);

      (tb = new JToolBar()).add(apply);
      tb.add(reset);
      add(tb, BorderLayout.PAGE_START);

      setSize(500, 500);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }

   public static void main(String[] args) {
      MultiMenuTest m = new MultiMenuTest();
   }
}
