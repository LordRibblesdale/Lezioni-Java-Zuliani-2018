public class Museum extends Location {
   private String name;
   private String[] subjects;
   public int entranceCost, tourDuration;

   Museum() {
      name = "NoName";
      subjects = new String[1];
      subjects[0] = "NoName";
      entranceCost = 0;
      tourDuration = 0;
   }

   Museum(String name, String[] subjects, int entranceCost, int tourDuration) {
      this.name = name;
      this.subjects = new String[subjects.length];
      for (int i = 0; i < subjects.length; i++) {
         this.subjects[i] = subjects[i];
      }
      this.entranceCost = entranceCost;
      this.tourDuration = tourDuration;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String[] getSubjects() {
      return subjects;
   }

   public void setSubjects(String[] subjects) {
      if (this.subjects != null && subjects.length == this.subjects.length) {
         for (int i = 0; i < subjects.length; i++) {
            this.subjects[i] = subjects[i];
         }
      }
   }

   public int getEntrance() {
      return entranceCost;
   }

   public void setEntrance(int entranceCost) {
      this.entranceCost = entranceCost;
   }

   public int getTourDuration() {
      return tourDuration;
   }

   public void setTourDuration(int tourDuration) {
      this.tourDuration = tourDuration;
   }

   public String getDescription() {
      String tmp = "";
      for (int i = 0; i < getSubjects().length; i++) {
         tmp += "-> " + getSubjects()[i] + "\n";
      }
      return "Museum " + getName() + "\nObjects:\n" + tmp;
   }

   public int getDuration() {
      return getTourDuration();
   }

   public int getCost() {
      return getEntrance();
   }
}
