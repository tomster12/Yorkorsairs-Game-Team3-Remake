package com.mygdx.utils;

import static org.junit.Assert.*;

import com.mygdx.GdxTestRunner;
import org.junit.Test;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import org.junit.*;
import com.mygdx.game.PirateGame;
import org.junit.runner.RunWith;

@RunWith(GdxTestRunner.class)
public class ConstantsTest {
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
    public void ConstantsInitTest() {
        Constants constants = new Constants();
        constants.INIT_CONSTANTS();

        assertEquals(constants.SCREEN_WIDTH, 1920);
        assertEquals(constants.SCREEN_HEIGHT, 1080);
        assertEquals(constants.ASPECT_RATIO, 1.0, 0.1);
        assertEquals(constants.VIEWPORT_HEIGHT, 800);
        assertEquals(constants.VIEWPORT_WIDTH, 800);
        assertEquals(constants.HALF_VIEWPORT_HEIGHT, 400);
        assertEquals(constants.HALF_VIEWPORT_WIDTH, 400);
        assertEquals(constants.DIMENSIONS, new Vector2(800, 800));
        assertEquals(constants.HALF_DIMENSIONS, new Vector2(400, 400));
        assertEquals(constants.VIEWPORT_TITLE, "Pirate Game");
        assertEquals(constants.BACKGROUND_COLOUR, new Vector3(0.0f, 0.0f, 0.0f));
        assertEquals(constants.PHYSICS_TIME_STEP, 1.0f / 60.0f, 0.1);
        assertEquals(constants.TILE_SIZE, 32, 0.1);
    }

    @Test
    public void ConstantsUpdateViewportTest() {
        Constants constants = new Constants();
        constants.INIT_CONSTANTS();
        constants.UPDATE_VIEWPORT(1920, 1200);

        assertEquals(constants.ASPECT_RATIO, 1.7777777910232544, 0.1);
        assertEquals(constants.VIEWPORT_HEIGHT, 1200);
        assertEquals(constants.VIEWPORT_WIDTH, 1920);
        assertEquals(constants.HALF_VIEWPORT_HEIGHT, 600);
        assertEquals(constants.HALF_VIEWPORT_WIDTH, 960);
        assertEquals(constants.DIMENSIONS, new Vector2(1920, 1200));
        assertEquals(constants.HALF_DIMENSIONS, new Vector2(960, 600));
    }
}
