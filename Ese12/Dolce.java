public abstract class Dolce {
   private String nome;

   Dolce() {
      nome = "NoName";
   }

   Dolce(String name) {
      nome = name;
   }

   public abstract String descrizione();

   public String toString() {
      return nome;
   }
}
