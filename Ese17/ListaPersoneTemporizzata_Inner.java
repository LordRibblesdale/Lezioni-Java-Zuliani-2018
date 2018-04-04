import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.ArrayList;

public class ListaPersoneTemporizzata_Inner {
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
      class Listener implements ActionListener {
         Listener() {}

         public void actionPerformed(ActionEvent e) {
            getLista().add(generaPersona());
         }
      }

      Timer t = new Timer(750, new Listener());
      t.start();

      JOptionPane.showMessageDialog(null, "Chiudere?");
      System.exit(0);
   }
}
