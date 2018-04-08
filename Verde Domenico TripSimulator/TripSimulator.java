import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.Timer;
import java.util.Scanner;
import java.awt.event.*;

public class TripSimulator {
   private Queue<Location> locations;
   private Timer t;
   private Location actualLocation;
   private int count, costoTotale;

   private Scanner in = new Scanner(System.in);

   TripSimulator() {
      boolean isDone = false;
      char c;
      locations = new LinkedList<Location>();

      while (!isDone) {
         int tmp0 = 0;
         System.out.println("Add a trip to the queue. What do you want to visit?");
         System.out.println("1) Restaurant\n2) Museum\n3) Park\n");
         do {
            tmp0 = 0;
            try {
               System.out.print("Choose one: ");
               tmp0 = in.nextInt();
            } catch (InputMismatchException e) {
               System.out.println("Exeption > not an integer. Try again.");
               in.nextLine();
            }
         } while (tmp0 < 0 || tmp0 > 3);

         switch (tmp0) {
            case 1:
               String name, chef;
               int averageCost = 0, waitingListDuration = 0;
               System.out.print("Insert name of the Restaurant: ");
               name = in.nextLine();
               System.out.print("Insert name of the chef: ");
               chef = in.nextLine();
               System.out.print("How much does it cost? ");
               do {
                  averageCost = 0;
                  try {
                     averageCost = in.nextInt();
                  } catch (InputMismatchException e) {
                     System.out.println("Exeption > not an integer. Try again.");
                     in.nextLine();
                  }
               } while (averageCost < 1);
               System.out.print("How much time do you have to wait to enter? ");
               do {
                  waitingListDuration = 0;
                  try {
                     waitingListDuration = in.nextInt();
                  } catch (InputMismatchException e) {
                     System.out.println("Exeption > not an integer. Try again.");
                     in.nextLine();
                  }
               } while (waitingListDuration < 1);

               locations.add(new Restaurant(name, chef, averageCost, waitingListDuration));
               break;
            case 2:
               String name2;
               String[] subjects;
               int entranceCost = 0, tourDuration = 0, tmp = 0;
               System.out.print("Insert name of the Museum: ");
               name2 = in.nextLine();
               System.out.print("How may subjects will you see there?: ");
               do {
                  tmp = 0;
                  try {
                     tmp = in.nextInt();
                  } catch (InputMismatchException e) {
                     System.out.println("Exeption > not an integer. Try again.");
                     in.nextLine();
                  }
               } while (tmp < 1);
               System.out.println("Write here the subjects: ");
               subjects = new String[tmp];
               for (int i = 0; i < tmp; i++) {
                  System.out.print("-> ");
                  subjects[i] = in.nextLine();
               }
               System.out.print("How much does it cost? ");
               do {
                  entranceCost = 0;
                  try {
                     entranceCost = in.nextInt();
                  } catch (InputMismatchException e) {
                     System.out.println("Exeption > not an integer. Try again.");
                     in.nextLine();
                  }
               } while (entranceCost < 1);
               System.out.print("How much time does it take? ");
               do {
                  tourDuration = 0;
                  try {
                     tourDuration = in.nextInt();
                  } catch (InputMismatchException e) {
                     System.out.println("Exeption > not an integer. Try again.");
                     in.nextLine();
                  }
               } while (tourDuration < 0);

               locations.add(new Museum(name2, subjects, entranceCost, tourDuration));
               break;
            case 3:
               String name3, city;
               int[] roadsLength;
               int tmp2 = 0;
               System.out.print("Insert name of the Park: ");
               name3 = in.nextLine();
               System.out.print("Which city is this park in?: ");
               city = in.nextLine();
               System.out.print("How may roads are there?: ");
               do {
                  tmp2 = 0;
                  try {
                     tmp2 = in.nextInt();
                  } catch (InputMismatchException e) {
                     System.out.println("Exeption > not an integer. Try again.");
                     in.nextLine();
                  }
               } while (tmp2 < 1);
               System.out.println("Write here the roads length: ");
               roadsLength = new int[tmp2];
               for (int i = 0; i < tmp2; i++) {
                  System.out.print("-> ");
                  do {
                     roadsLength[i] = 0;
                     try {
                        roadsLength[i] = in.nextInt();
                     } catch (InputMismatchException e) {
                        System.out.println("Exeption > not an integer. Try again.");
                        in.nextLine();
                     }
                  } while (roadsLength[i] < 1);
               }

               locations.add(new Park(name3, city, roadsLength));
               break;
         }

         System.out.print("Do you want to insert other places? ");
         do {
            c = in.nextLine().charAt(0);
         } while (c != 'Y' && c != 'y' && c != 'N' && c != 'n');

         switch (c) {
            case 'Y':
            case 'y':
               break;
            case 'N':
            case 'n':
               isDone = true;
               break;
         }
      }

      t = new Timer(200, new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (actualLocation == null) {
               if (locations.peek() == null) {
                  System.out.println("Total costs: " + costoTotale);
                  t.stop();
               } else {
                  actualLocation = locations.poll();
               }
            } else {
               if (count == 0) {
                  System.out.println(actualLocation.getDescription());
                  count++;
               } else {
                  System.out.print(".");
                  count++;
               }

               if (count == actualLocation.getDuration()) {
                  costoTotale += actualLocation.getCost();
                  actualLocation = null;
                  count = 0;
               }
            }
         }
      });

      t.start();
   }
}
