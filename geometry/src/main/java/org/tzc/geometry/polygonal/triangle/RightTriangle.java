package org.tzc.geometry.polygonal.triangle;

import org.tzc.geometry.LineSegment;
import org.tzc.geometry.Point;
import org.tzc.geometry.Validable;
import org.tzc.geometry.exceptions.GeometryException;

import java.util.List;

public class RightTriangle extends Triangle implements Validable {
    public RightTriangle(Point a, Point b, Point c) throws GeometryException {
        super(a, b, c);
    }

    private Point rightAngle;

    @Override
    public boolean isValid() {
        if (!super.isValid()) return false;

        List<LineSegment> segments = getSegments();


        double ab = segments.get(0).getLength();
        double bc = segments.get(1).getLength();
        double ca = segments.get(2).getLength();

        double max = Math.max(Math.max(ab, bc), ca);
        double hypotenuse = Math.pow(max, 2);

        if (Math.abs(hypotenuse - (Math.pow(ab, 2) + Math.pow(bc, 2))) < 0.0001) {
            rightAngle = getPoints().get(1);
            return true;
        }

        if (Math.abs(hypotenuse - (Math.pow(ab, 2) + Math.pow(ca, 2))) < 0.0001) {
            rightAngle = getPoints().get(0);
            return true;
        }

        if (Math.abs(hypotenuse - (Math.pow(ca, 2) + Math.pow(bc, 2))) < 0.0001) {
            rightAngle = getPoints().get(2);
            return true;
        }

        return false;
    }

    public Point getRightAngle() throws GeometryException {
        if (rightAngle == null) {
            if (!isValid()) {
                throw new GeometryException("Not a right triangle");
            }
        }
        return rightAngle;
    }
}