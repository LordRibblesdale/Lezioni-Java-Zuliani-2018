import java.lang.StringBuilder;

public class DigitStamper {
   protected int numero, id;
   protected char c;

   DigitStamper(int number, int id, char c) {
      numero = number;
      this.id = id;
      this.c = c;
   }

   public void randomise() {
      numero = ((int)Math.floor(Math.random()*90000) + 10000);
   }

   public void maskedStamp() {
      StringBuilder tmp = new StringBuilder(String.valueOf(numero));

      for (int i = 0; i < tmp.length(); i++) {
         if (tmp.charAt(i) == String.valueOf(id).charAt(0)) {
            tmp.setCharAt(i, c);
         }
      }

      System.out.println(tmp.toString());
   }

   public void stamp() {
      System.out.println(this.toString());
   }

   public String toString() {
      return "Numero = " + numero;
   }
}
