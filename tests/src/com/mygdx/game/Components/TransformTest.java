package com.mygdx.game.Components;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.mygdx.GdxTestRunner;
import org.junit.Test;
import org.mockito.Mock;
import com.badlogic.gdx.math.Vector2;

import org.junit.*;
import com.mygdx.game.PirateGame;
import org.junit.runner.RunWith;

@RunWith(GdxTestRunner.class)
public class TransformTest {
    private static PirateGame pg;


    @BeforeClass
    public static void setup() {
        pg = new PirateGame();
        PirateGame.loadStatic();
    }

    @AfterClass
    public static void cleanup() {
        pg.fullReset();
    }

    @Test
    public void TransformSetPosTest () {
        Transform transT = new Transform();
        Vector2 v1 = new Vector2(40, -40);
        transT.setPosition(v1);
        assertEquals(v1, transT.getPosition());
    }

    @Test
    public void TransformSetScaleTest () {
        Transform transT = new Transform();
        Vector2 v1 = new Vector2(2, -2);
        transT.setScale(v1);
        assertEquals(v1, transT.getScale());

        Vector2 v2 = new Vector2(3, -3);
        transT.setScale(3, -3);
        assertEquals(v2, transT.getScale());
    }

    @Test
    public void TransformSetRotateTest () {
        Transform transT = new Transform();
        transT.setRotation(1);
        assertEquals(1, transT.getRotation(), 0.1);
    }

    @Test
    public void TransformSetOrientationTest () {
        Transform transT = new Transform();
        transT.setOrientation(0);
        assertEquals(0, transT.getOrientation(), 0.1);
    }

    @Test
    public void TransformVecToAngleTest () {
        Transform transT = new Transform();
        Vector2 v1 = new Vector2(2, -2);
        assertEquals(-2.3561, transT.vectorToAngle(v1),0.001);
    }

    @Test
    public void TransformAngleToVecTest () {
        Transform transT = new Transform();
        Vector2 v1 = new Vector2(2, -2);
        assertEquals(-0.9092, transT.angleToVector(v1, 2).x, 0.001);
        assertEquals(-0.4161, transT.angleToVector(v1, 2).y, 0.001);
    }

}