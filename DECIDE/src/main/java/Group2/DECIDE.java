package Group2;

public class DECIDE {
    public static boolean launch;
    public static void decide() {
        CMV.calculate();
        boolean[][] PUM = new boolean[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = i; j < 15; j++) {
                PUM[i][j] = switch (Input.LCM[i][j]) {
                    case ANDD:
                        yield CMV.cmv[i] && CMV.cmv[j];
                    case ORR:
                        yield CMV.cmv[i] || CMV.cmv[j];
                    case NOTUSED:
                        yield true;
                    default:
                        yield true;
                };
                PUM[j][i] = PUM[i][j];
            }
        }

    }
}
