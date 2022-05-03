package com.mygdx.utils;

import static org.junit.Assert.*;

import com.mygdx.GdxTestRunner;
import com.mygdx.game.PirateGame;
import com.mygdx.utils.Constants;
import org.junit.Test;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import org.junit.*;
import org.junit.runner.RunWith;

@RunWith(GdxTestRunner.class)
public class ConstantsTest {

    // declare variables
    private static PirateGame pg;

    @BeforeClass
    public static void setup() {
        pg = new PirateGame();
        PirateGame.loadStatic();
        Constants.INIT_CONSTANTS();
    }

    @AfterClass
    public static void cleanup() {
        pg.fullReset();
    }

    @Test
    public void ConstantsInitTest() {
        assertEquals(Constants.VIEWPORT_HEIGHT, 800);
        assertEquals(Constants.VIEWPORT_WIDTH, 800);
        assertEquals(Constants.HALF_VIEWPORT_HEIGHT, 400);
        assertEquals(Constants.HALF_VIEWPORT_WIDTH, 400);
        assertEquals(Constants.DIMENSIONS, new Vector2(800, 800));
        assertEquals(Constants.HALF_DIMENSIONS, new Vector2(400, 400));
        assertEquals(Constants.VIEWPORT_TITLE, "Pirate Game");
        assertEquals(Constants.BACKGROUND_COLOUR, new Vector3(0.0f, 0.0f, 0.0f));
        assertEquals(Constants.PHYSICS_TIME_STEP, 1.0f / 60.0f, 0.1);
        assertEquals(Constants.TILE_SIZE, 32, 0.1);
    }

    @Test
    public void ConstantsUpdateViewportTest() {
        Constants.UPDATE_VIEWPORT(1920, 1200);

        assertEquals(Constants.VIEWPORT_HEIGHT, 1200);
        assertEquals(Constants.VIEWPORT_WIDTH, 1920);
        assertEquals(Constants.HALF_VIEWPORT_HEIGHT, 600);
        assertEquals(Constants.HALF_VIEWPORT_WIDTH, 960);
        assertEquals(Constants.DIMENSIONS, new Vector2(1920, 1200));
        assertEquals(Constants.HALF_DIMENSIONS, new Vector2(960, 600));
    }
}
