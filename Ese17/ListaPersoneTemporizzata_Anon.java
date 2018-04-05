import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class ListaPersoneTemporizzata_Anon {
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
      ArrayList<Persona> persone = new ArrayList<Persona>();
      Timer t = new Timer(750, new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            persone.add(generaPersona());

            int tmp = (int)Math.floor(Math.random()*5)+1;
            for (int i = 0; i < persone.size(); i++) {
               switch (tmp) {
                  case 1:
                     persone.get(i).setOrdinamento(Ordinamento.perNome);
                     break;
                  case 2:
                     persone.get(i).setOrdinamento(Ordinamento.perCognome);
                     break;
                  case 3:
                     persone.get(i).setOrdinamento(Ordinamento.perNomeCompleto);
                     break;
                  case 4:
                     persone.get(i).setOrdinamento(Ordinamento.perEta);
                     break;
                  case 5:
                     persone.get(i).setOrdinamento(Ordinamento.perGenere);
                     break;
               }
            }

            System.out.println("Aggiunta persona: " + persone.get(persone.size()-1));
            System.out.println("Ordimanento usato: " + persone.get(0).getOrdinamento());

            Collections.sort(persone);

            for (int i = 0; i < persone.size(); i++) {
               System.out.println(persone.get(i));
            }
         }
      });

      t.start();
      JOptionPane.showMessageDialog(null, "Chiudere?");
      System.exit(0);
   }
}
