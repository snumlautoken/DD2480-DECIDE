package Group2;

import java.awt.*;

public class Input {
    public enum Connector {
        ANDD, ORR, NOTUSED
    }
    public int NUMPOINTS;
    public Connector[][] LCM = new Connector[15][15];
    public boolean[] PUV = new boolean[15];

    public static Point[] Coordinates = new Point[100];
}
