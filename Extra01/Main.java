public class Main {
   public static void main(String[] args) {
      Vector3<NumeroIntero> v1 = new Vector3<NumeroIntero>(new NumeroIntero(15), new NumeroIntero(4), new NumeroIntero(44));
      Vector3<NumeroIntero> v2 = new Vector3<NumeroIntero>(new NumeroIntero(8), new NumeroIntero(78), new NumeroIntero(155));

      System.out.println(v1.somma(v2));
   }
}
