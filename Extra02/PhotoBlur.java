import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.filechooser.FileFilter;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class PhotoBlur extends JFrame {
   protected JPanel p;
   protected BufferedImage image, edit;
   protected Rectangle2D cursor;
   protected JButton b;
   private static int i = 0;

   PhotoBlur() throws IOException {
      image = ImageIO.read(new File("image.jpeg"));
      cursor = new Rectangle2D.Double(0, 0, 21, 21);

      p = new JPanel() {
         public void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (i++ == 0) {
               copyRGB(image);
            }

            g.drawImage(edit, 0, 0, null);
            PhotoBlur.this.setSize(image.getWidth(), image.getHeight());
            PhotoBlur.this.validate();
            ((Graphics2D) g).setPaint(Color.BLACK);
            ((Graphics2D) g).draw(cursor);
         }
      };

      p.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent e) {
            cursor.setFrame(e.getX() - cursor.getWidth()/2, e.getY() - cursor.getHeight()/2, cursor.getWidth(), cursor.getHeight());
            repaint();
         }
      });

      p.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent arg0) {
            editRGB(edit);
            repaint();
         }
      });

      add(p);

      setResizable(false);
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(600, 400);
   }

   protected void editRGB(BufferedImage img) {
      for (int i = (int) cursor.getX(); i < (int) cursor.getX() + cursor.getWidth(); i++) {
         for (int j = (int) cursor.getY(); j < (int) cursor.getY() + cursor.getHeight(); j++) {
            int pixels = 0;
            int red = 0, green = 0, blue = 0;

            for (int h = i-10; h < i+10; h++) {
               for (int k = j-10; k < j+10; k++) {
                  if (h >= 0 && h < edit.getWidth() && k >= 0 && k < edit.getHeight()) {
                     Color c = new Color(image.getRGB(h, k));
                     red += c.getRed();
                     green += c.getGreen();
                     blue += c.getBlue();
                     pixels++;
                  }
               }
            }

            if (i >= 0 && i < edit.getWidth() && j >= 0 && j < edit.getHeight()) {
               edit.setRGB(i, j, (new Color(red/pixels, green/pixels, blue/pixels)).getRGB());
            }
         }
      }
   }

   protected void copyRGB(BufferedImage img) {
      edit = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);

      for (int i = 0; i < edit.getWidth(); i++) {
         for (int j = 0; j < edit.getHeight(); j++) {
            edit.setRGB(i, j, (new Color(new Color(img.getRGB(i, j)).getRed(), new Color(img.getRGB(i, j)).getGreen(), new Color(img.getRGB(i, j)).getBlue())).getRGB());
         }
      }
   }

   public static void main(String[] args) throws IOException {
      PhotoBlur p = new PhotoBlur();
   }
}
