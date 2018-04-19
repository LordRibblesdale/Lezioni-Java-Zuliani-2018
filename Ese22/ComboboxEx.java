import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboboxEx extends JFrame {
   private JPanel panel;
   private JComboBox box;
   private JTextField text;
   private JButton button;

   private String[] jpack = {"JButton", "JLabel"};

   ComboboxEx() {
      panel = new JPanel();
      box = new JComboBox(jpack);
      text = new JTextField("Testo", 10);
      button = new JButton("Aggiungi");

      ActionListener l = new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (box.getSelectedItem() == jpack[0]) {
               JButton btmp = new JButton("Stampa");
               String s = text.getText();
               btmp.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent arg0) {
                     System.out.println(s);
                  }
               });
               panel.add(btmp);
            } else {
               panel.add(new JLabel(text.getText()));
            }

            validate();
         }
      };

      button.addActionListener(l);

      panel.add(box);
      panel.add(text);
      panel.add(button);
      add(panel);

      setVisible(true);
      setSize(500, 500);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
