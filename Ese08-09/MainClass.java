import javax.swing.*;
import javax.swing.Timer;

public class MainClass {
   public static void main(String[] args) {
      Cronometro clock = new Cronometro();   //listener
      Timer tick = new Timer(250, clock);
      tick.start();

      JOptionPane.showMessageDialog(null, "Chiudere?");
		System.exit(0);
   }
}
