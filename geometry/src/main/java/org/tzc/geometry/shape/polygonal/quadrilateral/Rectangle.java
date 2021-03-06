package org.tzc.geometry.shape.polygonal.quadrilateral;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.tzc.geometry.shape.LineSegment;
import org.tzc.geometry.shape.Point;
import org.tzc.geometry.shape.Validable;

@Entity
@Table(name = "RECTANGLE")
public class Rectangle extends Parallelogram implements Validable {

    public Rectangle() {
    }

    public Rectangle(Point a, Point b, Point c, Point d) {
        super(a, b, c, d);
    }

    @Override
    public boolean check() {
        if (!super.check()) {
            return false;
        }

        LineSegment ab = getSegments().get(0);
        LineSegment bc = getSegments().get(1);

        double angle = ab.calculateAngle(bc);
        double angleDegrees = Math.toDegrees(angle);

        return Math.abs(angleDegrees - 90) < 0.0001;
    }
}
