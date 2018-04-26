import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TastierinoFlow extends JFrame {
   private JButton[] button;
   private JTextField text;

   TastierinoFlow() {
      setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 5));

      text = new JTextField();
      text.setColumns(17);
      text.setEditable(false);

      button = new JButton[12];

      ActionListener l = new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < button.length; i++) {
               if (e.getSource() == button[i]) {
                  if (i == 9) {
                     try {
                        text.setText(text.getText().substring(0, text.getText().length()-1));
                     } catch(StringIndexOutOfBoundsException s) {
                        text.setText("");
                     }
                  } else if (i == 10) {
                     text.setText(text.getText() + String.valueOf(0));
                  } else if (i == 11) {
                     System.out.println("Number: " + text.getText());
                     text.setText("");
                  } else {
                     text.setText(text.getText() + String.valueOf(i+1));
                  }

                  validate();
               }
            }
         }
      };

      for (int i = 0; i < button.length; i++) {
         if (i == 9) {
            button[i] = new JButton("C");
         } else if (i == 10) {
            button[i] = new JButton("0");
         } else if (i == 11) {
            button[i] = new JButton("OK");
         } else {
            button[i] = new JButton(String.valueOf(i+1));
         }
         button[i].setPreferredSize(new Dimension(60, 40));
         button[i].addActionListener(l);
         add(button[i]);
      }

      add(text);

      setSize(217, 300);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
}
