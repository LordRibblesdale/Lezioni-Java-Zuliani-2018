public class NumeroIntero implements Sommabile<NumeroIntero> {
   public int value;

   NumeroIntero(int input) {
      value = input;
   }

   public String toString() {
      return Integer.toString(value);
   }

   public NumeroIntero somma(NumeroIntero obj) {
      return new NumeroIntero((this.value + obj.value));
   }
}
