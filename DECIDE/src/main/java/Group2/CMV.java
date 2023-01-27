package Group2;

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

    // TODO!
    public static void calcLIC3(){}

    // TODO!
    public static void calcLIC4(){}

    // TODO!
    public static void calcLIC5(){}

    // TODO!
    public static void calcLIC6(){}

    // TODO!
    public static void calcLIC7(){}

    // TODO!
    public static void calcLIC8(){}

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