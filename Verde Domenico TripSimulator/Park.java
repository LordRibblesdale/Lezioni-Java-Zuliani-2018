public class Park extends Location {
   private String name, city;
   private int[] roadsLength;

   Park() {
      name  = "NoName";
      city = "NoName";
      roadsLength = new int[1];
      roadsLength[0] = 0;
   }

   Park(String name, String city, int[] roadsLength) {
      this.name = name;
      this.city = city;
      this.roadsLength = new int[roadsLength.length];
      for (int i = 0; i < roadsLength.length; i++) {
         this.roadsLength[i] = roadsLength[i];
      }
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public int[] getRoadsLength() {
      return roadsLength;
   }

   public void setRoadsLength(int[] roadsLength) {
      if (this.roadsLength != null && roadsLength.length == this.roadsLength.length) {
         for (int i = 0; i < roadsLength.length; i++) {
            this.roadsLength[i] = roadsLength[i];
         }
      }
   }

   public String getDescription() {
      return "Park " + getName() + " in " + getCity() + " with " + getRoadsLength().length + " roads.";
   }

   public int getDuration() {
      int a = 0, tmp = 0;
      for (int i = 0; i < 2; i++) {
         a = (int)Math.floor(Math.random()*(getRoadsLength().length));
         tmp += getRoadsLength()[a];
      }
      return tmp;
   }

   public int getCost() {
      return 0;
   }
}
