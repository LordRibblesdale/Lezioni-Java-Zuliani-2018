import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

class SimpleEmojiColorChanger extends JFrame {
   class ExtendedPanel extends JPanel {
      SimpleEmoji em;
      Color[] array = {Color.BLACK, Color.RED, Color.GREEN, Color.BLUE,
                                 Color.CYAN, Color.MAGENTA, Color.YELLOW};
      private int i = 0;

      ExtendedPanel() {
         em = new SimpleEmoji(new Rectangle2D.Double(30, 60, 120, 96));
      }

      public void paintComponent(Graphics g) {
         super.paintComponent(g);

         em.draw((Graphics2D) g);
      }

      public int getInt() {
         return i;
      }

      public void setInt(int i) {
         if (i < 0) {
            i = array.length-1;
         } else if (i > array.length-1) {
            i = 0;
         }
         this.i = i;
      }
   }

   private ExtendedPanel ep;

   SimpleEmojiColorChanger() {
      ep = new ExtendedPanel();
      ep.setFocusable(true);

      ep.addMouseWheelListener(new MouseWheelListener() {
         public void mouseWheelMoved(MouseWheelEvent arg0) {
            if (arg0.getScrollAmount() < 0) {
               ep.setInt(ep.getInt()-1);
            } else if (arg0.getScrollAmount() > 0) {
               ep.setInt(ep.getInt()+1);
            }

            ep.em.setEyesColor(ep.array[ep.getInt()]);
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
      SimpleEmojiColorChanger s = new SimpleEmojiColorChanger();
   }
}
