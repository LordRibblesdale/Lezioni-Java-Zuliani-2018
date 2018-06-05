import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.geom.*;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.util.Collections;

class Player implements Serializable, Comparable<Player> {
   String name;
   int score;

   Player(String name, int score) {
      this.name = name;
      this.score = score;
   }

   public int compareTo(Player p) {
      return new Integer(p.score).compareTo(new Integer(this.score));
   }

   public String toString() {
      return this.name + " " + this.score + "\n";
   }
}

public class FirstBallShooter extends JFrame {
   class GamePanel extends JPanel {
      private ArrayList<Ellipse2D> dots;
      private Ellipse2D crosshair;

      GamePanel() {
         dots = new ArrayList<>();
         crosshair = new Ellipse2D.Double(0, 0, 200, 200);
      }

      public void paintComponent(Graphics g) {
         super.paintComponent(g);

         Graphics2D g2 = (Graphics2D) g;

         g2.setPaint(Color.BLACK);
         g2.draw(crosshair);

         if (dots != null) {
            for (Ellipse2D dot : dots) {
               g2.setPaint(new Color((float) Math.random(), (float) Math.random(), (float) Math.random()));
               g2.fill(dot);
               g2.draw(dot);
            }
         }
      }

      public Ellipse2D getCrossHair() {
         return crosshair;
      }

      public ArrayList<Ellipse2D> getDots() {
         return dots;
      }
   }

   private GamePanel p;
   private Timer t;
   private int score, wave;
   private static int SIZE = 600, DOT_SIZE = 20;

   FirstBallShooter() {
      score = 0;
      wave = 1;

      p = new GamePanel();

      t = new Timer(2500, new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            int x = -1, y = -1;
            for (int i = 0; i < wave; i++) {
               x = (int)Math.floor(Math.random()*581);
               y = (int)Math.floor(Math.random()*581);

               p.getDots().add(new Ellipse2D.Double(x, y, DOT_SIZE, DOT_SIZE));
            }

            if (++wave >= 8) {
               FirstBallShooter.this.t.stop();

               p.addKeyListener(null);
               p.addMouseMotionListener(null);

               JOptionPane.showMessageDialog(FirstBallShooter.this, "Score: " + score);

               String s = JOptionPane.showInputDialog(FirstBallShooter.this, "Inserisci il nome: ", "Punteggio", JOptionPane.QUESTION_MESSAGE);

               ObjectInputStream input;
               ObjectOutputStream output;
               ArrayList<Player> list;

               try {
                  input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(getClass().getResource("Players.bin").getPath().replaceAll("%20", " "))));
                  list = ((ArrayList<Player>) input.readObject());

                  input.close();
               } catch (EOFException f) {
                  f.printStackTrace();
                  list = new ArrayList<>();
               } catch (FileNotFoundException f) {
                  f.printStackTrace();
                  list = new ArrayList<>();
               } catch (IOException f) {
                  f.printStackTrace();
                  list = new ArrayList<>();
               } catch (ClassNotFoundException f) {
                  f.printStackTrace();
                  list = new ArrayList<>();
               }

               try {
                  list.add(new Player(s, score));

                  Collections.sort(list);

                  output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(getClass().getResource("Players.bin").getPath().replaceAll("%20", " "))));
                  output.writeObject(list);
                  output.close();

                  s = "";

                  for (Player pl : list) {
                     s += pl.toString();
                  }
               } catch (IOException f) {
                  f.printStackTrace();
               }

               JOptionPane.showMessageDialog(FirstBallShooter.this, s);

               System.exit(0);
            } else {
               p.repaint();
               Toolkit.getDefaultToolkit().sync();
            }
         }
      });

      p.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent e) {
            p.getCrossHair().setFrameFromCenter(e.getX(), e.getY(), e.getX() + p.getCrossHair().getWidth()/2, e.getY() + p.getCrossHair().getHeight()/2);
            p.repaint();
            Toolkit.getDefaultToolkit().sync();
         }
      });

      p.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
               ArrayList<Ellipse2D> dotsToRemove = new ArrayList<>();
               int dotsInWave = p.getDots().size();

               if (!p.getDots().isEmpty()) {
                  for (int i = 0; i < p.getDots().size(); i++) {
                     Ellipse2D dot = p.getDots().get(i);
                     Point2D center = new Point2D.Double(dot.getCenterX(), dot.getCenterY());

                     if (p.getCrossHair().contains(center)) {
                        dotsToRemove.add(dot);
                        score += 10;
                     }

                     p.repaint();
                     Toolkit.getDefaultToolkit().sync();
                  }
               }

               for (Ellipse2D dot : dotsToRemove) {
                  p.getDots().remove(dot);
               }

               if (p.getDots().isEmpty()) {
                  score += 3*dotsInWave;
               }
            }
         }
      });

      p.setFocusable(true);
      p.requestFocusInWindow();

      add(p);

      t.start();

      setSize(SIZE, SIZE);
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      setResizable(false);
      setLocationRelativeTo(null);
      setVisible(true);
   }

   public static void main(String[] args) {
      FirstBallShooter f = new FirstBallShooter();
   }
}
