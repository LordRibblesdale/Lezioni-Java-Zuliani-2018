import java.awt.event.*;

public class Cronometro implements ActionListener {
   protected int ore, minuti, secondi, centDiSecondi; //protected inteso come private?

   Cronometro() {
      ore = 0;
      minuti = 0;
      secondi = 0;
      centDiSecondi = 0;
   }

   public void actionPerformed(ActionEvent e) {
      centDiSecondi += 25;
      if (centDiSecondi == 100) {
         secondi++;
         centDiSecondi = 0;
      }
      if (secondi == 60) {
         minuti++;
         secondi = 0;
      }
      if (minuti == 60) {
         ore++;
         minuti = 0;
      }

      System.out.printf("\nOrario: %d:%d:%d:%d", ore, minuti, secondi, centDiSecondi);
   }
}
