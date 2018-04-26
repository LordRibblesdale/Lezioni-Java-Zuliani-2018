import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CenterCard extends JFrame {
   private JLabel label;
   private JButton button;
   private JPanel panel;
   private int n = 0;

   CenterCard() {
      setLayout(new BorderLayout(5, 5));

      label = new JLabel("Visualizzatore foto");
      add(label, BorderLayout.PAGE_START);

      panel = new JPanel(new CardLayout()); //CardLayout included here

      for (int i = 0; i < 5; i++) {
         JPanel p = new JPanel();
         p.add(new JLabel(new ImageIcon(getClass().getResource("img" + i + ".jpeg"))));
         panel.add(p, "img" + i);
      }

      add(panel, BorderLayout.CENTER);

      button = new JButton("Cambia foto");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (n > 4) {
               n = 0;
            }
            //CardLayout layout = (CardLayout)panel.getLayout();
            //layout.show(panel, "img" + n++);
            ((CardLayout)panel.getLayout()).show(panel, "img" + n++);
         }
      });

      add(button, BorderLayout.PAGE_END);

      setSize(500, 500);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
}
