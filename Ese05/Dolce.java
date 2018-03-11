public abstract class Dolce {
   String nome;

   Dolce() {
      nome = "NoName";
   }

   Dolce(String name) {
      nome = name;
   }

   public String descrizione() {
      //abstract method
   }

   public String toString() {
      return nome;
   }
}
