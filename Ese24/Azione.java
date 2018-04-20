public class Azione {
   private String nome, descrizione;

   Azione() {
      nome = "NoName";
      descrizione = "Null";
   }

   Azione(String nome, String descrizione) {
      this.nome = nome;
      this.descrizione = descrizione;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getDescrizione() {
      return descrizione;
   }

   public void setDescrizione(String descrizione) {
      this.descrizione = descrizione;
   }

   public String toString() {
      return getNome();
   }
}
