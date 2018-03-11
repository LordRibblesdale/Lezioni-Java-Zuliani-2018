import java.util.Scanner;

public class Eser03 {
   public static int generaNumeroCasuale() {
      int rnd = (int)Math.floor(Math.random()*3)+1;
      String s = "";
      switch (rnd) {
         case 1:
            s = "333" + (int)Math.floor(Math.random()*999999);
            break;
         case 2:
            s = "348" + (int)Math.floor(Math.random()*999999);
            break;
         case 3:
            s = "389" + (int)Math.floor(Math.random()*999999);
            break;
      }
      return Integer.parseInt(s);
   }

   public static int generaNumeroManualmente() {
      Scanner in = new Scanner(System.in);
      int num = 0;

      do {
         num = in.nextInt();
      } while (num < (10^8) || num >= (10^9));

      return num;
   }

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      Smartphone phone = new Smartphone("OnePlus 5T", "Android OS", (float)5.7, 8);
      int indx = -1;

      for (int i = 0; i < 15; i++) {
         System.out.println(i);
         phone.chiama(generaNumeroCasuale()); //da specificare se casuale o manuale
         System.out.println(phone.getChiamataRecente(0));
         if (((i+1) % 3 == 0)) {
            System.out.print("\nInserisci un indice [1-10]: ");
            do {
               indx = in.nextInt()-1;
            } while (indx < 0 || indx > 9);
            System.out.println("> " + phone.getChiamataRecente(indx));
         }
         if (((i+1) % 5 == 0)) {
            for (int j = 0; j < 5; j++) {
               if (phone.getNumeroPreferito(j) != 0) {
                  System.out.println("Printing: " + phone.getNumeroPreferito(j));
               }
            }
         }
      }
   }
}
