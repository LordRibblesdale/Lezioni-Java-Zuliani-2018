import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class CustomExpansiveTableText extends JFrame {
   private JPanel panel;
   private JTable table;
   private ModelloStudenti model;
   private JSeparator separator;
   private JLabel label0, label1;
   private JTextField text0, text1;
   private JButton button;
   private Studente[] students;
   private static int i = 0;

   CustomExpansiveTableText() {
      panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

      label0 = new JLabel("Nome: ");
      text0 = new JTextField(20);
      label1 = new JLabel("Cognome: ");
      text1 = new JTextField(20);

      button = new JButton("Aggiungi (" + Integer.toString(i) + ")");
      students = new Studente[2];
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            i++;
            if (i < 3) {
               students[i-1] = new Studente(text0.getText(), text1.getText(), (int)Math.floor(Math.random()*90000)+10000, (int)Math.floor(Math.random()*13)+18, (int)Math.floor(Math.random()*Math.abs(20-i-1))+i-1);
               button.setText("Aggiungi (" + Integer.toString(i) + ")");
               text0.setText("");
               text1.setText("");
               validate();
            }
            if (i == 2) {
               model = new ModelloStudenti(students);
               button.setText("Aggiungi");
               table = new JTable(model);
               table.setAutoCreateRowSorter(true);
               panel.add(table.getTableHeader());
               panel.add(table);
               validate();
            }
            if (i >= 3) {
                  model.addStudent(new Studente(text0.getText(), text1.getText(), (int)Math.floor(Math.random()*90000)+10000, (int)Math.floor(Math.random()*13)+18, (int)Math.floor(Math.random()*Math.abs(20-model.getRowCount()))+model.getRowCount()));
                  text0.setText("");
                  text1.setText("");
                  table = new JTable(model);
                  validate();
               }

         }
      });

      separator = new JSeparator(SwingConstants.HORIZONTAL);
      separator.setPreferredSize(new Dimension(700, 1));

      panel.add(label0);
      panel.add(text0);
      panel.add(label1);
      panel.add(text1);
      panel.add(button);
      panel.add(separator);
      add(panel);

      setSize(700, 700);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
}
