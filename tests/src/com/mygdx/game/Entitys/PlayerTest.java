package com.mygdx.game.Entitys;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.GdxTestRunner;
import com.mygdx.game.Components.Pirate;
import com.mygdx.game.Entitys.Entity;
import com.mygdx.game.PirateGame;
import com.mygdx.utils.Constants;
import org.junit.*;
import org.junit.runner.RunWith;


@RunWith(GdxTestRunner.class)
public class PlayerTest {
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
    public void PlayerAmmoTest() {
        Player playerT = new Player();
        assertEquals(playerT.getAmmo(), 50);
    }

    @Test
    public void PlayerXpTest() {
        Player playerT = new Player();
        assertEquals(playerT.getXp(), 0, 0.1);
    }

    @Test
    public void PlayerLevelTest() {
        Player playerT = new Player();
        assertEquals(playerT.getLevel(), 1);
    }

}