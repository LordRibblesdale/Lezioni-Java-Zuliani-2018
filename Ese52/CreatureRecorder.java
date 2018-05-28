import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.filechooser.FileFilter;
import java.util.ArrayList;

public class CreatureRecorder extends JFrame {
   private JScrollPane centerS;
   private JPanel center, pageEnd;
   private JButton addC;
   private JMenuBar menu;
   private JMenuItem load, save;
   private ObjectInputStream input;
   private ObjectOutputStream output;
   private ArrayList<JTextField> names, race, description, strength, dexterity, intelligence;
   private ArrayList<JCheckBox> ally;
   private ArrayList<Creatura> creatures;

   CreatureRecorder() {
      center = new JPanel(new GridLayout(0, 1));
      centerS = new JScrollPane();
      //centerS.setViewportView(center);
      centerS.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

      names = new ArrayList<>();
      race = new ArrayList<>();
      description = new ArrayList<>();
      strength = new ArrayList<>();
      dexterity = new ArrayList<>();
      intelligence = new ArrayList<>();
      ally = new ArrayList<>();
      creatures = new ArrayList<>();

      pageEnd = new JPanel(new FlowLayout(FlowLayout.RIGHT));
      pageEnd.add((addC = new JButton("Aggiungui Creatura")));
      addC.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            JPanel p = new JPanel(new GridLayout(0, 1));
            JPanel inP = new JPanel(new FlowLayout());

            //TODO optimise here
            inP.add(new JLabel("Nome: "));
            names.add(new JTextField(10));
            inP.add(names.get(names.size()-1));

            p.add(inP);
            inP = new JPanel(new FlowLayout());

            inP.add(new JLabel("Razza: "));
            race.add(new JTextField(10));
            inP.add(race.get(race.size()-1));

            p.add(inP);
            inP = new JPanel(new FlowLayout());

            inP.add(new JLabel("Descrizione: "));
            description.add(new JTextField(10));
            inP.add(description.get(description.size()-1));

            p.add(inP);
            inP = new JPanel(new FlowLayout());

            inP.add(new JLabel("Forza: "));
            strength.add(new JTextField("1", 10));
            inP.add(description.get(description.size()-1));

            p.add(inP);
            inP = new JPanel(new FlowLayout());

            inP.add(new JLabel("Destrezza: "));
            dexterity.add(new JTextField("1", 10));
            inP.add(dexterity.get(dexterity.size()-1));

            p.add(inP);
            inP = new JPanel(new FlowLayout());

            inP.add(new JLabel("Intelligenza: "));
            intelligence.add(new JTextField("1", 10));
            inP.add(intelligence.get(intelligence.size()-1));

            p.add(inP);
            inP = new JPanel(new FlowLayout());

            inP.add(new JLabel("Alleato(?): "));
            ally.add(new JCheckBox());
            inP.add(ally.get(ally.size()-1));

            p.add(inP);
            center.add(p);
            center.add(new JSeparator());
            centerS.setViewportView(center);

            validate();
         }
      });

      menu = new JMenuBar();
      setJMenuBar(menu);

      load = new JMenuItem("Carica");
      load.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            center = new JPanel(new GridLayout(0, 1));

            JFileChooser f = new JFileChooser();
            f.addChoosableFileFilter(new FileFilter() {
               private final String bin = "bin";

               public boolean accept(File pathname) {
                  String s = pathname.getName();
                  int i = s.lastIndexOf(".");

                  if (i != -1) {
                     String e = s.substring(i+1, s.length());

                     return e.equalsIgnoreCase(bin);
                  }

                  return pathname.isDirectory();
              }

               public String getDescription() {
                  return "*.bin";
               }
            });
            f.setAcceptAllFileFilterUsed(false);

            switch (f.showOpenDialog(CreatureRecorder.this)) {
               case JFileChooser.APPROVE_OPTION:
                  try {
                     input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f.getSelectedFile())));

                     try {
                        ArrayList<?> c = (ArrayList<?>) input.readObject();
                     } catch (ClassNotFoundException g) {
                        g.printStackTrace();
                     }

                     for (int i = 0; i < creatures.size(); i++) {

                     }
                  } catch (IOException g) {
                     g.printStackTrace();
                  } catch (SecurityException g) {
                     g.printStackTrace();
                  } catch (NullPointerException g) {
                     g.printStackTrace();
                  }

                  for (int i = 0; i < names.size(); i++) {
                     creatures.add(new Creatura(names.get(i).getText(), race.get(i).getText(), description.get(i).getText(),
                                          Integer.parseInt(strength.get(i).getText()),
                                          Integer.parseInt(strength.get(i).getText()),
                                          Integer.parseInt(intelligence.get(i).getText()),
                                          ally.get(i).isSelected()));

                     JPanel p = new JPanel(new GridLayout(0, 1));
                     JPanel inP = new JPanel(new FlowLayout());

                     //TODO optimise here
                     inP.add(new JLabel("Nome: "));
                     names.add(new JTextField(10));
                     inP.add(names.get(names.size()-1));

                     p.add(inP);
                     inP = new JPanel(new FlowLayout());

                     inP.add(new JLabel("Razza: "));
                     race.add(new JTextField(10));
                     inP.add(race.get(race.size()-1));

                     p.add(inP);
                     inP = new JPanel(new FlowLayout());

                     inP.add(new JLabel("Descrizione: "));
                     description.add(new JTextField(10));
                     inP.add(description.get(description.size()-1));

                     p.add(inP);
                     inP = new JPanel(new FlowLayout());

                     inP.add(new JLabel("Forza: "));
                     strength.add(new JTextField("1", 10));
                     inP.add(description.get(description.size()-1));

                     p.add(inP);
                     inP = new JPanel(new FlowLayout());

                     inP.add(new JLabel("Destrezza: "));
                     dexterity.add(new JTextField("1", 10));
                     inP.add(dexterity.get(dexterity.size()-1));

                     p.add(inP);
                     inP = new JPanel(new FlowLayout());

                     inP.add(new JLabel("Intelligenza: "));
                     intelligence.add(new JTextField("1", 10));
                     inP.add(intelligence.get(intelligence.size()-1));

                     p.add(inP);
                     inP = new JPanel(new FlowLayout());

                     inP.add(new JLabel("Alleato(?): "));
                     ally.add(new JCheckBox());
                     inP.add(ally.get(ally.size()-1));

                     p.add(inP);
                     center.add(p);
                     center.add(new JSeparator());
                     centerS.setViewportView(center);

                     validate();
                  }
            }
         }
      });

      menu.add(load);

      setResizable(false);
      setSize(500, 700);
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args) {

   }
}
