package Group2;

import java.awt.*;
import java.util.Arrays;


public class CMV{

    /*
     * Comparison results
     * GT = Greater Than
     * LT = Lesser Than
     * EQ = Equals
     */
    public enum Comptype {
        GT,
        LT,
        EQ;
    }
    public static boolean[] cmv = new boolean[15];

    /**
     * Compare double values and return result as Comptype.
     * @param a double to compare
     * @param b double to compare
     * @return Comptype EQ if difference a - b < 0.000001, LT if a < b, GT if a > b
     * </>
     */
    public static Comptype doubleCompare(double a, double b) {
        if (Math.abs(a - b) < 0.000001)
            return Comptype.EQ;
        if (a < b)
            return Comptype.LT;

        return Comptype.GT;
    }
    // Calls all LIC calculcations
    public static void calculate(){
        calcLIC0();
        calcLIC1();
        calcLIC2();
        calcLIC3();
        calcLIC4();
        calcLIC5();
        calcLIC6();
        calcLIC7();
        calcLIC8();
        calcLIC9();
        calcLIC10();
        calcLIC11();
        calcLIC12();
        calcLIC13();
        calcLIC14();
    }

    // TODO!
    public static void calcLIC0(){}

    // TODO!
    public static void calcLIC1(){
        cmv[1] = false;
        if (Input.NUMPOINTS < 3 || doubleCompare(Input.Parameters.RADIUS1, 0) == Comptype.LT)
            return;

        for (int i = 0; i < Input.NUMPOINTS - 2; i++) {
            double minimumCircleRadius = minRadiusEnclose(Input.Coordinates[i], Input.Coordinates[i + 1], Input.Coordinates[i + 2]);
            if (doubleCompare(minimumCircleRadius, Input.Parameters.RADIUS1) != Comptype.GT) {
                cmv[1] = true;
                return;
            }
        }
    }

    // TODO!
    public static void calcLIC2(){
        cmv[2] = false;

        if(Input.NUMPOINTS < 3){
            return;
        }

        for (int i = 0; i < Input.NUMPOINTS-2; i++) {
            Point p1 = Input.Coordinates[i];
            Point p2 = Input.Coordinates[i+1];
            Point p3 = Input.Coordinates[i+2];


            // If either the first point or the last point (or both) coincides with the vertex, the angle is undefined
            if((doubleCompare(p1.x, p2.x)==Comptype.EQ&&doubleCompare(p1.y, p2.y)==Comptype.EQ)
             ||(doubleCompare(p2.x, p3.x)==Comptype.EQ&&doubleCompare(p2.y, p3.y)==Comptype.EQ)){
                continue;
            }
            
            double angle = Math.acos((Math.pow(p2.distance(p1), 2)+Math.pow(p2.distance(p3), 2)-Math.pow(p1.distance(p3), 2))/
            (2*p2.distance(p1)*p2.distance(p3)));
            
            if(doubleCompare(angle, Math.PI-Input.Parameters.EPSILON)==Comptype.LT || doubleCompare(angle, Math.PI+Input.Parameters.EPSILON)==Comptype.GT){
                cmv[2] = true;
                break;
            }
        }


    }

    public static void calcLIC3(){
        if (Input.NUMPOINTS < 3) {
            cmv[3] = false;
            return;
        }
        for (int i = 0; i < Input.NUMPOINTS-2; i++) {
            Point p1 = Input.Coordinates[i];
            Point p2 = Input.Coordinates[i+1];
            Point p3 = Input.Coordinates[i+2];
            Double area = Math.abs(p1.getX()*p2.getY()+p2.getX()*p3.getY() + p3.getX()*p1.getY() - p1.getY()*p2.getX() - p2.getY()*p3.getX() - p3.getY()*p1.getX())/2;
            if (doubleCompare(area, Input.Parameters.AREA1) == Comptype.GT) {
                cmv[3] = true;
                return;
            }
        }
        cmv[3] = false;
    }

    // TODO!
    public static void calcLIC4(){}

    // TODO!
    public static void calcLIC5(){}

    // TODO!
    public static void calcLIC6(){}

    /**
     * There exists at least one set of two data points separated by exactly KPTS consecutive intervening points 
     * that are a distance greater than the length, LENGTH1, apart. 
     * The condition is not met when NUMPOINTS < 3
     */
    public static void calcLIC7(){
        cmv[7] = false;

        if(Input.NUMPOINTS < 3) return;

        if(Input.Parameters.KPTS < 1 || Input.Parameters.KPTS > (Input.NUMPOINTS - 2)) return;
        
        for (int i = 0; i < Input.NUMPOINTS-Input.Parameters.KPTS-1; i++) {
            Point p1 = Input.Coordinates[i];
            Point p2 = Input.Coordinates[i+Input.Parameters.KPTS+1]; // Point separated by KPTS points

            if(doubleCompare(p1.distance(p2), Input.Parameters.LENGTH1) == Comptype.GT){
                cmv[7] = true;
                break;
            }
        }

    }

    public static void calcLIC8(){
        if (Input.NUMPOINTS < 5) {
            cmv[8] = false;
            return;
        }
        // Calculate minimum radius for enclosing triangle
        for (int i = 0; i < Input.NUMPOINTS-2-Input.Parameters.APTS-Input.Parameters.BPTS; i++) {
            double rad = minRadiusEnclose(Input.Coordinates[i], Input.Coordinates[i+Input.Parameters.APTS+1], Input.Coordinates[i+Input.Parameters.APTS+Input.Parameters.BPTS+2]);
            if (doubleCompare(rad, Input.Parameters.RADIUS1) == Comptype.GT) {
                cmv[8] = true;
                return;
            }
        }

        cmv[8] = false;
    }

    // TODO!
    public static void calcLIC9(){}

    // TODO!
    public static void calcLIC10(){}

    // TODO!
    public static void calcLIC11(){}

    // TODO!
    public static void calcLIC12(){}

    public static void calcLIC13(){
        cmv[13] = false;
        if (Input.NUMPOINTS < 5) {
            return;
        }
        boolean rad1 = false;
        boolean rad2 = false;
        // Calculate minimum radius for enclosing triangle
        for (int i = 0; i < Input.NUMPOINTS-2-Input.Parameters.APTS-Input.Parameters.BPTS; i++) {
            double rad = minRadiusEnclose(Input.Coordinates[i], Input.Coordinates[i+Input.Parameters.APTS+1], Input.Coordinates[i+Input.Parameters.APTS+Input.Parameters.BPTS+2]);
            if (doubleCompare(rad, Input.Parameters.RADIUS1) == Comptype.GT) {
                rad1 = true;
            }
            if (doubleCompare(rad, Input.Parameters.RADIUS2) != Comptype.GT) {
                rad2 = true;
            }
        }

        cmv[13] = rad1 && rad2;

    }

    // TODO!
    public static void calcLIC14(){}

    private static double minRadiusEnclose(Point p1, Point p2, Point p3) {
        double a = p1.distance(p2);
        double b = p1.distance(p3);
        double c = p2.distance(p3);
        double sides[] = new double[3];
        sides[0] = a;
        sides[1] = b;
        sides[2] = c;
        
        if (a == 0 && b == 0 && c == 0)
            return 0;

        Arrays.sort(sides);
        // Obtuse triangle => longest side is diameter of smallest possible circle
        if (sides[2]*sides[2] > sides[1]*sides[1] + sides[0]*sides[0]) {
            return sides[2]/2;
        }
        // Otherwise => circumcircle is smallest possible circle
        else {
            return (a*b*c)/Math.sqrt((a+b+c)*(b+c-a)*(c+a-b)*(a+b-c));
        }

    }

}