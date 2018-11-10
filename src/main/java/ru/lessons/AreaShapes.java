package ru.lessons;

public class AreaShapes {
    public static double areaTringle(double sideA, double sideB, double sideC){
        double semiperimeter = (sideA + sideB + sideC) / 2;
        return Math.sqrt(semiperimeter * (semiperimeter - sideA) * (semiperimeter - sideB) * (semiperimeter - sideC));
    }

    public static double areaSquare(double side){
        return side*side;
    }

    public static double areaCircle(double radius){
        return Math.PI * (radius * radius);
    }

}
