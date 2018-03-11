import java.util.Scanner;

public class Eser02 {
   public static int generaNumero() {
      int rnd = (int)Math.floor(Math.random()*3)+1, tmp = 0;
      String s = "";
      switch (rnd) {
         case 1:
            s = "333";
            do {
               tmp = (int)Math.floor(Math.random()*999999);
            } while (tmp % 100000 == 0);
            s += tmp;
            break;
         case 2:
            s = "348";
            do {
               tmp = (int)Math.floor(Math.random()*999999);
            } while (tmp % 100000 == 0);
            s += tmp;
            break;
         case 3:
            s = "389";
            do {
               tmp = (int)Math.floor(Math.random()*999999);
            } while (tmp % 100000 == 0);
            s += tmp;
            break;
      }
      return Integer.parseInt(s);
   }

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      Telefono phone = new Telefono("One Plus 5T", "Android OS", (float)(5.7), 8);
      int indx = -1;

      for (int i = 0; i < 15; i++) {
         System.out.println(i);
         phone.chiama(generaNumero());
         System.out.println(phone.getChiamataRecente(0));
         if (((i+1) % 5 == 0)) {
            System.out.print("\nInserisci un indice [1-10]: ");
            do {
               indx = in.nextInt()-1;
            } while (indx < 0 || indx > 9);
            System.out.println("> " + phone.getChiamataRecente(indx));
         }
      }
   }
}
