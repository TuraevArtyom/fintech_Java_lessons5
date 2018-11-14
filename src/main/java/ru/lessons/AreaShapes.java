package ru.lessons;


public class AreaShapes {
    public static double areaTriangle(double sideAB, double sideBC, double sideCA){
        double semiperimeter = (sideAB + sideBC + sideCA) / 2;
        return Math.sqrt(semiperimeter * (semiperimeter - sideAB) * (semiperimeter - sideBC) * (semiperimeter - sideCA));
    }

    public static double areaSquare(double side){
        return side*side;
    }

    public static double areaCircle(double radius){
        return Math.PI * (radius * radius);
    }
    public static void main(String[] arg){
        AreaShapes areaShapes = new AreaShapes();
        System.out.println(areaCircle(1));
    }
}

