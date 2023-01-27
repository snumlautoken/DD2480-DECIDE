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
    public static void calcLIC1(){}

    // TODO!
    public static void calcLIC2(){}

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

    // TODO!
    public static void calcLIC7(){}

    public static void calcLIC8(){
        if (Input.NUMPOINTS < 5) {
            cmv[8] = false;
            return;
        }
        // Calculate minimum radius for enclosing triangle
        for (int i = 0; i < Input.NUMPOINTS-2-Input.Parameters.APTS-Input.Parameters.BPTS; i++) {
            double rad;
            double a = Input.Coordinates[i].distance(Input.Coordinates[i+Input.Parameters.APTS+1]);
            double b = Input.Coordinates[i].distance(Input.Coordinates[i+Input.Parameters.APTS+Input.Parameters.BPTS+2]);
            double c = Input.Coordinates[i+Input.Parameters.APTS+Input.Parameters.BPTS+2].distance(Input.Coordinates[i+Input.Parameters.APTS+1]);
            double sides[] = new double[3];
            sides[0] = a;
            sides[1] = b;
            sides[2] = c;
            Arrays.sort(sides);
            // Obtuse triangle => longest side is diameter of smallest possible circle
            if (sides[2]*sides[2] > sides[1]*sides[1] + sides[0]*sides[0]) {
                rad = sides[2]/2;
            }
            // Otherwise => circumcircle is smallest possible circle
            else {
                rad = (a*b*c)/Math.sqrt((a+b+c)*(b+c-a)*(c+a-b)*(a+b-c));
            }
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

    // TODO!
    public static void calcLIC13(){}

    // TODO!
    public static void calcLIC14(){}

}