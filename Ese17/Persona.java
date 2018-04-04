enum Ordinamento {
   perNome,
   perCognome,
   perNomeCompleto,
   perEta,
   perGenere
}

public class Persona implements Comparable<Persona> {
   protected String nome, cognome;
   protected int eta;
   protected char sesso;
   protected Ordinamento ordinaPer;

   Persona(String name, String surname, int age, char sex) {
      nome = name;
      cognome = surname;
      eta = age;
      sesso = sex;
      ordinaPer = Ordinamento.perNomeCompleto;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String name) {
      nome = name;
   }

   public String getCognome() {
      return cognome;
   }

   public void setCognome(String surname) {
      cognome = surname;
   }

   public int getEta() {
      return eta;
   }

   public void setEta(int age) {
      eta = age;
   }

   public char getSesso() {
      return sesso;
   }

   public void setSesso(char sex) {
      sesso = sex;
   }

   public Ordinamento getOrdinamento() {
      return ordinaPer;
   }

   public void setOrdinamento(Ordinamento newOrder) {
      ordinaPer = newOrder;
   }

   public int compareTo(Persona p) {
      switch (ordinaPer) {
         case perNome:
            if (this.nome.compareTo(p.getNome()) == 0) {
               return 0;
            } else {
               return this.nome.compareTo(p.getNome());
            }
         case perCognome:
            if (this.cognome.compareTo(p.getCognome()) == 0) {
               return 0;
            } else {
               return this.cognome.compareTo(p.getCognome());
            }
         case perNomeCompleto:
            if (this.nome.compareTo(p.getNome()) + this.cognome.compareTo(p.getCognome()) == 0) {
               return 0;
            } else {
               return this.nome.compareTo(p.getNome()) + this.cognome.compareTo(p.getCognome());
            }
         case perEta:
            if (this.eta == p.getEta()) {
               return 0;
            } else {
               return this.eta - p.getEta();
            }
         case perGenere:
            if (this.sesso == p.getSesso()) {
               return 0;
            } else {
               return this.sesso - p.getSesso();
            }
         default:
            return -50198;
      }
   }

   public String toString() {
      return getNome() + " " + getCognome() + " " + getSesso() + " " + getEta();
   }
}
