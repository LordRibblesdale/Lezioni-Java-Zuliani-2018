public class Merendina extends Dolce {
   private String marca;
   private int prezzo;

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

   public int getPrezzo() {
      return prezzo;
   }

   public String descrizione() {
      return "Nome: " + super.toString() + "\nMarca: " + marca + "\nPrezzo: " + prezzo;
   }

   public String toString() {
      return descrizione();
   }
}
