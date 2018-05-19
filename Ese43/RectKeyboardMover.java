import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class RectKeyboardMover extends JFrame {
   class ExtendedPanel extends JPanel {
      Rectangle2D controlled, goal, i;

      ExtendedPanel() {
         controlled = new Rectangle2D.Double(10, 10, 50, 75);
         goal = new Rectangle2D.Double(60, 40, 100, 22);
         i = new Rectangle2D.Double();
      }

      public void paintComponent(Graphics g) {
         super.paintComponent(g);

         ((Graphics2D) g).setPaint(Color.RED);
         ((Graphics2D) g).draw(controlled);
         ((Graphics2D) g).fill(controlled);

         ((Graphics2D) g).setPaint(Color.GREEN);
         ((Graphics2D) g).draw(goal);
         ((Graphics2D) g).fill(goal);

         Rectangle2D.intersect(controlled, goal, i);

         if (i.getWidth() > 0 && i.getHeight() > 0) {
            ((Graphics2D) g).setPaint(Color.BLACK);
            ((Graphics2D) g).fill(i);
         }
      }
   }

   private ExtendedPanel ep;

   RectKeyboardMover() {
      ep = new ExtendedPanel();
      ep.setFocusable(true);

      ep.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
               case KeyEvent.VK_W:
               case KeyEvent.VK_UP:
                  ep.controlled.setFrame(ep.controlled.getX(), ep.controlled.getY()-5, ep.controlled.getWidth(), ep.controlled.getHeight());
                  break;
               case KeyEvent.VK_A:
               case KeyEvent.VK_LEFT:
                  ep.controlled.setFrame(ep.controlled.getX()-5, ep.controlled.getY(), ep.controlled.getWidth(), ep.controlled.getHeight());
                  break;
               case KeyEvent.VK_S:
               case KeyEvent.VK_DOWN:
                  ep.controlled.setFrame(ep.controlled.getX(), ep.controlled.getY()+5, ep.controlled.getWidth(), ep.controlled.getHeight());
                  break;
               case KeyEvent.VK_D:
               case KeyEvent.VK_RIGHT:
                  ep.controlled.setFrame(ep.controlled.getX()+5, ep.controlled.getY(), ep.controlled.getWidth(), ep.controlled.getHeight());
                  break;
            }

            ep.repaint();
         }
      });

      add(ep);

      setResizable(false);
      setSize(500, 500);
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args) {
      RectKeyboardMover r = new RectKeyboardMover();
   }
}
