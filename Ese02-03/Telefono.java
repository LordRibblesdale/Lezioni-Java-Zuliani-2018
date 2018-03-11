class IndexOutOfBoundsExeption extends Exception {
   IndexOutOfBoundsExeption() {
      super("Index not in the array.");
   }

   IndexOutOfBoundsExeption(String msg) {
      super(msg);
   }
}

public class Telefono {
   private String modello, sistemaOperativo;
   private float dimensioneSchermo;
   private int memoria;
   private int[] ultimeChiamate = new int[10];

   Telefono() {
      modello = "NoName";
      sistemaOperativo = "NoName";
      dimensioneSchermo = 1;
      memoria = 1;
      for (int i = 0; i < ultimeChiamate.length; i++) {  //method needed?
         ultimeChiamate[i] = 0;
      }
   }

   Telefono(String model, String operativeSystem, float screenDimension, int memory) {
      //modello = model;
      setModello(model);
      //sistemaOperativo = operativeSystem;
      setSistemaOperativo(operativeSystem);
      //dimensioneSchermo = screenDimension;
      setDimensioneSchermo(screenDimension);
      //memoria = memory;
      setMemoria(memory);
      for (int i = 0; i < ultimeChiamate.length; i++) {  //method needed?
         ultimeChiamate[i] = 0;
      }
   }

   public String getModello() {
      return modello;
   }

   public void setModello(String model) {
      modello = model;
   }

   public String getSistemaOperativo() {
      return sistemaOperativo;
   }

   public void setSistemaOperativo(String operativeSystem) {
      sistemaOperativo = operativeSystem;
   }

   public float getDimensioneSchermo() {
      return dimensioneSchermo;
   }

   public void setDimensioneSchermo(float screenDimension) {
      if (screenDimension > 0) {
         dimensioneSchermo = screenDimension;
      } else {
         dimensioneSchermo = 1;
      }
   }

   public int getMemoria() {
      return memoria;
   }

   public void setMemoria(int memory) {
      if (memory > 0) {
         memoria = memory;
      } else {
         memoria = 1;
      }
   }

   public int getChiamataRecente(int index) {
      try {
         if (index < 0 || index > 9) {
            throw new IndexOutOfBoundsExeption();
         } else {
            return ultimeChiamate[index];
         }
      } catch(Exception e) {
         System.out.println(e.getMessage() + "\nReturning first array item...");
         return getChiamataRecente(0);
      }
   }

   public void chiama(int num) {
      for (int i = ultimeChiamate.length-1; i > 0; i--) {
         ultimeChiamate[i] = ultimeChiamate[i-1];
      }
      ultimeChiamate[0] = num;
   }
}
