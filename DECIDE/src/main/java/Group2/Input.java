package Group2;

public class Input {
    public enum Connector {
        ANDD, ORR, NOTUSED
    }
    public static int NUMPOINTS;
    public static Connector[][] LCM = new Connector[15][15];
    public boolean[] PUV = new boolean[15];
}
