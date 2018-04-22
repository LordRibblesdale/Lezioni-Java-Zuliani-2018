import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TimedProgress extends JFrame {
   private JPanel mainPanel;
   private JProgressBar progress;
   private JButton button0, button1;
   private JSlider slider;
   private Timer t;
   private static int i = 0;

   TimedProgress() {
      mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
      progress = new JProgressBar(0, 100);
      progress.setPreferredSize(new Dimension(180, 20));
      progress.setStringPainted(true);

      button0 = new JButton("Start");
      button1 = new JButton("Stop");

      t = new Timer(500, new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (progress.getValue() < 100) {
               progress.setValue(progress.getValue() + slider.getValue());
            } else {
               t.stop();
               button0.setEnabled(false);
               button1.setEnabled(false);
               slider.setEnabled(false);

               ProgressMonitor m = new ProgressMonitor(null, "Secondi al completamento", "10", 0, 10);

               t = new Timer(1000, new ActionListener() {
                  public void actionPerformed(ActionEvent eve) {
                     if (i <= 10) {
                        m.setProgress(i);
                        m.setNote(Integer.toString(10 - i++));
                     } else {
                        t.stop();
                        System.out.println("\nCaricamento completato");
                        System.exit(0);
                     }
                  }
               });
               t.start();
            }
         }
      });

      button0.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            button1.setEnabled(true);
            button0.setEnabled(false);
            validate();

            t.start();
         }
      });
      button1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ev) {
            t.stop();
            button1.setEnabled(false);
            button0.setEnabled(true);
            button0.setText("Restart");
            validate();

         }
      });

      slider = new JSlider(1, 9, 5);
      slider.setMajorTickSpacing(1);
      slider.setPaintTicks(true);
      slider.setPaintLabels(true);
      slider.setSnapToTicks(true);

      mainPanel.add(progress);
      mainPanel.add(slider);
      mainPanel.add(button0);
      mainPanel.add(button1);
      add(mainPanel);

      setSize(220, 200);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
}
