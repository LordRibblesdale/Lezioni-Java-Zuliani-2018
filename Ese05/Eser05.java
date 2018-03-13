public class Eser05 {
   public static void main(String[] args) {
      String[] ingredienti = {
         "Uova",
         "Latte",
         "Scorza di Limone",
         "Burro",
         "Zucchero",
         "Farina 00",
         "Lievito in polvere",
         "Zucchero a velo"
      };

      Dolce[] breakfast = new Dolce[3];
      breakfast[0] = new Merendina("Bounty", "CheNeSo", 1);
      breakfast[1] = new Cioccolatino("Torrone", "NonSaprei", 2, 10);
      breakfast[2] = new Ciambellone("Er Ciambellone", ingredienti);

      for (int i = 0; i < breakfast.length; i++) {
         System.out.println(breakfast[i].toString() + "\n");
      }
   }
}
