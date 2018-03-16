import javax.swing.*;
import javax.swing.Timer;
import java.util.Scanner;

public class MainClass09 {
   public static void main(String[] args) {
      CronometroV2[] clock = new CronometroV2[3];
      Timer[] timer = new Timer[3];
      Scanner in = new Scanner(System.in);

      for (int i = 0; i < clock.length; i++) {
         System.out.printf("Insert a value for clock%d: ", i+1);
         clock[i] = new CronometroV2(in.nextInt());
         timer[i] = new Timer(10*clock[i].getCentsPerTick(), clock[i]);
      }

      for (int i = 0; i < clock.length; i++) {
         timer[i].start();
         JOptionPane.showMessageDialog(null, ("Terminare clock" + (i+1) + "?"));
         timer[i].stop();
      }
		System.exit(0);
   }
}
