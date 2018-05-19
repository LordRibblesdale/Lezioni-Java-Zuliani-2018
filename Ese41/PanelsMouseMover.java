import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelsMouseMover extends JFrame {
   private JPanel blu, yellow;

   PanelsMouseMover() {
      setLayout(null);

      blu = new JPanel();
      blu.setBounds(0, 0, 50, 50);
      blu.setBackground(Color.BLUE);

      yellow = new JPanel();
      yellow.setBounds(0, getHeight(), 50, 50);
      yellow.setBackground(Color.YELLOW);

      addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent arg0) {
            System.out.println(arg0.getPoint());
         }

         public void mouseDragged(MouseEvent arg0) {
            if ((arg0.getModifiersEx() & arg0.BUTTON1_DOWN_MASK) == arg0.BUTTON1_DOWN_MASK) {
               blu.setBounds(arg0.getX(), arg0.getY(), blu.getWidth(), blu.getHeight());
               validate();
            } else if ((arg0.getModifiersEx() & arg0.BUTTON3_DOWN_MASK) == arg0.BUTTON3_DOWN_MASK) {
               yellow.setBounds(arg0.getX(), arg0.getY(), yellow.getWidth(), yellow.getHeight());
               validate();
            }
         }
      });

      addMouseWheelListener(new MouseWheelListener() {
         public void mouseWheelMoved(MouseWheelEvent arg0) {
            if (arg0.isShiftDown()) {
               if (arg0.getWheelRotation() > 0) {
                  blu.setBounds(blu.getX()-5, blu.getY()-5, blu.getWidth()+10, blu.getHeight()+10);
                  validate();
               } else if (arg0.getWheelRotation() < 0){
                  blu.setBounds(blu.getX()+5, blu.getY()+5, blu.getWidth()-10, blu.getHeight()-10);
                  validate();
               }
            } else if (arg0.isControlDown()) {
               if (arg0.getWheelRotation() > 0) {
                  yellow.setBounds(yellow.getX()-5, yellow.getY()-5, yellow.getWidth()+10, yellow.getHeight()+10);
                  validate();
               } else if (arg0.getWheelRotation() < 0){
                  yellow.setBounds(yellow.getX()+5, yellow.getY()+5, yellow.getWidth()-10, yellow.getHeight()-10);
                  validate();
               }
            }
         }
      });

      add(blu);
      add(yellow);


      setResizable(false);
      setSize(500, 500);
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args) {
      PanelsMouseMover p = new PanelsMouseMover();
   }
}
