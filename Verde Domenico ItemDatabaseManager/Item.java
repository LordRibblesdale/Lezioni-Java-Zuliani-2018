public class Item {
   private String name, description, type;
   private int costo;
   private boolean consumable;
   public static String[] types = {"Pozione", "Arma", "Armatura", "Pergamena", "Vuoto"};

   Item() {
      name = "---";
      description = "---";
      type = "---";
      consumable = false;
   }

   Item(String name, String description, String type, int costo, boolean consumable) {
      this.name = name;
      this.description = description;
      this.costo = costo;
      this.type = type;
      this.consumable = consumable;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public int getCosto() {
      return costo;
   }

   public void setCosto(int costo) {
      this.costo = costo;
   }

   public boolean getConsumable() {
      return consumable;
   }

   public void setConsumable(boolean consumable) {
      this.consumable = consumable;
   }

   public String toString() {
      return getName();
   }

   public void clear() {
      name = "---";
      description = "---";
      type = "---";
      costo = 0;
      consumable = false;
   }

   public Item copy() {
      return new Item(this.name, this.description, this.type, this.costo, this.consumable);
   }

   public void paste(Item copy) {
      this.name = copy.getName();
      this.description = copy.getDescription();
      this.type = copy.getType();
      this.consumable = copy.getConsumable();
      this.costo = copy.getCosto();
   }
}
