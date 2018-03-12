public abstract class Dolce {
   String nome;

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
