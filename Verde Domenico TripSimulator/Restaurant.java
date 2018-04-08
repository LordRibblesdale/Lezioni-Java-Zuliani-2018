public class Restaurant extends Location {
   private String name, chef;
   private int averageCost, waitingListDuration;

   Restaurant() {
      name = "NoName";
      chef = "NoName";
      averageCost = 0;
      waitingListDuration = 0;
   }

   Restaurant(String name, String chef, int averageCost, int waitingListDuration) {
      this.name = name;
      this.chef = chef;
      this.averageCost = averageCost;
      this.waitingListDuration = waitingListDuration;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getChef() {
      return chef;
   }

   public void setChef(String chef) {
      this.chef = chef;
   }

   public int getAverage() {
      return averageCost;
   }

   public void setAverage(int averageCost) {
      this.averageCost = averageCost;
   }

   public int getWaiting() {
      return waitingListDuration;
   }

   public void setWaiting(int waitingListDuration) {
      this.waitingListDuration = waitingListDuration;
   }

   public String getDescription() {
      return "Restaurant " + getName() + "\nChef " + getChef();
   }

   public int getDuration() {
      return (9 + getWaiting());
   }

   public int getCost() {
      return getAverage();
   }
}
