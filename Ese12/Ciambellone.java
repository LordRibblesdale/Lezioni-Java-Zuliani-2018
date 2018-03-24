public class Ciambellone extends Dolce {
   private String[] ingredienti;

   Ciambellone() {
      super();
      ingredienti = new String[1];
      for (int i = 0; i < ingredienti.length; i++) {
         ingredienti[i] = "NoName";
      }
   }

   Ciambellone(String name, String[] ingredients) {
      super(name);
      ingredienti = new String[ingredients.length];
      for (int i = 0; i < ingredienti.length; i++) {
         ingredienti[i] = ingredients[i];
      }
   }

   public String descrizione() {
      String tmp = "\n";
      for (int i = 0; i < ingredienti.length; i++) {
         tmp += ingredienti[i] + "\n";
      }

      return super.toString() + tmp;
   }

   public String toString() {
      return descrizione();
   }
}
