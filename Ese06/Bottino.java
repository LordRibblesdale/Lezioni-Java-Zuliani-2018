public class Bottino implements Valutabile {
   private int quantita;
   private float rarita;

   Bottino(int quantity, float rarity) {
      quantita = quantity;
      rarita = rarity;
   }

   public int valuta() {
      return (int)(quantita*rarita);
   }
}
