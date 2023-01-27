package Group2;

import java.awt.*;

public class Input {
    public enum Connector {
        ANDD, ORR, NOTUSED
    }
    public static int NUMPOINTS;
    public static Connector[][] LCM = new Connector[15][15];
    public static boolean[] PUV = new boolean[15];
    public static Point[] Coordinates = new Point[100];

    public static class Parameters {
        public static double LENGTH1;
        public static double RADIUS1;
        public static double EPSILON;
        public static double AREA1;
        public static int QPTS;
        public static int QUADS;
        public static double DIST;
        public static int NPTS;
        public static int KPTS;
        public static int APTS;
        public static int BPTS;
        public static int CPTS;
        public static int DPTS;
        public static int EPTS;
        public static int FPTS;
        public static int GPTS;
        public static double LENGTH2;
        public static double RADIUS2;
        public static double AREA2;
    }
}
