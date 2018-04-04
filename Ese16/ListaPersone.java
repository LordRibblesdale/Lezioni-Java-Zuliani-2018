import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ListaPersone {
   public static void main(String[] args) {
      ArrayList<Persona> people = new ArrayList<Persona>();
      Scanner in = new Scanner(System.in);
      String nome = "", cognome = "";
      int eta = -1, tmp = 0;
      char sesso;

      for ( ; ; ) {
         System.out.print("Insert name: [insert -1 HERE to stop] ");
         nome = in.nextLine();
         if (nome.equals("-1")) {
            break;
         }
         System.out.print("Insert surname: ");
         cognome = in.nextLine();
         System.out.print("Insert age: ");
         do {
            try {
               eta = in.nextInt();
               in.nextLine();
            } catch (InputMismatchException e) {
               System.out.println("Error: wrong values!");
            }
         } while (eta <= 0);
         System.out.print("Insert sex ");
         do {
            sesso = in.nextLine().charAt(0);
         } while (sesso != 'f' && sesso != 'm' && sesso != 'u');

         System.out.println("Adding...\n");
         people.add(new Persona(nome, cognome, eta, sesso));
      }

      System.out.println("How do you want to sort these people? ");
      System.out.print("1: Per Nome\n2: Per Cognome\n3: Per Nome Completo\n4: Per Eta'\n5: Per Genere\n -> ");
      do {
         tmp = in.nextInt();
         in.nextLine();
      } while (tmp < 1 || tmp > 5);

      for (int i = 0; i < people.size(); i++) {
         switch (tmp) {
            case 1:
               people.get(i).setOrdinamento(Ordinamento.perNome);
               break;
            case 2:
               people.get(i).setOrdinamento(Ordinamento.perCognome);
               break;
            case 3:
               people.get(i).setOrdinamento(Ordinamento.perNomeCompleto);
               break;
            case 4:
               people.get(i).setOrdinamento(Ordinamento.perEta);
               break;
            case 5:
               people.get(i).setOrdinamento(Ordinamento.perGenere);
               break;
         }
      }

      Collections.sort(people);

      for (int i = 0; i < people.size(); i++) {
         System.out.println(people.get(i));
      }
   }
}
