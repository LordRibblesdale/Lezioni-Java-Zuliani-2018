import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class RotatingCircle extends JFrame {
   class ExtendedPanel extends JPanel {
      Ellipse2D red, green;

      ExtendedPanel() {
         red = new Ellipse2D.Double(60, 40, 20, 20);
         green = new Ellipse2D.Double(100, 10, 20, 20);
      }

      public void paintComponent(Graphics g) {
         super.paintComponent(g);

         ((Graphics2D) g).draw(red);
         ((Graphics2D) g).draw(green);
      }
   }

   private ExtendedPanel p;
   private Timer t;
   private double x = 0, y = 0, theta = 0.57;

   RotatingCircle() {
      p = new ExtendedPanel();
      p.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
               p.red.setFrame(e.getX() - p.red.getWidth()/2, e.getY() - p.red.getHeight()/2, p.red.getWidth(), p.red.getHeight());
            } else if (e.getButton() == MouseEvent.BUTTON3) {
               p.red.setFrame(e.getX() - p.red.getWidth()/2, e.getY() - p.red.getHeight()/2, p.red.getWidth(), p.red.getHeight());
            }

            p.repaint();
         }
      });

      t = new Timer(50, new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            x = p.green.getX() - p.red.getX();
            y = p.green.getY() - p.red.getY();

            x = Math.cos(theta)*x - Math.sin(theta)*y;
            y = Math.cos(theta)*x + Math.sin(theta)*y;

            x += p.red.getX();
            y += p.red.getY();

            p.green.setFrame(x, y, p.green.getWidth(), p.green.getHeight());

            p.repaint();
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
