import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PeopleRecorder extends JFrame {
   private JPanel center, pageEnd;
   private JScrollPane centerS;
   private JButton add, load, save;
   private ArrayList<JTextField> n, s, a;
   private Scanner input;
   private PrintWriter output;
   private ArrayList<Persona> p;

   PeopleRecorder() {
      centerS = new JScrollPane();
      center = new JPanel(new GridLayout(0, 2));
      centerS.setViewportView(center);
      centerS.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      centerS.setPreferredSize(new Dimension(450, 650));

      n = new ArrayList<JTextField>();
      s = new ArrayList<JTextField>();
      a = new ArrayList<JTextField>();
      p = new ArrayList<Persona>();


      pageEnd = new JPanel(new FlowLayout(FlowLayout.RIGHT));

      add = new JButton("Aggiungi Persona");
      add.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            n.add(new JTextField(10));
            s.add(new JTextField(10));
            a.add(new JTextField(10));

            center.add(new JLabel("Nome: "));
            center.add(n.get(n.size()-1));
            center.add(new JLabel("Cognome: "));
            center.add(s.get(s.size()-1));
            center.add(new JLabel("Eta': "));
            center.add(a.get(a.size()-1));

            validate();
         }
      });

      load = new JButton("Carica");
      load.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            center = new JPanel(new GridLayout(0, 2));
            n = new ArrayList<JTextField>();
            s = new ArrayList<JTextField>();
            a = new ArrayList<JTextField>();
            p = new ArrayList<Persona>();

            try {
               //getClass().getResource("Persone.bin").getPath().replaceAll("%20", " ")
               input = new Scanner(new BufferedReader(new FileReader(getClass().getResource("Persone.txt").getPath().replaceAll("%20", " "))));
               p = new ArrayList<Persona>();

               while (input.hasNext()) {
                  p.add(new Persona(input.nextLine(), input.nextLine(), Integer.parseInt(input.nextLine())));
                  input.nextLine();
               }

               input.close();
            } catch (IOException f) {
               f.printStackTrace();
            }

            for (int i = 0; i < p.size(); i++) {
               n.add(new JTextField(p.get(i).getNome()));
               s.add(new JTextField(p.get(i).getCognome()));
               a.add(new JTextField(p.get(i).getEta()));
               center.add(new JLabel("Nome: "));
               center.add(n.get(i));
               center.add(new JLabel("Cognome: "));
               center.add(s.get(i));
               center.add(new JLabel("Eta': "));
               center.add(a.get(i));
            }

            p = new ArrayList<Persona>();
            centerS.setViewportView(center);

            validate();
         }
      });

      save = new JButton("Salva");
      save.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < n.size(); i++) {
               p.add(new Persona(n.get(i).getText(), s.get(i).getText(), Integer.parseInt(a.get(i).getText())));
            }

            try {
               output = new PrintWriter(new BufferedWriter(new FileWriter(getClass().getResource("Persone.txt").getPath().replaceAll("%20", " "))));

               for (int i = 0; i < p.size(); i++) {
                  output.write(p.get(i).getNome() + "\n" + p.get(i).getCognome() + "\n" + p.get(i).getEta() + "\n\n");
               }

               output.close();

               output = new PrintWriter(new BufferedWriter(new FileWriter(getClass().getResource("PersoneOut.txt").getPath().replaceAll("%20", " "))));

               for (int i = 0; i < p.size(); i++) {
                  output.format(p.get(i).toString());
               }

               output.close();
            } catch (IOException f) {
               f.printStackTrace();
            }
         }
      });

      pageEnd.add(load);
      pageEnd.add(add);
      pageEnd.add(save);

      add(centerS, BorderLayout.CENTER);
      add(pageEnd, BorderLayout.PAGE_END);

      setResizable(false);
      setSize(500, 700);
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args) {
      PeopleRecorder r = new PeopleRecorder();
   }
}
