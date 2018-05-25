import java.io.*;

public class Persona implements Serializable {
   private String nome, cognome;
   private int eta;

   Persona(String nome, String cognome, int eta) {
      this.nome = nome;
      this.cognome = cognome;
      this.eta = eta;
   }

   public String getNome() {
     return nome;
   }

   public void setNome(String nome) {
     this.nome = nome;
   }

   public String getCognome() {
     return cognome;
   }

   public void setCognome(String cognome) {
     this.cognome = cognome;
   }

   public int getEta() {
     return eta;
   }

   public void setEta(int eta) {
      this.eta = eta;
   }

   public String toString() {
      return "Nome: " + getNome() + "\nCognome: " + getCognome() + "\nEta: " + getEta();
   }
}
