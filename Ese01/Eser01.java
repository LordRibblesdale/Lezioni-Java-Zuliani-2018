import java.util.Scanner;

public class Eser01 {
   public static final int RIGHE = 6, COLONNE = 4;

   public static int[][] genera() {
      int[][] a = new int[RIGHE][COLONNE];

      for (int i = 0; i < a.length; i++) {
         for (int j = 0; j < a[0].length; j++) {
            a[i][j] = (int)Math.floor(Math.random()*30);
         }
      }

      return a;
   }

   public static void stampaRiga(int[] a, int min, int max) {
      int num = 0;

      for (int i = 0; i < a.length; i++) {
         System.out.println();
         if (a[i] > min && a[i] < max) {
            System.out.print(a[i] + " ");
            num++;
         }
      }

      System.out.println("\nNumeri stampati: " + num);
   }

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int[][] matrix = genera();
      int min = 0, max = 0;

      for (int i = 0; i < matrix.length; i++) {
         min = 0;
         max = 0;
         System.out.print("\nInsert MIN [0-30]: ");
         do {
            min = in.nextInt();
         } while (min < 0 || min > 29);
         System.out.printf("\nInsert MAX [%d-30]: ", min);
         if (min == 29) {
            max = 30;
         } else {
            do {
               max = in.nextInt();
            } while (max < min || max > 30);
         }
         stampaRiga(matrix[i], min, max);
      }
   }
}
