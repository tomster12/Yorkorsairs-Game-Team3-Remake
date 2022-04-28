package com.mygdx.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConstantsTest {
    Constants constants;

    @BeforeEach
    void setUp () {
        constants = new Constants();
        constants.INIT_CONSTANTS();
    }

    @Test
    void ConstantsInitTest() {
        assertEquals(constants.SCREEN_WIDTH, 1920);
        assertEquals(constants.SCREEN_HEIGHT, 1080);
        assertEquals(constants.ASPECT_RATIO, 1.0);
        assertEquals(constants.VIEWPORT_HEIGHT, 800);
        assertEquals(constants.VIEWPORT_WIDTH, 800);
        assertEquals(constants.HALF_VIEWPORT_HEIGHT, 400);
        assertEquals(constants.HALF_VIEWPORT_WIDTH, 400);
        assertEquals(constants.DIMENSIONS, new Vector2(800, 800));
        assertEquals(constants.HALF_DIMENSIONS, new Vector2(400, 400));
        assertEquals(constants.VIEWPORT_TITLE, "Pirate Game");
        assertEquals(constants.BACKGROUND_COLOUR, new Vector3(0.0f, 0.0f, 0.0f));
        assertEquals(constants.PHYSICS_TIME_STEP, 1.0f / 60.0f);
        assertEquals(constants.TILE_SIZE, 32);
    }

    @Test
    void ConstantsUpdateViewportTest() {
        constants.UPDATE_VIEWPORT(1920, 1200);

        assertEquals(constants.ASPECT_RATIO, 1.7777777910232544);
        assertEquals(constants.VIEWPORT_HEIGHT, 1200);
        assertEquals(constants.VIEWPORT_WIDTH, 1920);
        assertEquals(constants.HALF_VIEWPORT_HEIGHT, 600);
        assertEquals(constants.HALF_VIEWPORT_WIDTH, 960);
        assertEquals(constants.DIMENSIONS, new Vector2(1920, 1200));
        assertEquals(constants.HALF_DIMENSIONS, new Vector2(960, 600));
    }
}
