import javax.swing.*;
import javax.swing.Timer;

public class MainClass {
   public static void main(String[] args) {
      Gestore manager = new Gestore();
      Timer timer = new Timer(500, manager);
      timer.start();

      JOptionPane.showMessageDialog(null, "Close?");
      System.exit(0);
   }
}
