import javax.swing.JFrame;          //Used for window initialisation
import javax.swing.JLabel;          //Used for labels
import javax.swing.JPanel;
import java.awt.GridLayout;         //Specifically used as component layout
import java.awt.FlowLayout;
//import javax.swing.SwingConstants;  //Used to assing positions in layoyts
import javax.swing.JOptionPane;     //Used for dialogs
import javax.swing.JTextField;      //Used for text field

import javax.swing.Icon;            //Used as superclass for ImageIcon  -VVVVVVVVVVV-
import javax.swing.ImageIcon;       //Used for icons        // Icon icon = new ImageIcon(getClass().getResource("computer.png"));
import java.awt.Image;              //Used for icon setup in window
import java.awt.Color;              //Used for window color
import javax.swing.ImageIcon;       //Used for icons management

import java.awt.Toolkit;            //Used for window tools
import java.awt.Dimension;          //Used for Component/Window dimension

import java.net.URL;                //Used for resources (icons) locations

class WindowA extends JFrame {
   private JLabel label1;  //private/protected/public
   private JLabel label2;
   Image iconLabel = new ImageIcon(getClass().getResource("computer.png")).getImage();
   Icon icon = new ImageIcon(getClass().getResource("computer.png"));


   WindowA() {
      super("WindowA");

      // URL icon_url = getClass().getResource("computer.png");
      setIconImage(iconLabel);

      setSize(400, 400);               //Only for window dimension
      setLocationRelativeTo(null);     //Position relative to window or frame

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Sets what to do closing the window
                                                      //This closes the program

      setLayout(new FlowLayout());

      label2 = new JLabel(" <- Images -> ");
      label2.setIcon(icon);
      label2.setToolTipText("This is a tooltip too");
      add(label2);

      label1 = new JLabel();
      label1.setIcon(icon);
      label1.setToolTipText("This is a tooltip");
      add(label1);

      // setText(), setIcon(), setHorizontal/VerticalTextPosition()
   }
}

class WindowB extends JFrame {
   private JLabel labelText;
   private JTextField field;

   WindowB() {
      super("WindowB");

      // URL icon_url = getClass().getResource("computer.png");
      Image icon = new ImageIcon(getClass().getResource("computer.png")).getImage();

      setIconImage(icon);

      int width = 250;
      int height = 150;
      setSize(width, height);               //Only for window dimension

      setLayout(new FlowLayout());

      // Toolkit kit = Toolkit.getDefaultToolkit();   //Obtaining tools for screen dimension (in this case)
      // Dimension screenSize = kit.getScreenSize();  //Obtaining screen dimensions

      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      int x = (screenSize.width / 4) - (width / 4);
      int y = (screenSize.height / 2) - (height / 2);

      setLocation(x, y);     //Location relative to coordinates

      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //This destroys the window

      labelText = new JLabel("Program is here:");
      field = new JTextField("Hello world");

      add(labelText);
      add(field);
   }
}

class WindowC extends JFrame {
   private JPanel panel;

   WindowC() {
      super("WindowC");
      panel = new JPanel();

      // URL icon_url = getClass().getResource("computer.png");
      Image icon = new ImageIcon(getClass().getResource("computer.png")).getImage();

      setIconImage(icon);

      int width = 350;
      int height = 350;
      setSize(width, height);               //Only for window dimension

      panel.setBackground(Color.BLUE);
      add(panel);

      // Toolkit kit = Toolkit.getDefaultToolkit();   //Obtaining tools for screen dimension (in this case)
      // Dimension screenSize = kit.getScreenSize();  //Obtaining screen dimensions

      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      int x = (screenSize.width / 2) + (width / 2);
      int y = (screenSize.height / 2) - (height / 2);

      setLocation(x, y);     //Location relative to coordinates

      setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
   }
}

public class ThreeWindows {
   public static void main(String[] args) {
      WindowA a = new WindowA();
      WindowB b = new WindowB();
      WindowC c = new WindowC();

      class Dialog {
         private Object[] option = {"A", "B", "C", "A and B", "A and C", "B and C", "A, B and C"};
         private Object choice;

         Dialog() {
            choice = JOptionPane.showInputDialog(null, "Choose window to initialise", "WindowInitialiser", JOptionPane.INFORMATION_MESSAGE, null, option, option[0]);

            if (choice == null) {
               JOptionPane.showMessageDialog(null, "No choice..\nClosing..", "WindowInitialiser", JOptionPane.ERROR_MESSAGE);
            } else if (choice == option[0]) {
               a.setVisible(true);
            } else if (choice == option[1]) {
               b.setVisible(true);
            } else if (choice == option[2]) {
               c.setVisible(true);
            } else if (choice == option[3]) {
               a.setVisible(true);
               b.setVisible(true);
            } else if (choice == option[4]) {
               a.setVisible(true);
               c.setVisible(true);
            } else if (choice == option[5]) {
               b.setVisible(true);
               c.setVisible(true);
            } else {
               a.setVisible(true);
               b.setVisible(true);
               c.setVisible(true);
            }
         }
      }

      Dialog d = new Dialog();
   }
}
