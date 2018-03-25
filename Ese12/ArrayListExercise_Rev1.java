import java.util.*;

public class ArrayListExercise_Rev1 {
   public static int selection(int start) {
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
         if (choice < start) {
            throw new OutOfValueExteption();
         } else {
            return choice;
         }
      } catch (OutOfValueExteption e) {
         System.out.println(e.getMessage());
         return selection(start);
      }
   }

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

   public static void choice(ArrayList<Dolce> input, int c) {
      Scanner in = new Scanner(System.in);
      String name = "";

      System.out.print("Insert name: ");
      name = in.nextLine();

      switch (c) {
         case 1:
            String[] tmp3;
            int index = 0;

            System.out.print("How may ingredients?: ");
            index = selection(0);
            tmp3 = new String[index];
            while (index != 0) {
               System.out.print("Here (one by one): ");
               tmp3[tmp3.length-index] = in.nextLine();
               index--;
            }

            System.out.print("Where do you want to insert this obj? [0-" + (input.size()) + "] ");
            input.add(selection(0, (input.size())), new Ciambellone(name, tmp3));
            break;
         case 2:
            String brand = "";
            int[] inputs = new int[2];

            System.out.print("Insert brand: ");
            brand = in.nextLine();

            for (int i = 0; i < inputs.length; i++) {
               switch (i) {
                  case 0:
                     System.out.print("Insert price: ");
                     inputs[i] = (int)in.nextDouble();
                     break;
                  case 1:
                     System.out.print("Insert nums of sweets: ");
                     inputs[i] = in.nextInt();
                     break;
               }
            }

            System.out.print("Where do you want to insert this obj? [0-" + (input.size()) + "] ");
            input.add(selection(0, (input.size())), new Cioccolatino(name, brand, inputs[0], inputs[1]));
            break;
         case 3:
            String brand2 = "";
            int price = 0;

            System.out.print("Insert brand: ");
            brand2 = in.nextLine();

            System.out.print("Insert price: ");
            price = (int)in.nextDouble();

            System.out.print("Where do you want to insert this obj? [0-" + (input.size()) + "] ");
            input.add(selection(0, (input.size())), new Merendina(name, brand2, price));
            break;
      }
   }

   public static void main(String[] args) {
      ArrayList<Dolce> dolciumi = new ArrayList<Dolce>();
      int sel = 0;

      while(sel != 5) {
         System.out.print("\nMenu: \n- Add an object (in a )\n- Remove an object\n- Print an object\n- Print full array\n- Close program\n-> ");
         sel = selection(1, 5);

         switch (sel) {
            case 1:
               System.out.print("Insert a choice: [\n1 = Ciambellone;\n2 = Cioccolatino;\n3 = Merendina]\n -> ");
               choice(dolciumi, selection(1, 3));
               break;
            case 2:
               System.out.print("Where do you want to remove? [0-" + (dolciumi.size()-1) + "] ");
               dolciumi.remove(selection(0, dolciumi.size()-1));
               break;
            case 3:
               System.out.print("Which do you want to print? [0-" + (dolciumi.size()-1) + "] ");
               System.out.print(dolciumi.get(selection(0, dolciumi.size()-1)));
               break;
            case 4:
               System.out.print(dolciumi);
               break;
            case 5:
               System.exit(0);
               //TODO: fix main to permit adding more elements as choice
         }
      }
   }
}
