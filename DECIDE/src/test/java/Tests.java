import Group2.CMV;
import Group2.DECIDE;
import Group2.Input;
import Group2.Input.Connector;

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

    // Add more tests when more LICS are available
    @Test
    public void TestDecide() {
        for (int i = 0; i < 15; i++) {
            for (int j = i; j < 15; j++) {
                Input.LCM[i][j] = Connector.NOTUSED;
                Input.LCM[j][i] = Input.LCM[i][j];
            }
            Input.PUV[i] = false;
        }

        Input.LCM[3][8] = Connector.ORR;
        Input.LCM[8][3] = Connector.ORR;
        Input.PUV[3] = true;
        Input.PUV[8] = true;

        Input.Coordinates[0].setLocation(5, 6);
        Input.Coordinates[1].setLocation(1, 1);
        Input.Coordinates[2].setLocation(100, 100);
        Input.NUMPOINTS = 3;
        Input.Parameters.AREA1 = 1;
        Input.Parameters.RADIUS1 = 1;
        Input.Parameters.EPSILON = 0.0;
        DECIDE.decide();
        assertTrue(DECIDE.launch, "Error: decide gives false when true");
        Input.LCM[3][8] = Connector.ANDD;
        Input.LCM[8][3] = Connector.ANDD;
        DECIDE.decide();
        assertFalse(DECIDE.launch, "Error: decide gives true when false");
    }

    @Test
    public void TestLIC2() {
        Input.Coordinates[0].setLocation(0, 0);
        Input.Coordinates[1].setLocation(0, 0);
        Input.Coordinates[2].setLocation(1, 0);
        Input.NUMPOINTS = 3;
        Input.Parameters.EPSILON = 0.0;

        CMV.calcLIC2();
        assertTrue(!CMV.cmv[2], "Error! LIC2 should be false since points coincides");

        Input.Coordinates[3].setLocation(0, 0.5);
        Input.NUMPOINTS = 4;
        CMV.calcLIC2();
        assertTrue(CMV.cmv[2], "Error! LIC2 should be true since there is an angle less than PI");

        Input.Coordinates[3].setLocation(2, 0);
        Input.Parameters.EPSILON = 0.1;
        CMV.calcLIC2();
        assertTrue(!CMV.cmv[2], "Error! LIC2 should be false since the angle is PI and there is an epsilon");

        Input.Coordinates[3].setLocation(2, 0.5);
        Input.Parameters.EPSILON = 0.1;
        CMV.calcLIC2();
        assertTrue(CMV.cmv[2], "Error! LIC2 should be true since the angle is slightly less than PI");
    }

    @Test
    public void TestLIC3() {
        Input.Coordinates[0].setLocation(5, 6);
        Input.Coordinates[1].setLocation(1, 1);
        Input.Coordinates[2].setLocation(100, 100);
        Input.NUMPOINTS = 3;
        Input.Parameters.AREA1 = 1;
        CMV.calcLIC3();
        assertTrue(CMV.cmv[3], "Error: LIC3 gives false when true");
        Input.Coordinates[0].setLocation(1, 1);
        Input.Coordinates[1].setLocation(1, 1);
        Input.Coordinates[2].setLocation(1, 1);
        Input.Coordinates[3].setLocation(1, 1);
        Input.Coordinates[4].setLocation(5, 6);
        Input.Coordinates[5].setLocation(1, 1);
        Input.Coordinates[6].setLocation(100, 100);
        Input.NUMPOINTS = 7;
        Input.Parameters.AREA1 = 10000000;
        CMV.calcLIC3();
        assertFalse(CMV.cmv[3], "Error: LIC3 true when false");

        Input.Coordinates[0].setLocation(1, 1);
        Input.Coordinates[1].setLocation(1, 1);
        Input.Coordinates[2].setLocation(1, 1);
        Input.Coordinates[3].setLocation(1, 1);
        Input.Coordinates[4].setLocation(5, 6);
        Input.Coordinates[5].setLocation(1, 1);
        Input.Coordinates[6].setLocation(100, 100);
        Input.NUMPOINTS = 7;
        Input.Parameters.AREA1 = 1;
        CMV.calcLIC3();
        assertTrue(CMV.cmv[3], "Error: LIC3 false when true, for numpoints > 3");

        Input.NUMPOINTS = 2;
        Input.Parameters.AREA1 = 1;
        CMV.calcLIC3();
        assertFalse(CMV.cmv[3], "Error: LIC3 true when false, for numpoints < 3");

    }

    @Test
    public void TestLIC8() {
        // Obtuse triangle
        Input.Parameters.APTS = 1;
        Input.Parameters.BPTS = 1;
        Input.Coordinates[0].setLocation(0, 0);
        Input.Coordinates[1].setLocation(-1, -1);
        Input.Coordinates[2].setLocation(10, 0);
        Input.Coordinates[3].setLocation(-1, -1);
        Input.Coordinates[4].setLocation(5, 1);
        Input.NUMPOINTS = 5;
        Input.Parameters.RADIUS1 = 5;
        CMV.calcLIC8();
        assertFalse(CMV.cmv[8], "Error: Obtuse LIC8 gives true when false");
        Input.Parameters.RADIUS1 = 4;
        CMV.calcLIC8();
        assertTrue(CMV.cmv[8], "Error: Obtuse LIC8 gives false when true");

        // Right triangle
        Input.Parameters.APTS = 1;
        Input.Parameters.BPTS = 1;
        Input.Coordinates[0].setLocation(0, 0);
        Input.Coordinates[1].setLocation(-1, -1);
        Input.Coordinates[2].setLocation(4, 0);
        Input.Coordinates[3].setLocation(-1, -1);
        Input.Coordinates[4].setLocation(0, 3);
        Input.NUMPOINTS = 5;
        Input.Parameters.RADIUS1 = 2.5;
        CMV.calcLIC8();
        assertFalse(CMV.cmv[8], "Error: Right LIC8 gives true when false");
        Input.Parameters.RADIUS1 = 2.4;
        CMV.calcLIC8();
        assertTrue(CMV.cmv[8], "Error: Right LIC8 gives false when true");

        // Acute triangle
        Input.Parameters.APTS = 1;
        Input.Parameters.BPTS = 1;
        Input.Coordinates[0].setLocation(0, 0);
        Input.Coordinates[1].setLocation(-1, -1);
        Input.Coordinates[2].setLocation(5, 0);
        Input.Coordinates[3].setLocation(-1, -1);
        Input.Coordinates[4].setLocation(2.5, 4);
        Input.NUMPOINTS = 5;
        Input.Parameters.RADIUS1 = 3;
        CMV.calcLIC8();
        assertFalse(CMV.cmv[8], "Error: Acute LIC8 gives true when false");
        Input.Parameters.RADIUS1 = 2;
        CMV.calcLIC8();
        assertTrue(CMV.cmv[8], "Error: Acute LIC8 gives false when true");
        Input.Coordinates[1].setLocation(0, 0);
        Input.Coordinates[3].setLocation(100, 0);
        Input.Coordinates[5].setLocation(50, -50);
        Input.NUMPOINTS = 6;
        Input.Parameters.RADIUS1 = 4;
        assertTrue(CMV.cmv[8], "Error: Acute LIC8 gives false when true");
    }

}
