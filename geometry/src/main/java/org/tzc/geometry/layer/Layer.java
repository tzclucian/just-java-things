package org.tzc.geometry.layer;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.tzc.geometry.polygonal.Polygon;
import org.tzc.geometry.polygonal.PolygonalPath;
import org.tzc.geometry.polygonal.SimplePolygon;
import org.tzc.geometry.polygonal.quadrilateral.Parallelogram;
import org.tzc.geometry.polygonal.quadrilateral.Quadrilateral;
import org.tzc.geometry.polygonal.quadrilateral.Rectangle;
import org.tzc.geometry.polygonal.quadrilateral.Square;
import org.tzc.geometry.polygonal.triangle.EquilateralTriangle;
import org.tzc.geometry.polygonal.triangle.IsoscelesTriangle;
import org.tzc.geometry.polygonal.triangle.RightTriangle;
import org.tzc.geometry.polygonal.triangle.Triangle;
import org.tzc.geometry.rounded.Circle;

/**
 * @author Lucian Tuca
 *         19/05/15
 *         java-training
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSubTypes
        ({
                @JsonSubTypes.Type(value = PolygonalPath.class, name = "PolygonalPath"),
                @JsonSubTypes.Type(value = Polygon.class, name = "Polygon"),
                @JsonSubTypes.Type(value = SimplePolygon.class, name = "SimplePolygon"),

                @JsonSubTypes.Type(value = EquilateralTriangle.class, name = "EquilateralTriangle"),
                @JsonSubTypes.Type(value = IsoscelesTriangle.class, name = "IsoscelesTriangle"),
                @JsonSubTypes.Type(value = RightTriangle.class, name = "RightTriangle"),
                @JsonSubTypes.Type(value = Triangle.class, name = "Triangle"),

                @JsonSubTypes.Type(value = Quadrilateral.class, name = "Quadrilateral"),
                @JsonSubTypes.Type(value = Parallelogram.class, name = "Parallelogram"),
                @JsonSubTypes.Type(value = Rectangle.class, name = "Rectangle"),
                @JsonSubTypes.Type(value = Square.class, name = "Square"),

                @JsonSubTypes.Type(value = Circle.class, name = "Circle")
        })
public interface Layer {
    void draw();
}
