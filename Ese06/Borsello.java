public class Borsello implements Valutabile {
   private int monete_oro, monete_argento, monete_bronzo;

   Borsello(int gold, int silver, int copper) {
      monete_oro = gold;
      monete_argento = silver;
      monete_bronzo = copper;
   }

   public int valuta() {
      return (monete_oro*100) + (monete_argento*10) + (monete_bronzo);
   }
}
