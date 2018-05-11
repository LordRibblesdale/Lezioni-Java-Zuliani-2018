import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.net.URL;

public class ItemDatabaseManager extends JFrame {
   private Item temp, items[] = new Item[10];
   private JToolBar tool_bar;
   private JList itemList;
   private JPanel panel;
   private JSplitPane splitPane;
   private JTextField nameField, descriptionField;
   private JComboBox typeBox;
   private JCheckBox consumableCheck;
   private JSpinner costSpinner;
   private Action cut, copy, paste, clear;
   private JButton apply;
   private ImageIcon icons[] = {new ImageIcon(getClass().getResource("cut.gif")),
                           new ImageIcon(getClass().getResource("copy.gif")),
                           new ImageIcon(getClass().getResource("paste.gif")),
                           new ImageIcon(getClass().getResource("exit.gif"))};

   ItemDatabaseManager() {
      super("Item Database Manager");
      panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
      nameField = new JTextField(20);
      descriptionField = new JTextField(20);
      typeBox = new JComboBox(Item.types);
      consumableCheck = new JCheckBox("Consumabile");

      for (int i = 0; i < items.length; i++) {
         items[i] = new Item();
      }

      JPanel gridPanel;

      gridPanel = new JPanel(new GridLayout(4, 0, 5, 5));
      gridPanel.add(new JLabel("Nome", SwingConstants.CENTER));
      gridPanel.add(nameField);
      gridPanel.add(new JLabel("Descrizione", SwingConstants.CENTER));
      gridPanel.add(descriptionField);
      panel.add(gridPanel);

      panel.add(gridPanel = new JPanel(new GridLayout(3, 2, 5, 5)));
      gridPanel.add(new JLabel("Tipo"));
      gridPanel.add(new JLabel("Costo"));
      gridPanel.add(typeBox);
      gridPanel.add(costSpinner = new JSpinner(new SpinnerNumberModel(50, 0, 200, 1)));
      gridPanel.add(consumableCheck);
      gridPanel.add(apply = new JButton("Apply"));

      apply.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            items[itemList.getSelectedIndex()] = new Item(nameField.getText(), descriptionField.getText(), (String)typeBox.getSelectedItem(), (Integer)costSpinner.getValue(), consumableCheck.isSelected());
            itemList.repaint();
         }
      });

      itemList = new JList(items);
      itemList.setSelectedIndex(0);
      itemList.addListSelectionListener(new ListSelectionListener() {
         public void valueChanged(ListSelectionEvent arg0) {
            setPanelValues();
         }
      });

      splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, itemList, panel);
      splitPane.setDividerLocation(200);

      class Action extends AbstractAction {
         private ImageIcon icon;

         Action(ImageIcon icon) {
            this.icon = icon;
            putValue(Action.SMALL_ICON, icon);
         }

         public void actionPerformed(ActionEvent e) {
            if (icon == icons[0]) {
               copy.actionPerformed(e);
               clear.actionPerformed(e);
            } else if (icon == icons[1]) {
                  temp = ((Item)itemList.getSelectedValue()).copy();
                  paste.setEnabled(true);
            } else if (icon == icons[2]) {
               items[itemList.getSelectedIndex()] = temp;
               itemList.repaint();
               setPanelValues();
            } else {
               items[itemList.getSelectedIndex()].clear();
               itemList.repaint();
               setPanelValues();
            }
         }
      }

      cut = new Action(icons[0]);
      copy = new Action(icons[1]);
      paste = new Action(icons[2]);
      paste.setEnabled(false);
      clear = new Action(icons[3]);


      tool_bar = new JToolBar();
      tool_bar.add(cut);
      tool_bar.add(copy);
      tool_bar.add(paste);
      tool_bar.add(clear);

      add(splitPane);
      add(tool_bar, BorderLayout.PAGE_START);
   }

   public void setPanelValues() {
      nameField.setText(items[itemList.getSelectedIndex()].getName());
      descriptionField.setText(items[itemList.getSelectedIndex()].getDescription());
      typeBox.setSelectedItem(items[itemList.getSelectedIndex()].getType());
      consumableCheck.setSelected(items[itemList.getSelectedIndex()].getConsumable());
      costSpinner.setValue((Integer)items[itemList.getSelectedIndex()].getCosto());
      validate();
   }

   public static void main(String[] args) {
      ItemDatabaseManager i = new ItemDatabaseManager();

      i.setSize(500, 500);
      i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      i.setLocationRelativeTo(null);
      i.setVisible(true);
   }
}
