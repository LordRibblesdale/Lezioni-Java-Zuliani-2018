import javax.swing.*;
import javax.swing.Timer;

public class MainClass {
   public static void main(String[] args) {
      AsteriscoMobile movinThing = new AsteriscoMobile(15, true); //true = +1 else -1

      JOptionPane.showMessageDialog(null, "Do you want to close?");
      System.exit(0);
   }
}
