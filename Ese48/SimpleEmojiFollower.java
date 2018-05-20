import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
import java.awt.geom.*;

class SimpleEmojiFollower extends JFrame {
   class ExtendedPanel extends JPanel {
      ExactMoveableSimpleEmoji m;
      Timer t;
      Point2D point;
      double x, y;

      ExtendedPanel() {
         m = new ExactMoveableSimpleEmoji(new Rectangle2D.Double(getX() + getWidth()/2, getY() + getHeight()/2, 120, 96));
         t = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if ((m.face.getX() + m.face.getWidth() ) >= getWidth()) { //getMaxX??
                  x = -m.getDirection().getX();
               } else if (m.r.getX() <= 0) {
                  x = m.direction.getX();
               }

               if ((m.face.getY() + m.face.getHeight()) >= getHeight()) { //getMaxX??
                  y = -m.direction.getY();
               } else if (m.face.getY() <= 0) {
                  y = m.direction.getY();
               }

               m.setDirection((point = new Point2D.Double(x, y)));

               m.move();
               repaint();
            }
         });

         x = m.getDirection().getX();
         y = m.getDirection().getY();
      }

      public void paintComponent(Graphics g) {
         super.paintComponent(g);

         m.draw((Graphics2D) g);
      }
   }

   private ExtendedPanel ep;

   SimpleEmojiFollower() {
      ep = new ExtendedPanel();
      ep.setFocusable(true);

      ep.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent arg0) {
            ep.m.setDirection(new Point2D.Double(arg0.getX() - ep.m.face.getCenterX(), arg0.getY() - ep.m.face.getCenterY()));
            ep.m.setSpeed((float) ep.m.n/10);
            ep.x = ep.m.getDirection().getX();
            ep.y = ep.m.getDirection().getY();
            ep.t.start();
         }
      });

      ep.requestFocusInWindow();
      add(ep);

      setResizable(false);
      setSize(500, 700);
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args) {
      SimpleEmojiFollower s = new SimpleEmojiFollower();
   }
}
