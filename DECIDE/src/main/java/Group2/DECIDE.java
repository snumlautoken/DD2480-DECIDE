package Group2;

/**
 * Main class for decision problem in Launch Interceptor Program.
 * Contains launch boolean, decide function and a helper function for checking final unlocking vector (FUV).
 */
public class DECIDE {
    /**
     * Boolean value representing decision made by program. True=launch interceptor, False=Ignore
     */
    public static boolean launch;

    /**
     * Decide function. Includes call to CMV LIC calculation, calculates PUM from LCM and CMV. 
     * Then calculates FUV from PUM and PUV according to spec. 
     * If all values in FUV is true, launch is set to true and function prints "Yes" to console. Otherwise "No" is outputed.
     */
    public static void decide() {
        CMV.calculate();
        boolean[][] PUM = new boolean[15][15];
        boolean[] FUV = new boolean[15];
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
            FUV[i] = !Input.PUV[i] || allIsTrue(PUM[i]);
        }

        launch = allIsTrue(FUV);

        String yN = launch ? "Yes" : "No";
        System.out.println(yN);
    }
    
    /**
     * Helper function to check if all boolean values in array is true.
     * @param array
     * @return True or false
     */
    private static boolean allIsTrue(boolean[] array) {
        for(boolean b : array) if(!b) return false;
        return true;
    }
}
