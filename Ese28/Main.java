import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;

class Window extends JFrame {
   private JPanel panel0, panel1;
   private JTree tree;
   private DefaultMutableTreeNode node, s[];
   private JLabel[] label; //5

   Window(Studente[] st) {
      setLayout(new GridLayout(0, 1));
      panel0 = new JPanel();
      panel1 = new JPanel(new FlowLayout());

      label = new JLabel[5];
      panel1.add((label[0] = new JLabel("-")));
      panel1.add((label[1] = new JLabel("-")));
      panel1.add((label[2] = new JLabel("-")));
      panel1.add((label[3] = new JLabel("-")));
      panel1.add((label[4] = new JLabel("-")));

      node = new DefaultMutableTreeNode("Studenti");
      s = new DefaultMutableTreeNode[st.length];

      for (int i = 0; i < s.length; i++) {
         s[i] = new DefaultMutableTreeNode(st[i]);
         node.add(s[i]);
      }
      tree = new JTree(node);

      tree.addTreeSelectionListener(new TreeSelectionListener() {
         public void valueChanged(TreeSelectionEvent e) {
            DefaultMutableTreeNode a = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();

            if (a == null) {
               return;
            } else if (a.isLeaf()){
               if (a.getUserObject() instanceof Studente) {
                  label[0].setText("Nome: " + ((Studente)a.getUserObject()).getNome());
                  label[1].setText("Cognome: " + ((Studente)a.getUserObject()).getCognome());
                  label[2].setText("Matricola: " + ((Studente)a.getUserObject()).getMatricola());
                  label[3].setText("Media Voti: " + ((Studente)a.getUserObject()).getMediaVoti());
                  label[4].setText("Esami: " + ((Studente)a.getUserObject()).getEsamiVerbalizzati());
                  validate();
               }
            }

         }
      });
      tree.setPreferredSize(new Dimension(250, 250));
      tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
      panel0.add(tree);

      add(panel0);
      add(new JSeparator());
      add(panel1);

      setSize(500, 500);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
}

public class Main {
   public static void main(String[] args) {
      Studente s[] = {new Studente("F", "D", 164, 31, 12), new Studente("D", "V", 411, 31, 22), new Studente("L", "N", 15, 44, 20)};
      Window a = new Window(s);
   }
}
