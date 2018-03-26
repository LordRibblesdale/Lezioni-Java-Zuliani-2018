import java.util.*;

public class Incrocio {
   public static int selection(int start, int finish) {
      class OutOfValueExteption extends Exception {
         OutOfValueExteption() {
            super("Exception: Value is not permitted.");
         }
      }

      Scanner selIn = new Scanner(System.in);
      int choice = 0;
      System.out.print("Insert a value: ");
      choice = selIn.nextInt();

      try {
         if (choice < start || choice > finish) {
            throw new OutOfValueExteption();
         } else {
            return choice;
         }
      } catch (OutOfValueExteption e) {
         System.out.println(e.getMessage());
         return selection(start, finish);
      }
   }

   public static String generaTarga() {
      return "RM" + String.valueOf((int)Math.floor(Math.random()*900)+100);
   }

   public static void main(String[] args) {
      Queue<String> stradaA = new LinkedList<String>();
      Queue<String> stradaB = new LinkedList<String>();

      int num = selection(5, 10);

      for (int i = 0; i < num; i++) {
         for (int j = ((int)Math.floor(Math.random()*3)+3); j > 0; j--) {
            String tmp = generaTarga();
            stradaA.add(tmp);
            System.out.println(tmp + " si e' aggiunta alla coda sulla strada A");
         }
         for (int j = ((int)Math.floor(Math.random()*3)+3); j > 0; j--) {
            String tmp = generaTarga();
            stradaB.add(tmp);
            System.out.println(tmp + " si e' aggiunta alla coda sulla strada B");
         }

         for (int j = ((int)Math.floor(Math.random()*3)+1); j > 0; j--) {
            System.out.println(stradaA.poll() + " esce dalla coda sulla strada A");
         }
         for (int j = ((int)Math.floor(Math.random()*3)+1); j > 0; j--) {
            System.out.println(stradaB.poll() + " esce dalla coda sulla strada B");
         }
      }

      System.out.println("Restano in fila sulla strada A:\n" + stradaA);
      System.out.println("Restano in fila sulla strada B:\n" + stradaB);

   }
}
