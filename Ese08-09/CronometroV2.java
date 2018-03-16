import java.awt.event.*;

public class CronometroV2 extends Cronometro {
   private int centsPerTick;

   CronometroV2() {
      super();
      centsPerTick = 25;
   }

   CronometroV2(int centsPerTick) {
      super();
      this.centsPerTick = centsPerTick;
   }

   public int getCentsPerTick() {
      return centsPerTick;
   }

   public void actionPerformed(ActionEvent e) {
      centDiSecondi += centsPerTick;
      if (centDiSecondi >= 100) {
         secondi += (int)(centDiSecondi/100);
         centDiSecondi -= ((int)(centDiSecondi/100)*100) ;
      }
      if (secondi >= 60) {
         minuti += (int)(secondi/60);
         secondi -= ((int)(secondi/60)*60);
      }
      if (minuti >= 60) {
         ore += (int)(minuti/60);
         minuti -= ((int)(minuti/60)*60);
      }

      System.out.printf("\nOrario: %d:%d:%d:%d", ore, minuti, secondi, centDiSecondi);
   }
}
