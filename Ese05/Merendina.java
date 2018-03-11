public class Merendina extends Dolce {
   String marca;
   int prezzo;

   Merendina() {
      super();
      marca = "NoName";
      prezzo = 0;
   }

   Merendina(String name, String brand, int price) {
      super(name);
      marca = brand;
      prezzo = price;
   }

   public String descrizione() {
      return "Nome: " + super.toString() + "\nMarca: " + marca + "\nPrezzo: " + prezzo;
   }

   public String toString() {
      return descrizione();
   }
}
