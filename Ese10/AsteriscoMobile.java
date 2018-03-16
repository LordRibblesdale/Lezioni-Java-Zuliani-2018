import java.awt.event.*;
import javax.swing.Timer;

public class AsteriscoMobile {
   protected int posizione, lunghezzaPercorso, movimento;
   protected Timer t;

   AsteriscoMobile(int length, boolean move) {
      posizione = 0;
      lunghezzaPercorso = length;

      if (move) {
         movimento = 1;
      } else {
         movimento = -1;
      }

      t = new Timer(250, new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            move();
         }
      });

      t.start();
   }

   public void move() {
      draw();
      posizione += movimento;
      if (posizione == 0) {
         movimento = 1;
      } else if (posizione == lunghezzaPercorso-1) {
         movimento = -1;
      }
   }

   public void draw() {
      System.out.print("[");
      for (int i = 0; i < posizione; i++) {
         System.out.print("-");
      }
      System.out.print("*");
      for (int i = posizione+1; i < lunghezzaPercorso; i++) {
         System.out.print("-");
      }
      System.out.println("]");
   }
}
