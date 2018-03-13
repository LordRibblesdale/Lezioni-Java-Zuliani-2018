public class Cioccolatino extends Merendina {
   private int dimensioneConfezione;

   Cioccolatino() {
      super();
      dimensioneConfezione = 0;
   }

   Cioccolatino(String name, String brand, int price, int packageDimension) {
      super(name, brand, price);
      dimensioneConfezione = packageDimension;
   }

   public String descrizione() {
      return "Pacco da " + dimensioneConfezione + " di [\n"
              + super.descrizione() + "]\nPrezzo totale: "
              + dimensioneConfezione*getPrezzo();
   }
}
