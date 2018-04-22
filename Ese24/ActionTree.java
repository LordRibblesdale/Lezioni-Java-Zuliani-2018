import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;

public class ActionTree extends JFrame {
   private JPanel panel, tree, item;
   private JPanel[] items;
   private JTree branch;
   private DefaultMutableTreeNode master;
   private DefaultMutableTreeNode[] node, childNode;
   private JLabel name, nameValue, type, typeValue, desc, descValue;

   ActionTree() {
      super("Tree Test");

      panel = new JPanel(new GridLayout(1, 0));
      tree = new JPanel();
      item = new JPanel(new GridLayout(0, 1));

      node = new DefaultMutableTreeNode[3];
      node[0] = new DefaultMutableTreeNode("Oggetti");
      node[1] = new DefaultMutableTreeNode("Armi");
      node[2] = new DefaultMutableTreeNode("Magie");

      childNode = new DefaultMutableTreeNode[6];
      childNode[0] = new DefaultMutableTreeNode(new Azione("Pozione", "Una pozione curativa"));
      childNode[1] = new DefaultMutableTreeNode(new Azione("Torcia", "Perche' la notte e' buia e piena di terrori"));
      for (int i = 0; i < 2; i++) {
         node[0].add(childNode[i]);
      }

      childNode[2] = new DefaultMutableTreeNode(new Azione("Spada", "L'arma piu' usata a Westeros"));
      childNode[3] = new DefaultMutableTreeNode(new Azione("Balesta", "L'arma piu' adatta ad uccidere vecchi leoni"));
      for (int i = 2; i < 4; i++) {
         node[1].add(childNode[i]);
      }

      childNode[4] = new DefaultMutableTreeNode(new Azione("Palla di fuoco", "Un classico"));
      childNode[5] = new DefaultMutableTreeNode(new Azione("30 ad Analisi", "Se non e' magia questa..."));
      for (int i = 4; i < 6; i++) {
         node[2].add(childNode[i]);
      }

      master = new DefaultMutableTreeNode();
      for (int i = 0; i < node.length; i++) {
         master.add(node[i]);
      }

      branch = new JTree(master);

      name = new JLabel("Nome: ");
      nameValue = new JLabel("----");
      type = new JLabel("Tipo: ");
      typeValue = new JLabel("----");
      desc = new JLabel("Descrizione: ");
      descValue = new JLabel("----");

      branch.addTreeSelectionListener(new TreeSelectionListener() {
         public void valueChanged(TreeSelectionEvent arg0) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)branch.getLastSelectedPathComponent();

            if (node == null) {
               return;
            } else if (node.isLeaf()) {
               if (node.getUserObject() instanceof Azione) {
                  TreeNode[] dir = node.getPath();
                  String s = "";

                  nameValue.setText(((Azione)node.getUserObject()).getNome());
                  for (int i = 0; i < dir.length; i++) {
                     s += dir[i];
                  }
                  typeValue.setText(s);
                  descValue.setText(((Azione)node.getUserObject()).getDescrizione());
                  validate();
               }
            }
         }
      });

      tree.setPreferredSize(new Dimension(100, 200));
      tree.add(branch);

      items = new JPanel[3];
      for (int i = 0; i < items.length; i++) {
         items[i] = new JPanel(new FlowLayout());
      }
      items[0].add(name);
      items[0].add(nameValue);
      items[1].add(type);
      items[1].add(typeValue);
      items[2].add(desc);
      items[2].add(descValue);
      for (int i = 0; i < items.length; i++) {
         item.add(items[i]);
      }

      panel.add(tree);
      panel.add(item);
      add(panel);

      getContentPane().setBackground(new Color(Color.WHITE));

      setSize(500, 500);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
}
