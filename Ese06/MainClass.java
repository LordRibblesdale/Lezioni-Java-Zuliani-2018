public class MainClass {
   public static void mostraValore(Valutabile v) {
      System.out.println(v.valuta());
   }

   public static void main(String[] args) {
      Bottino bottino = new Bottino(50, (float)(0.20));
      Borsello borsello = new Borsello(5, 44, 116);

      mostraValore(bottino);
      mostraValore(borsello);
   }
}
