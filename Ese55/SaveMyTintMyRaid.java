import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.filechooser.FileFilter;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class SaveMyTintMyRaid extends TintMyRaid {
   protected JMenuItem saveItem;

   SaveMyTintMyRaid() {
      super();

      menu.add((saveItem = new JMenuItem("Salva Immagine")));
      saveItem.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent arg0) {
            JFileChooser f = new JFileChooser();
            f.setAcceptAllFileFilterUsed(false);
            f.addChoosableFileFilter(new FileFilter() {
               private final String png = "png";

               public boolean accept(File pathname) {
                  String s = pathname.getName();
                  int i = s.lastIndexOf(".");

                  if (i != -1) {
                     String e = s.substring(i+1, s.length());

                     return e.equalsIgnoreCase(png);
                  }

                  return pathname.isDirectory();
              }

               public String getDescription() {
                  return "*.png";
               }
            });

            f.addChoosableFileFilter(new FileFilter() {
               private final String jpg = "jpeg";

               public boolean accept(File pathname) {
                  String s = pathname.getName();
                  int i = s.lastIndexOf(".");

                  if (i != -1) {
                     String e = s.substring(i+1, s.length());

                     return e.equalsIgnoreCase(jpg);
                  }

                  return pathname.isDirectory();
             }

               public String getDescription() {
                  return "*.jpg";
               }
            });

            int r = 0;
            if (edit != null) {
               r = f.showSaveDialog(SaveMyTintMyRaid.this);

               if (r == JFileChooser.APPROVE_OPTION) {
                  try {
                     //TODO Not working
                     ImageIO.write(edit, f.getFileFilter().getDescription().substring(1), f.getSelectedFile());
                  } catch (IOException e) {
                     e.printStackTrace();
                  }
               }
            }
         }
      });

      validate();
   }

   public static void main(String[] args) {
      SaveMyTintMyRaid t = new SaveMyTintMyRaid();
   }
}
