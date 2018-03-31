import java.util.*;
import java.util.Scanner;

public class BuilderCycle {
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

   public static NomeColore setRndColore(int value) {
      NomeColore color = null;

      switch (value) {
         case 1:
            color = NomeColore.Rosso;
            break;
         case 2:
            color = NomeColore.Verde;
            break;
         case 3:
            color = NomeColore.Blu;
            break;
         case 4:
            color = NomeColore.Giallo;
            break;
         case 5:
            color = NomeColore.Nero;
            break;
         case 6:
            color = NomeColore.Bianco;
            break;
         case 7:
            color = NomeColore.Grigio;
            break;
         case 8:
            color = NomeColore.Marrone;
            break;
         case 9:
            color = NomeColore.Arancione;
            break;
         case 10:
            color = NomeColore.Viola;
            break;
      }
      return color;
   }

   public static Mattoncino generaMattoncino() {
      return new Mattoncino((int)Math.floor(Math.random()*7)+3, (int)Math.floor(Math.random()*7)+3, setRndColore((int)Math.floor(Math.random()*10)+1));
   }

   public static void main(String[] args) {
      Stack<Mattoncino> mattoncini = new Stack<Mattoncino>();

      for ( ; ; ) {
         System.out.print("1- Add Mattoncino\n2- Remove last Mattoncino\n3- Show last Mattoncino\n4- Destroy all and close)");
         switch (selection(1, 4)) {
            case 1:
               mattoncini.push(generaMattoncino());
               try {
                  System.out.println("Adding Mattoncino: Altezza=" + mattoncini.peek().getAltezza() + " Larghezza=" + mattoncini.peek().getLarghezza() + " Colore: " + mattoncini.peek().getColore());
               } catch (EmptyStackException e) {
                  System.out.println("Empty Stack");
               }
               break;
            case 2:
               try {
                  Mattoncino tmp = mattoncini.pop();
                  System.out.println("Removing Mattoncino: Altezza=" + tmp.getAltezza() + " Larghezza=" + tmp.getLarghezza() + " Colore: " + tmp.getColore());
               } catch (EmptyStackException e) {
                  System.out.println("Empty Stack");
               }
               break;
            case 3:
               try {
                  System.out.println("Ultimo Mattoncino: Altezza=" + mattoncini.peek().getAltezza() + " Larghezza=" + mattoncini.peek().getLarghezza() + " Colore: " + mattoncini.peek().getColore());
               } catch (EmptyStackException e) {
                  System.out.println("Empty Stack");
               }
               break;
            case 4:
               System.out.println("Destroying all...");
               while (!(mattoncini.empty())) {
                  try {
                     System.out.println("Destroying Mattoncino: Altezza=" + mattoncini.peek().getAltezza() + " Larghezza=" + mattoncini.peek().getLarghezza() + " Colore: " + mattoncini.peek().getColore());
                     mattoncini.pop();
                  } catch (EmptyStackException e) {
                     System.out.println("Empty Stack");
                  }
               }
               System.exit(0);
               break;
         }
         System.out.println();
      }
   }
}
