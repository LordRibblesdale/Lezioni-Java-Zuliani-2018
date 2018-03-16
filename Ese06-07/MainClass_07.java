public class MainClass_07 {
   public static void mostraValore(Valutabile v) {
      System.out.println(v.valuta());
   }

   public static void main(String[] args) {
      Bottino bottino = new Bottino(50, (float)(0.20));
      Borsello borsello = new Borsello(5, 44, 116);
      Valutabile zero = new Valutabile() {
         public int valuta() {
            return 0;
         }
      };

      Valutabile[] array = new Valutabile[4];
      array[0] = bottino;
      array[1] = borsello;
      array[2] = zero;
      array[3] = new Borsello(5, 10, 15) {
         public int valuta() {
            return (monete_oro*125) + (monete_argento*25) + (monete_bronzo*5);
         }
      };

      for (int i = 0; i < array.length; i++) {
         mostraValore(array[i]);
      }
   }
}
