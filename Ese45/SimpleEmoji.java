import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class SimpleEmoji {
   protected Ellipse2D face, leftEye, rightEye;
   protected Color faceColor, eyesColor;

   SimpleEmoji(Rectangle2D r) {
      face = new Ellipse2D.Double(r.getX() + r.getWidth()/2, r.getY() + r.getHeight()/2, r.getHeight(), r.getHeight());
      leftEye = new Ellipse2D.Double(r.getX() + r.getWidth()/2, r.getY() + r.getHeight()/2, r.getHeight()/2, r.getHeight()/2);
      rightEye = new Ellipse2D.Double(r.getX() + r.getWidth()/2 + leftEye.getWidth(), r.getY() + r.getHeight()/2, r.getHeight()/2, r.getHeight()/2);

      faceColor = Color.YELLOW;
      eyesColor = Color.BLACK;
   }

   public Color getFaceColor() {
      return faceColor;
   }

   public void setFaceColor(Color c) {
      faceColor = c;
   }

   public Color getEyesColor() {
      return eyesColor;
   }

   public void setEyesColor(Color c) {
      eyesColor = c;
   }

   public void draw(Graphics2D g) {
      g.setPaint(Color.BLACK);
      g.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.CAP_ROUND));
      g.setPaint(faceColor);
      g.draw(face);
      g.setStroke(new BasicStroke(1));

      g.setPaint(eyesColor);
      g.draw(leftEye);
      g.draw(rightEye);
   }
}
