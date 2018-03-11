public class Smartphone extends Telefono {
   private String[] apps = new String[10];
   private int[] numeriPreferiti = new int[5];

   Smartphone() {
      super();
   }

   Smartphone(String model, String operativeSystem, float screenDimension, int memory) {
      super(model, operativeSystem, screenDimension, memory);
   }

   public void stampaApp() {
      System.out.print("Apps installate: ");
      for (int i = 0; i < apps.length; i++) {
         System.out.print(apps[i] + " ");
      }
   }

   public void installaApp(String newApp) {
      for (int i = 0; i < apps.length; i++) {
         if (apps[i] == null || apps[i] == "") {
            apps[i] = newApp;
            break;
         }
      }
   }

   public void eliminaApp(int index) {
      apps[index] = "";
   }

   public int getNumeroPreferito(int index) {
      try {
         if (index < 0 || index > 4) {
            throw new IndexOutOfBoundsExeption();
         } else {
            return numeriPreferiti[index];
         }
      } catch(Exception e) {
         System.out.println(e.getMessage() + "\nReturning first array item...");
         return getNumeroPreferito(0);
      }
   }

   public void chiama(int num) {
      for (int i = 0; i < 10; i++) {
         if (num == getChiamataRecente(i)) {
            for (int j = 9; j > 0; j--) {
               numeriPreferiti[j] = numeriPreferiti[j-1];
            }
            numeriPreferiti[0] = num;
         }
      }
      super.chiama(num);
   }
}
