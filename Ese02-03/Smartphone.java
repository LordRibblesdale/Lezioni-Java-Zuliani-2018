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

   public int getNumeroPreferito(int indx) {
      return numeriPreferiti[indx];
   }

   public void chiama(int num) {
      for (int i = 0; i < ultimeChiamate.length; i++) {
         if (num == ultimeChiamate[i]) {
            for (int j = numeriPreferiti.length-1; j > 0; j--) {
               numeriPreferiti[j] = numeriPreferiti[j-1];
            }
            numeriPreferiti[0] = num;
         }
      }
      super.chiama(num);
   }
}
