import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.Timer;

public class RotatingCircle extends JFrame {
   class ExtendedPanel extends JPanel {
      Ellipse2D red, green, blue;

      ExtendedPanel() {
         red = new Ellipse2D.Double(250, 250, 20, 20);
         green = new Ellipse2D.Double(300, 250, 20, 20);
         blue = new Ellipse2D.Double(green.getX() + green.getWidth() + 5, green.getY() + green.getHeight() + 5, green.getWidth(), green.getHeight());
      }

      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         Graphics2D g2 = (Graphics2D) g;

         g2.setPaint(Color.RED);
         g2.draw(red);
         g2.setPaint(Color.GREEN);
         g2.draw(green);
         g2.setPaint(Color.BLUE);
         g2.draw(blue);
      }
   }

   private ExtendedPanel p;
   private Timer t;

   private double x = 0, y = 0, theta = -(50/1000.0);

   RotatingCircle() {
      p = new ExtendedPanel();

      t = new Timer(50, new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            double initialX;

            x = p.green.getCenterX() - p.red.getCenterX();
            y = p.green.getCenterY() - p.red.getCenterY();

            initialX = x;

            x = Math.cos(theta)*x - Math.sin(theta)*y;
            y = Math.sin(theta)*initialX + Math.cos(theta)*y;

            x += p.red.getCenterX();
            y += p.red.getCenterY();

            p.green.setFrameFromCenter(x, y, x + p.green.getWidth()/2, y + p.green.getHeight()/2);

            x = p.blue.getCenterX() - p.green.getCenterX();
            y = p.blue.getCenterY() - p.green.getCenterY();

            initialX = x;

            x = Math.cos(theta)*x - Math.sin(theta)*y;
            y = Math.sin(theta)*initialX + Math.cos(theta)*y;

            x += p.green.getCenterX();
            y += p.green.getCenterY();

            p.blue.setFrameFromCenter(x, y, x + p.blue.getWidth()/2, y + p.blue.getHeight()/2);

            x = p.blue.getCenterX() - p.red.getCenterX();
            y = p.blue.getCenterY() - p.red.getCenterY();

            initialX = x;

            x = Math.cos(theta)*x - Math.sin(theta)*y;
            y = Math.sin(theta)*initialX + Math.cos(theta)*y;

            x += p.red.getCenterX();
            y += p.red.getCenterY();

            p.blue.setFrameFromCenter(x, y, x + p.blue.getWidth()/2, y + p.blue.getHeight()/2);

            p.repaint();
            Toolkit.getDefaultToolkit().sync();
         }
      });

      t.start();

      p.requestFocusInWindow();
      add(p);

      setResizable(false);
      setSize(500, 700);
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args) {
      RotatingCircle r = new RotatingCircle();
   }
}
