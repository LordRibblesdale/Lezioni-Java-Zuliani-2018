import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class CircleDragger extends JFrame {
   class ExtendedPanel extends JPanel {
      Rectangle2D goal;
      Ellipse2D circle;

      ExtendedPanel() {
         goal = new Rectangle2D.Double(40, 40, 150, 60);
         circle = new Ellipse2D.Double(100, 100, 100, 40);
      }

      public void paintComponent(Graphics g) {
         super.paintComponent(g);

         ((Graphics2D) g).setPaint(Color.CYAN);
         ((Graphics2D) g).draw(goal);
         ((Graphics2D) g).fill(goal);

         ((Graphics2D) g).setPaint(Color.GREEN);
         ((Graphics2D) g).draw(circle);
         ((Graphics2D) g).fill(circle);

         if (goal.contains(circle.getFrame())) {
            setBackground(Color.WHITE);
            repaint();
         }
      }
   }

   private ExtendedPanel ep;

   CircleDragger() {
      ep = new ExtendedPanel();
      ep.setFocusable(true);

      ep.addMouseMotionListener(new MouseMotionListener() {
         public void mouseDragged(MouseEvent e) {
            if (ep.circle.contains(e.getPoint())) {
               ep.circle.setFrame(e.getX() - ep.circle.getWidth()/2, e.getY() - ep.circle.getHeight()/2, ep.circle.getWidth(), ep.circle.getHeight());
            } else {
               //ep.circle.setFrame(e.getX() +  , , ep.circle.getWidth(), ep.circle.getHeight());
            }

            ep.repaint();
         }

         public void mouseMoved(MouseEvent e) {
            System.out.println(e.getPoint() +
                                 "\nDistance: X: " + Math.abs(e.getX() - ep.circle.getCenterX()) +
                                 " Y: " + Math.abs(e.getY() - ep.circle.getCenterY()));
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
      CircleDragger c = new CircleDragger();
   }
}
