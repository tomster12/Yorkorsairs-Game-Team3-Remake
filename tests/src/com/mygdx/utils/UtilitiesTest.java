package com.mygdx.utils;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.*;
import static org.mockito.Mockito.*;
import org.mockito.Mock;

import java.util.ArrayList;

public class UtilitiesTest {

    @Test
    public void UtilitiesAngleToVectorTest() {
        Utilities utils = new Utilities();
        Vector2 out = new Vector2(20, 32);
        Vector2 out2 = new Vector2(-(float) Math.sin(50), (float) Math.cos(50));
        Vector2 out3 = new Vector2(-(float) Math.sin(60), (float) Math.cos(60));

        assertEquals(utils.angleToVector(out, 50), out2);
        assertEquals(utils.angleToVector(out, 60), out3);
    }

    @Test
    public void UtilitiesRoundTest() {
        Utilities utils = new Utilities();
        Vector2 a = new Vector2(20, 32);
        Vector2 b = new Vector2(30, 40);

        assertEquals(utils.round(a), a);
        assertEquals(utils.round(b), b);
    }

    @Test
    public void UtilitiesTilesToDistanceTest() {
        Utilities utils = new Utilities();
        Constants Constants = new Constants();
        Constants.INIT_CONSTANTS();

        assertEquals(utils.tilesToDistance(2), 64, 0.1);
        assertEquals(utils.tilesToDistance(3), 96, 0.1 );

        Vector2 v = new Vector2(30, 40);
        assertEquals(utils.tilesToDistance(v), new Vector2(960, 1280));
    }

    @Test
    public void UtilitiesDistanceToTilesTest() {
        Utilities utils = new Utilities();
        Constants Constants = new Constants();
        Constants.INIT_CONSTANTS();

        assertEquals(utils.distanceToTiles(64), 2);
        assertEquals(utils.distanceToTiles(96), 3);
    }

    @Test
    public void UtilitiesCheckProximityTest() {
        Utilities utils = new Utilities();
        Vector2 a = new Vector2(60, 35);
        Vector2 b = new Vector2(10, 70);
        assertEquals(utils.checkProximity(a, b,20), false);
        assertEquals(utils.checkProximity(a, b,2), false);
    }

    @Test
    public void UtilitiesAngleBetweenTest() {
        Utilities utils = new Utilities();
        Vector2 v = new Vector2(70, 31);
        Vector2 w = new Vector2(76, 52);
        float angle = MathUtils.atan2(w.y * v.x - w.x * v.y, w.x * v.x + w.y * v.y);

        assertEquals(utils.angleBetween(v, w), angle, 0.01);
    }


    @Test
    public void UtilitiesScaleTest() {
        Utilities utils = new Utilities();
        float x = 20;
        float min0 = 54;
        float min1 = 88;
        float max0 = 22;
        float max1 = 53;
        float scale1 = (max1 - min1) * ((x - min0 * x) / (max0 * x - min0 * x)) + min1;

        assertEquals(utils.scale(x, min0, max0, min1, max1), scale1, 0.01);

        Vector2 a = new Vector2(70, 31);
        Vector2 b = new Vector2(76, 52);

        float scale2 = (b.y - b.x) * ((x - a.x * x) / (a.y * x - a.x * x)) + b.x;
        assertEquals(utils.scale(x, a, b), scale2, 0.01);
    }

    @Test
    public void UtilitiesRandomPosTest() {
        Utilities utils = new Utilities();
        Vector2 a = new Vector2(70, 31);

        assertNotEquals(utils.randomPos(20, 30), a);
    }

    @Test
    public void UtilitiesRandomChoiceTest() {
        Utilities utils = new Utilities();
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(20);
        array.add(30);

        int randomInt = utils.randomChoice(array, 10);
        Boolean exists = utils.contains(array, randomInt);

        assertTrue(exists);
    }

    @Test
    public void UtilitiesFloorTest() {
        Utilities utils = new Utilities();
        Vector2 a = new Vector2(70, 31);

        assertEquals(utils.floor(a), new Vector2(70, 31));
    }

    @Test
    public void UtilitiesContainsTest() {
        Utilities utils = new Utilities();
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(20);
        array.add(30);

        assertEquals(utils.contains(array, 20), true);
        assertEquals(utils.contains(array, 50), false);
    }
}
