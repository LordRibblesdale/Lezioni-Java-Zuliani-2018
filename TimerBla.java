import javax.swing.Timer;
import java.awt.event.*;
import java.awt.*;

public class TimerBla {
   public static void main(String[] args) {
      Timer t = new Timer(500, new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            System.out.println("Ciao");
         }
      });

      System.out.println("Ciao");

      t.start();
   }
}
