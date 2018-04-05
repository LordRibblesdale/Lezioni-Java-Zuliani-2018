import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

class Listener implements ActionListener {
   Listener() {}

   public void actionPerformed(ActionEvent e) {
      ListaPersoneTemporizzata_Outer.getLista().add(ListaPersoneTemporizzata_Outer.generaPersona());

      int tmp = (int)Math.floor(Math.random()*5)+1;
      for (int i = 0; i < ListaPersoneTemporizzata_Outer.getLista().size(); i++) {
         switch (tmp) {
            case 1:
               ListaPersoneTemporizzata_Outer.getLista().get(i).setOrdinamento(Ordinamento.perNome);
               break;
            case 2:
               ListaPersoneTemporizzata_Outer.getLista().get(i).setOrdinamento(Ordinamento.perCognome);
               break;
            case 3:
               ListaPersoneTemporizzata_Outer.getLista().get(i).setOrdinamento(Ordinamento.perNomeCompleto);
               break;
            case 4:
               ListaPersoneTemporizzata_Outer.getLista().get(i).setOrdinamento(Ordinamento.perEta);
               break;
            case 5:
               ListaPersoneTemporizzata_Outer.getLista().get(i).setOrdinamento(Ordinamento.perGenere);
               break;
         }
      }

      System.out.println("Aggiunta persona: " + ListaPersoneTemporizzata_Outer.getLista().get(ListaPersoneTemporizzata_Outer.getLista().size()-1));
      System.out.println("Ordimanento usato: " + ListaPersoneTemporizzata_Outer.getLista().get(0).getOrdinamento());

      Collections.sort(ListaPersoneTemporizzata_Outer.getLista());

      for (int i = 0; i < ListaPersoneTemporizzata_Outer.getLista().size(); i++) {
         System.out.println(ListaPersoneTemporizzata_Outer.getLista().get(i));
      }
   }
}

public class ListaPersoneTemporizzata_Outer {
   private static ArrayList<Persona> persone = new ArrayList<Persona>();

   public static ArrayList<Persona> getLista() {
      return persone;
   }

   public static String[] nomi = {
      "Kevin",
      "Giovanni",
      "Valentina",
      "Irene",
      "Ilenia",
      "Luca",
      "Domenico",
      "Francesco",
      "Damiano",
      "Francesca"
   }, cognomi = {
      "Vitali",
      "Pagliei",
      "Verde",
      "Galizzi",
      "Piombini",
      "Tedde",
      "Genovese",
      "Filosa",
      "Graziani"
   };

   public static Persona generaPersona() {
      char c = 0;
      switch ((int)Math.floor(Math.random()*3)+1) {
         case 1:
            c = 'f';
            break;
         case 2:
            c = 'm';
            break;
         case 3:
            c = 'u';
            break;
      }
      return new Persona(nomi[(int)Math.floor(Math.random()*nomi.length)], cognomi[(int)Math.floor(Math.random()*cognomi.length)], (int)Math.floor(Math.random()*99)+1, c);
   }

   public static void main(String[] args) {
      Listener l = new Listener();
      Timer t = new Timer(750, l);
      t.start();

      JOptionPane.showMessageDialog(null, "Chiudere?");
      System.exit(0);
   }
}
