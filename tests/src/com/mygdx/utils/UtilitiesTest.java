//package com.mygdx.utils;
//import com.badlogic.gdx.math.MathUtils;
//import com.badlogic.gdx.math.Vector2;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import static org.junit.jupiter.api.Assertions.*;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//
//@ExtendWith(MockitoExtension.class)
//public class UtilitiesTest {
//
//    Utilities utils;
//
//    @BeforeEach
//    void setUp () {
//        utils = new Utilities();
//    }
//
//    @Test
//    void UtilitiesAngleToVectorTest() {
//        Vector2 out = new Vector2(20, 32);
//        Vector2 out2 = new Vector2(-(float) Math.sin(50), (float) Math.cos(50));
//        Vector2 out3 = new Vector2(-(float) Math.sin(60), (float) Math.cos(60));
//
//        assertEquals(utils.angleToVector(out, 50), out2);
//        assertEquals(utils.angleToVector(out, 60), out3);
//    }
//
//    @Test
//    void UtilitiesRoundTest() {
//        Vector2 a = new Vector2(20, 32);
//        Vector2 b = new Vector2(30, 40);
//
//        assertEquals(utils.round(a), a);
//        assertEquals(utils.round(b), b);
//    }
//
//    @Test
//    void UtilitiesTilesToDistanceTest() {
//        Constants constants = new Constants();
//        constants.INIT_CONSTANTS();
//
//        assertEquals(utils.tilesToDistance(2), 64);
//        assertEquals(utils.tilesToDistance(3), 96);
//
//        Vector2 v = new Vector2(30, 40);
//        assertEquals(utils.tilesToDistance(v), new Vector2(960, 1280));
//    }
//
//    @Test
//    void UtilitiesDistanceToTilesTest() {
//        Constants constants = new Constants();
//        constants.INIT_CONSTANTS();
//
//        assertEquals(utils.distanceToTiles(64), 2);
//        assertEquals(utils.distanceToTiles(96), 3);
//    }
//
//    @Test
//    void UtilitiesCheckProximityTest() {
//        Vector2 a = new Vector2(60, 35);
//        Vector2 b = new Vector2(10, 70);
//        assertEquals(utils.checkProximity(a, b,20), false);
//        assertEquals(utils.checkProximity(a, b,2), false);
//    }
//
//    @Test
//    void UtilitiesAngleBetweenTest() {
//        Vector2 v = new Vector2(70, 31);
//        Vector2 w = new Vector2(76, 52);
//        float angle = MathUtils.atan2(w.y * v.x - w.x * v.y, w.x * v.x + w.y * v.y);
//
//        assertEquals(utils.angleBetween(v, w), angle);
//    }
//
//
//    @Test
//    void UtilitiesScaleTest() {
//        float x = 20;
//        float min0 = 54;
//        float min1 = 88;
//        float max0 = 22;
//        float max1 = 53;
//        float scale1 = (max1 - min1) * ((x - min0 * x) / (max0 * x - min0 * x)) + min1;
//
//        assertEquals(utils.scale(x, min0, max0, min1, max1), scale1);
//
//        Vector2 a = new Vector2(70, 31);
//        Vector2 b = new Vector2(76, 52);
//
//        float scale2 = (b.y - b.x) * ((x - a.x * x) / (a.y * x - a.x * x)) + b.x;
//        assertEquals(utils.scale(x, a, b), scale2);
//    }
//
//    @Test
//    void UtilitiesRandomPosTest() {
//        Vector2 a = new Vector2(70, 31);
//
//        assertNotEquals(utils.randomPos(20, 30), a);
//    }
//
//    @Test
//    void UtilitiesRandomChoiceTest() {
//        ArrayList<Integer> array = new ArrayList<Integer>();
//        array.add(20);
//        array.add(30);
//
//        int randomInt = utils.randomChoice(array, 10);
//        Boolean exists = utils.contains(array, randomInt);
//
//        assertTrue(exists);
//    }
//
//    @Test
//    void UtilitiesFloorTest() {
//        Vector2 a = new Vector2(70, 31);
//
//        assertEquals(utils.floor(a), new Vector2(70, 31));
//    }
//
//    @Test
//    void UtilitiesContainsTest() {
//        ArrayList<Integer> array = new ArrayList<Integer>();
//        array.add(20);
//        array.add(30);
//
//        assertEquals(utils.contains(array, 20), true);
//        assertEquals(utils.contains(array, 50), false);
//    }
//}
