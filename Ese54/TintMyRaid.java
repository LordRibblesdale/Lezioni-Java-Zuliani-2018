import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.filechooser.FileFilter;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class TintMyRaid extends JFrame {
   private JMenuBar bar;
   private JMenu menu;
   private JMenuItem openFile;
   private JRadioButtonMenuItem red, green, blue, gray;
   private ButtonGroup g;
   private Color c;
   private JPanel p;
   private BufferedImage image, edit;
   private ActionListener l = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         if (image != null) {
            editRGB(image);
            p.repaint();
            setSize(edit.getWidth(), edit.getHeight() + bar.getHeight());
            validate();
         }
      }
   };

   TintMyRaid() {
      p = new JPanel() {
         public void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (image != null && edit != null) {
               g.drawImage(edit, 0, 0, null);
            }
         }
      };

      bar = new JMenuBar();
      bar.add(menu = new JMenu("Menu"));
      menu.add(openFile = new JMenuItem("Apri file"));
      openFile.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent arg0) {
            JFileChooser f = new JFileChooser();
            f.setAcceptAllFileFilterUsed(false);
            f.addChoosableFileFilter(new FileFilter() {
               private final String jpg = "jpeg";
               private final String png = "png";

               public boolean accept(File pathname) {
                  String s = pathname.getName();
                  int i = s.lastIndexOf(".");

                  if (i != -1) {
                     String e = s.substring(i+1, s.length());

                     return e.equalsIgnoreCase(jpg) || e.equalsIgnoreCase(png);
                  }

                  return pathname.isDirectory();
              }

               public String getDescription() {
                  return "*.jpg, *.png";
               }
            });

            int r = f.showOpenDialog(TintMyRaid.this);

            if (r == JFileChooser.APPROVE_OPTION) {
               try {
                  image = ImageIO.read(f.getSelectedFile());
               } catch (IOException e) {
                  e.printStackTrace();
               }

               editRGB(image);
               p.repaint();
               setSize(edit.getWidth(), edit.getHeight() + bar.getHeight());
               validate();
            }
         }
      });

      menu.add(new JSeparator());
      menu.add(red = new JRadioButtonMenuItem("Red"));
      red.addActionListener(l);
      menu.add(green = new JRadioButtonMenuItem("Green"));
      green.addActionListener(l);
      menu.add(blue = new JRadioButtonMenuItem("Blue"));
      blue.addActionListener(l);
      menu.add(gray = new JRadioButtonMenuItem("Gray"));
      gray.addActionListener(l);

      g = new ButtonGroup();
      g.add(red);
      g.add(green);
      g.add(blue);
      g.add(gray);

      red.setSelected(true);

      setJMenuBar(bar);
      add(p);

      setResizable(false);
      setSize(500, 700);
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   private void editRGB(BufferedImage img) {
      edit = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);

      for (int i = 0; i < edit.getWidth(); i++) {
         for (int j = 0; j < edit.getHeight(); j++) {
            if (red.isSelected()) {
               edit.setRGB(i, j, (new Color(new Color(img.getRGB(i, j)).getRed(), 0, 0)).getRGB());
            } else if (green.isSelected()) {
               edit.setRGB(i, j, (new Color(0, new Color(img.getRGB(i, j)).getGreen(), 0)).getRGB());
            } else if (blue.isSelected()) {
               edit.setRGB(i, j, (new Color(0, 0, new Color(img.getRGB(i, j)).getBlue())).getRGB());
            } else {
               int gr = (new Color(img.getRGB(i, j)).getRed() + new Color(img.getRGB(i, j)).getGreen() + new Color(img.getRGB(i, j)).getBlue())/3;
               edit.setRGB(i, j, (new Color(gr, gr, gr)).getRGB());
            }
         }
      }
   }

   public static void main(String[] args) {
      TintMyRaid t = new TintMyRaid();
   }
}
