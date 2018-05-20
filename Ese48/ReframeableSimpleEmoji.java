import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class ReframeableSimpleEmoji extends SimpleEmoji {
   ReframeableSimpleEmoji(Rectangle2D r) {
      super(r);
   }

   public void setFrame(Rectangle2D r) {
      face.setFrame(r.getX() + r.getWidth()/2, r.getY() + r.getHeight()/2, r.getHeight(), r.getHeight());
      leftEye.setFrame(r.getX() + r.getWidth()/2, r.getY() + r.getHeight()/2, r.getHeight()/2, r.getHeight()/2);
      rightEye.setFrame(r.getX() + r.getWidth()/2 + leftEye.getWidth(), r.getY() + r.getHeight()/2, r.getHeight()/2, r.getHeight()/2);
   }
}
