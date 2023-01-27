import Group2.CMV;
import Group2.Input;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    @BeforeAll
    public static void setUpCoordinates() {
        for (int i = 0; i < 100; i++) {
            Input.Coordinates[i] = new Point();
        }
    }

    /**
     * Tests that all input is set- and gettable.
     */
    @Test
    public void TestInput() {
        Input.Coordinates[0].setLocation(5, 6);
        assertEquals(5, Input.Coordinates[0].getX(), "Error: Coordinates input not set/get correctly");
        Input.LCM[0][0] = Input.Connector.ANDD;
        assertEquals(Input.Connector.ANDD, Input.LCM[0][0], "Error: LCM input not set/get correctly");
        Input.PUV[0] = false;
        Input.PUV[1] = true;
        assertEquals(Input.PUV[0], false, "Error: PUV input not set/get correctly");
        assertEquals(Input.PUV[1], true, "Error: PUV input not set/get correctly");


    }

    @Test
    public void testCMVDoubleCompare() {
        assertEquals(CMV.Comptype.GT, CMV.doubleCompare(5, 3.5), "Error: CMV doubleCompare 5 expected to be GT 3.5");
        assertEquals(CMV.Comptype.GT, CMV.doubleCompare(-1, -7.2), "Error: CMV doubleCompare -1 expected to be GT -7.2");
        assertEquals(CMV.Comptype.LT, CMV.doubleCompare(32, 33), "Error: CMV doubleCompare 32 expected to be LT 33");
        assertEquals(CMV.Comptype.LT, CMV.doubleCompare(-1, -0.99), "Error: CMV doubleCompare -1 expected to be LT -0.99");
        assertEquals(CMV.Comptype.EQ, CMV.doubleCompare(-1.00, -1.00), "Error: CMV doubleCompare -1.00 expected to be EQ -1.00");
        assertEquals(CMV.Comptype.EQ, CMV.doubleCompare(5.000000999, 5), "Error: CMV doubleCompare 5.000000999 expected to be EQ 5");
    }
}
