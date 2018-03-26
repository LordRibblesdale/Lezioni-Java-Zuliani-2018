enum NomeColore {
   Rosso,
   Verde,
   Blu,
   Giallo,
   Nero,
   Bianco,
   Grigio,
   Marrone,
   Arancione,
   Viola
}

public class Mattoncino {
   private int altezza, larghezza;
   private NomeColore colore;

   Mattoncino(int height, int width, NomeColore color) {
      altezza = height;
      larghezza = width;
      colore = color;
   }

   public int getAltezza() {
      return altezza;
   }

   public void setAltezza(int height) {
      altezza = height;
   }

   public int getLarghezza() {
      return larghezza;
   }

   public void setLarghezza(int width) {
      larghezza = width;
   }

   public NomeColore getColore() {
      return colore;
   }

   public void setColore(NomeColore color) {
      switch (color) {
         case Rosso:
         case Verde:
         case Blu:
         case Giallo:
         case Nero:
         case Bianco:
         case Grigio:
         case Marrone:
         case Arancione:
         case Viola:
            colore = color;
            break;
         default:
            System.out.println("Error: color not found.");
      }
   }
}
