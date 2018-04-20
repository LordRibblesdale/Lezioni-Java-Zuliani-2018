//import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ColorSlider extends JFrame {
   private JPanel panel;
   private JPanel[] org;
   private JLabel[] label;
   private JSlider[] slider;
   private JList<String> list;
   //private Hashtable<Integer, >
   private JButton button;
   private JTextField text;

   private String[] colorS = {"Nero", "Ciano", "Grigio", "Verde", "Magenta", "Giallo"};
   private Color[] colorC = {Color.BLACK, Color.CYAN, Color.GRAY, Color.GREEN, Color.MAGENTA, Color.YELLOW};
   private String[] rgb = {"R", "G", "B"};

   ColorSlider() {
      panel = new JPanel(new GridLayout(0, 1));
      label = new JLabel[3];
      slider = new JSlider[3];
      org = new JPanel[3];

      for (int i = 0; i < label.length; i++) {
         label[i] = new JLabel(rgb[i]);
         //panel.add(label[i]);
         slider[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
         slider[i].setMajorTickSpacing(32);
         slider[i].setPaintTicks(true);
         org[i] = new JPanel();
         org[i].add(label[i]);
         org[i].add(slider[i]);

         panel.add(org[i]);
      }

      list = new JList<String>(colorS);
      list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      list.addListSelectionListener(new ListSelectionListener() {
         public void valueChanged(ListSelectionEvent ev) {
            //text.setForeground(colorC[list.getSelectedIndex()]);
            slider[0].setValue(colorC[list.getSelectedIndex()].getRed());
            slider[1].setValue(colorC[list.getSelectedIndex()].getGreen());
            slider[2].setValue(colorC[list.getSelectedIndex()].getBlue());
            validate();
         }
      });
      panel.add(list);

      button = new JButton("Applica");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            text.setForeground(new Color(slider[0].getValue(), slider[1].getValue(), slider[2].getValue()));
            validate();
         }
      });
      add(button, BorderLayout.PAGE_END);

      add(panel);

      text = new JTextField("ColorSlider");
      add(text, BorderLayout.SOUTH);

      setSize(500, 500);
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
