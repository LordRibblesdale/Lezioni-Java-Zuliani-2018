import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

class SimpleEmojiBouncer extends JFrame {
   class ExtendedPanel extends JPanel {
      MoveableSimpleEmoji m;
      Timer t;
      int x = 1, y = 1;

      ExtendedPanel() {
         m = new MoveableSimpleEmoji(new Rectangle2D.Double(getX() + getWidth()/2, getY() + getHeight()/2, 120, 96));
         t = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if ((m.face.getX() + m.face.getWidth() ) >= getWidth()) { //getMaxX??
                  x = -1;
               } else if (m.r.getX() <= 0) {
                  x = 1;
               }

               if ((m.face.getY() + m.face.getHeight()) >= getHeight()) { //getMaxX??
                  y = -1;
               } else if (m.face.getY() <= 0) {
                  y = 1;
               }

               m.setDirection(new Point2D.Double(x, y));

               m.move();
               repaint();
            }
         });
         t.start();
      }

      public void paintComponent(Graphics g) {
         super.paintComponent(g);

         m.draw((Graphics2D) g);
      }
   }

   private ExtendedPanel ep;

   SimpleEmojiBouncer() {
      ep = new ExtendedPanel();
      ep.setFocusable(true);

      ep.requestFocusInWindow();
      add(ep);

      setResizable(false);
      setSize(500, 700);
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args) {
      SimpleEmojiBouncer s = new SimpleEmojiBouncer();
   }
}
