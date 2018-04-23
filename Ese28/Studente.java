public class Studente {
   private String nome, cognome;
   private int matricola, mediaVoti, esamiVerbalizzati;

   Studente(String nome, String cognome, int matricola, int mediaVoti, int esamiVerbalizzati) {
      this.nome = nome;
      this.cognome = cognome;
      this.matricola = matricola;
      this.mediaVoti = mediaVoti;
      this.esamiVerbalizzati = esamiVerbalizzati;
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

   public int getMatricola() {
     return matricola;
   }

   public void setMatricola(int matricola) {
     this.matricola = matricola;
   }

   public int getMediaVoti() {
     return mediaVoti;
   }

   public void setMediaVoti(int mediaVoti) {
     this.mediaVoti = mediaVoti;
   }

   public int getEsamiVerbalizzati() {
     return esamiVerbalizzati;
   }

   public void setEsamiVerbalizzati(int esamiVerbalizzati) {
     this.esamiVerbalizzati = esamiVerbalizzati;
   }

   public String toString() {
      return getCognome() + " " + getNome();
   }
}
