import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class MoveableSimpleEmoji extends ReframeableSimpleEmoji {
   protected Point2D direction;
   protected float speed;
   protected Rectangle2D r;

   MoveableSimpleEmoji(Rectangle2D r) {
      super(r);
      this.r = r;

      direction = new Point2D.Double(1, 1);
      speed = 5;
   }

   public void move() {
      setFrame((r = new Rectangle2D.Double(r.getX() + (direction.getX()*speed), r.getY() + (direction.getY()*speed), r.getWidth(), r.getHeight())));
   }

   public Point2D getDirection() {
      return direction;
   }

   public void setDirection(Point2D p) {
      direction = p;
   }

   public float getSpeed() {
      return speed;
   }

   public void setSpeed(float s) {
      speed = s;
   }
}
