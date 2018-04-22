import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorChooserPanelAdder extends JFrame {
   private JPanel mainPanel;
   private JColorChooser color;
   private JButton button;

   ColorChooserPanelAdder() {
      mainPanel = new JPanel(new FlowLayout());
      color = new JColorChooser();
      button = new JButton("Aggiungi");

      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            JPanel pane = new JPanel();
            pane.setBackground(color.getColor());
            pane.add(new JLabel("R: " +  color.getColor().getRed() + " G: " + color.getColor().getGreen() + " B: " + color.getColor().getBlue()));
            mainPanel.add(pane);
            validate();
         }
      });

      mainPanel.add(color);
      mainPanel.add(button);
      add(mainPanel);

      setSize(new Dimension(700, 500));
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
}
