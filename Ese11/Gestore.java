import java.awt.event.*;

public class Gestore implements ActionListener {
   protected DigitStamper dsampler;

   Gestore() {
      dsampler = new DigitStamper(168744412, 4, 'd');
   }

   public void actionPerformed(ActionEvent e) {
      dsampler.maskedStamp();
      dsampler.randomise();
      dsampler.stamp();
   }
}
