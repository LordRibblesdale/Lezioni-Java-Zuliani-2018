import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PanelKeyboardMover extends JFrame {
   private JPanel focus;

   PanelKeyboardMover() {
      setLayout(null);

      focus = new JPanel();
      focus.setBounds(50, 50, 8, 8);
      focus.setBackground(Color.BLACK);
      focus.setFocusable(true);
      focus.requestFocus(false);

      focus.addKeyListener(new KeyListener(){
         public void keyTyped(KeyEvent arg0) {

         }

         public void keyReleased(KeyEvent arg0) {

         }

         public void keyPressed(KeyEvent arg0) {
            switch (arg0.getKeyCode()) {
               case KeyEvent.VK_W:
                  focus.setBounds(focus.getX(), focus.getY()-1, focus.getWidth(), focus.getHeight()+1);
                  break;
               case KeyEvent.VK_A:
                  focus.setBounds(focus.getX()-1, focus.getY(), focus.getWidth()+1, focus.getHeight());
                  break;
               case KeyEvent.VK_S:
                  focus.setBounds(focus.getX(), focus.getY(), focus.getWidth(), focus.getHeight()+1);
                  break;
               case KeyEvent.VK_D:
                  focus.setBounds(focus.getX(), focus.getY(), focus.getWidth()+1, focus.getHeight());
                  break;
               case KeyEvent.VK_R:
                  focus.setBackground(Color.RED);
                  break;
               case KeyEvent.VK_G:
                  focus.setBackground(Color.GREEN);
                  break;
               case KeyEvent.VK_B:
                  focus.setBackground(Color.BLUE);
                  break;
               case KeyEvent.VK_C:
                  focus.setBackground(Color.CYAN);
                  break;
               case KeyEvent.VK_M:
                  focus.setBackground(Color.MAGENTA);
                  break;
               case KeyEvent.VK_Y:
                  focus.setBackground(Color.YELLOW);
                  break;
               case KeyEvent.VK_K:
                  focus.setBackground(Color.BLACK);
                  break;
               case KeyEvent.VK_UP:
                  focus.setBounds(focus.getX(), focus.getY()-1, focus.getWidth(), focus.getHeight());
                  break;
               case KeyEvent.VK_DOWN:
                  focus.setBounds(focus.getX(), focus.getY()+1, focus.getWidth(), focus.getHeight());
                  break;
               case KeyEvent.VK_LEFT:
                  focus.setBounds(focus.getX()-1, focus.getY(), focus.getWidth(), focus.getHeight());
                  break;
               case KeyEvent.VK_RIGHT:
                  focus.setBounds(focus.getX()+1, focus.getY(), focus.getWidth(), focus.getHeight());
                  break;
            }
            repaint();
         }
      });

      add(focus);

      setResizable(false);
      setSize(500, 500);
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args) {
      PanelKeyboardMover p = new PanelKeyboardMover();
   }
}
