import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FocusablePanel extends JFrame {
   private JPanel green, blue;
   private KeyAdapter k = new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
         if (blue.isFocusOwner()) {
            switch (e.getKeyCode()) {
               case KeyEvent.VK_UP:
                  blue.setLocation(blue.getX(), blue.getY()-5);
                  break;
               case KeyEvent.VK_DOWN:
                  blue.setLocation(blue.getX(), blue.getY()+5);
                  break;
               case KeyEvent.VK_LEFT:
                  blue.setLocation(blue.getX()-5, blue.getY());
                  break;
               case KeyEvent.VK_RIGHT:
                  blue.setLocation(blue.getX()+5, blue.getY());
                  break;
            }
         } else if (green.isFocusOwner()) {
            switch (e.getKeyCode()) {
               case KeyEvent.VK_UP:
                  green.setLocation(green.getX(), green.getY()-5);
                  break;
               case KeyEvent.VK_DOWN:
                  green.setLocation(green.getX(), green.getY()+5);
                  break;
               case KeyEvent.VK_LEFT:
                  green.setLocation(green.getX()-5, green.getY());
                  break;
               case KeyEvent.VK_RIGHT:
                  green.setLocation(green.getX()+5, green.getY());
                  break;
            }
         }

         validate();
      }
   };

   FocusablePanel() {
      setLayout(null);

      green = new JPanel();
      blue = new JPanel();

      green.setBounds(0, 0, 150, 150);
      blue.setBounds(400, 50, 150, 150);

      green.setBackground(Color.GREEN);
      blue.setBackground(Color.BLUE);

      green.setFocusable(true);
      blue.setFocusable(true);
      setFocusable(true);

      green.addKeyListener(k);
      blue.addKeyListener(k);

      green.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {
            green.requestFocusInWindow();
         }
      });
      blue.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {
            blue.requestFocusInWindow();
         }
      });

      add(green);
      add(blue);

      setResizable(false);
      setSize(500, 500);
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args) {
      FocusablePanel f = new FocusablePanel();
   }
}
