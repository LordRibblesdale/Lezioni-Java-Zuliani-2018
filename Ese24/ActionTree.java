import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;

public class ActionTree extends JFrame {
   private JPanel panel, tree, item;
   private JTree branch1, branch2;
   private DefaultMutableTreeNode[] node;
   private DefaultMutableTreeNode[] childNode;
   private JLabel[] label;

   ActionTree() {
      panel = new JPanel();
      tree = new JPanel();
      item = new JPanel();

      branch1 = new JTree();

      node = new DefaultMutableTreeNode[3];
      node[0] = new DefaultMutableTreeNode("Oggetti");
      node[1] = new DefaultMutableTreeNode("Armi");
      node[2] = new DefaultMutableTreeNode("Magie");

      for (int i = 0; i < node.length; i++) {
         tree.add(node[i]);
      }

      childNode = new DefaultMutableTreeNode[6];

   }
}
