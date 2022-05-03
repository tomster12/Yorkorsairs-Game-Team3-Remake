package com.mygdx.utils;

import static org.junit.Assert.*;

import com.mygdx.utils.Constants;
import org.junit.Test;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import org.junit.*;

public class ConstantsTest {

    @Test
    public void ConstantsInitTest() {
        Constants.INIT_CONSTANTS();

        assertEquals(Constants.SCREEN_WIDTH, 1920);
        assertEquals(Constants.SCREEN_HEIGHT, 1080);
        assertEquals(Constants.ASPECT_RATIO, 1.0, 0.1);
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
        Constants.INIT_CONSTANTS();
        Constants.UPDATE_VIEWPORT(1920, 1200);

        assertEquals(Constants.ASPECT_RATIO, 1.7777777910232544, 0.1);
        assertEquals(Constants.VIEWPORT_HEIGHT, 1200);
        assertEquals(Constants.VIEWPORT_WIDTH, 1920);
        assertEquals(Constants.HALF_VIEWPORT_HEIGHT, 600);
        assertEquals(Constants.HALF_VIEWPORT_WIDTH, 960);
        assertEquals(Constants.DIMENSIONS, new Vector2(1920, 1200));
        assertEquals(Constants.HALF_DIMENSIONS, new Vector2(960, 600));
    }
}
