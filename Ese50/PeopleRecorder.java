import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class PeopleRecorder extends JFrame {
   private JPanel center, pageEnd;
   private JScrollPane centerS;
   private JButton add, load, save;
   private ArrayList<JTextField> n, s, a;
   private ObjectInputStream input;
   private ObjectOutputStream output;
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

            centerS.repaint();
         }
      });

      load = new JButton("Carica");
      load.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            center = new JPanel();

            try {
               input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(getClass().getResource("Persone.bin").getPath().replaceAll("%20", " "))));
               p = ((ArrayList<Persona>) input.readObject());
               input.close();
            } catch (ClassNotFoundException f) {
               f.printStackTrace();
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

            centerS.repaint();
         }
      });

      save = new JButton("Salva");
      save.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < n.size(); i++) {
               p.add(new Persona(n.get(i).getText(), s.get(i).getText(), Integer.parseInt(a.get(i).getText())));
            }

            try {
               output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(getClass().getResource("Persone.bin").getPath().replaceAll("%20", " "))));
               output.writeObject(p);
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
