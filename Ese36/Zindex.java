import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Zindex extends JFrame {
   private JLayeredPane l;
   private JButton a;
   private JPanel p;
   private static int n = 1, N = 400, M = 350;
   //private int N = getContentPane().getWidth();
   //private int M = getContentPane().getHeight()-50;
   private Color c;

   Zindex() {
      l = new JLayeredPane();
      l.setPreferredSize(new Dimension(N, M));
      c = new Color(255, 255, 255);
      (p = new JPanel()).setBounds(0, M, N/2, M/2);
      p.setBackground(c);
      l.add(p, new Integer(100));

      (a = new JButton("Aggiungi pannello")).addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            (p = new JPanel()).setBackground((c = new Color((float)Math.random(), (float)Math.random(), (float)Math.random())));
            if (n % 2 == 0) {
               p.setBounds(n*5, M-n*5, N/2, M/2);
               l.add(p, new Integer(100-(n++)));
            } else {
               p.setBounds(n*-5, M+n*5, N/2, M/2);
               l.add(p, new Integer(100+(n++)));
            }
            validate();
         }
      });

      add(a, BorderLayout.PAGE_END);
      add(l, BorderLayout.CENTER);

      setSize(500, 500);
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args) {
      Zindex z = new Zindex();
   }
}
