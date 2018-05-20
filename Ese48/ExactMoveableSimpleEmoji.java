import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class ExactMoveableSimpleEmoji extends MoveableSimpleEmoji {
   double n = 0;
   ExactMoveableSimpleEmoji(Rectangle2D r) {
      super(r);
   }

   public void setDirection(Point2D p) {
      n = Math.sqrt(Math.pow(p.getX(), 2) + Math.pow(p.getY(), 2));
      if (n != 0 && n != 1) {
         direction = new Point2D.Double((p.getX()/n), (p.getY()/n));
      } else if (n == 0) {
         direction = p;
      }
   }
}
