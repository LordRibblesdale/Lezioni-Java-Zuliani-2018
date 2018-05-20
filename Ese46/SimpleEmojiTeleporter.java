import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

class SimpleEmojiTeleporter extends JFrame {
   class ExtendedPanel extends JPanel {
      ReframeableSimpleEmoji r;

      ExtendedPanel() {
         r = new ReframeableSimpleEmoji(new Rectangle2D.Double(getX() + getWidth()/2, getY() + getHeight()/2, 120, 96));
      }

      public void paintComponent(Graphics g) {
         super.paintComponent(g);

         r.draw((Graphics2D) g);
      }
   }

   private ExtendedPanel ep;

   SimpleEmojiTeleporter() {
      ep = new ExtendedPanel();
      ep.setFocusable(true);

      ep.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {
            ep.r.setFrame(new Rectangle2D.Double(e.getX()-60, e.getY()-48, 120, 96));

            switch (e.getButton()) {
               case MouseEvent.BUTTON1:
                  ep.r.setFaceColor(Color.YELLOW);
                  ep.r.setEyesColor(Color.BLACK);
                  break;
               case MouseEvent.BUTTON2:
                  ep.r.setFaceColor(Color.GREEN);
                  ep.r.setEyesColor(Color.RED);
                  break;
               case MouseEvent.BUTTON3:
                  ep.r.setFaceColor(Color.BLACK);
                  ep.r.setEyesColor(Color.WHITE);
                  break;
            }

            ep.repaint();
         }
      });

      ep.requestFocusInWindow();
      add(ep);

      setResizable(false);
      setSize(500, 500);
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args) {
      SimpleEmojiTeleporter s = new SimpleEmojiTeleporter();
   }
}
