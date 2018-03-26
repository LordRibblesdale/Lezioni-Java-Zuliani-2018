import java.util.*;

public class Grattacielo {
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

   public static void main(String[] args) {
      Hashtable<Integer, String> piani = new Hashtable<Integer, String>();
      Scanner in = new Scanner(System.in);
      int floor = -1;

      piani.put(new Integer(0), "Hall");

      while (floor != 0) {
         class Repeat {
            int tmp;
            char c;

            Repeat() {
               tmp = 0;
            }

            public void isWritable(int floorIn) {
               if (piani.get(new Integer(floorIn)) != null) {
                  System.out.print("There is already something here. Do you want to replace? [y-n]");
                  c = in.nextLine().charAt(0);
                  switch (c) {
                     case 'y':
                     case 'Y':
                        System.out.print("This floor should be moved. Where do you want to move it? [-1 == This floor will be overwritten, 0 not allowed]");
                        while (tmp == 0) {
                           tmp = selection (-1, 99);
                        }
                        if (tmp != -1 && piani.get(new Integer(tmp)) == null) {
                           piani.put(new Integer(tmp), piani.get(floorIn));
                           System.out.print("What is this floor should be used for? ");
                           piani.put(new Integer(floorIn), in.nextLine());
                           break;
                        } else {
                           isWritable(tmp);
                        }
                  }
               }
            }
         }

         System.out.print("Choose a floor: ");
         floor = selection(0, 99);

         if (piani.get(new Integer(floor)) == null) {
            System.out.print("What is this floor should be used for? :");
            piani.put(new Integer(floor), in.nextLine());
         } else if (floor != 0) {
            Repeat tryFloor = new Repeat();
            tryFloor.isWritable(floor);
         } else {
            System.exit(0);
         }
      }


   }
}
