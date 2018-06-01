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
            editRGB(edit, arg0.getPoint());
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

   protected void editRGB(BufferedImage img, Point2D p) {
      edit = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
      Rectangle2D r = new Rectangle2D.Double(0, 0, edit.getWidth(), edit.getHeight());

      for (int i = (int) p.getX(); i < (int) p.getX() + cursor.getWidth(); i++) {
         for (int j = (int) p.getY(); j < (int) p.getY() + cursor.getHeight(); j++) {
            int pixels = 0;
            double sum = 0;

            for (int h = (int) p.getX()-10; h < p.getX()+10; h++) {
               for (int k = (int) p.getY()-10; k < p.getY()+10; k++) {
                  if (r.contains(new Point2D.Double(h, k))) {
                     sum += edit.getRGB(h, k);
                     pixels++;
                  }
               }
            }

            edit.setRGB(i, j, (int) (sum/(float) pixels));
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
