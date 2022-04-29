package com.mygdx.game.Components;

import static org.junit.Assert.*;

import com.mygdx.GdxTestRunner;
import com.mygdx.game.Entitys.Ship;
import com.mygdx.game.PirateGame;
import org.junit.*;
import org.junit.runner.RunWith;


@RunWith(GdxTestRunner.class)
public class PirateTest {

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
    public void BasicTest() {
        assertEquals(1, 1);
    }

    @Test
    public void PirateFactionTest() {
        Pirate pirateT = new Pirate();
        assertEquals("Instantiated as being part of Halifax(faction id 1)", 1, pirateT.getFaction().id);
        pirateT.setFactionId(2);
        assertEquals("Faction id has been set to 2/an enemy faction", 2, pirateT.getFaction().id);
    }

    @Test
    public void PirateDamageTest () {
        Pirate pirateT = new Pirate();
        assertEquals(100, pirateT.getHealth());
        pirateT.takeDamage(50);
        assertEquals(50, pirateT.getHealth());
    }

    @Test
    public void PirateKillTest () {
        Pirate pirateT = new Pirate();
        assertEquals(100, pirateT.getHealth());
        assertTrue(pirateT.isAlive());
        pirateT.kill();
        assertEquals(0, pirateT.getHealth());
        assertFalse(pirateT.isAlive());
    }

    @Test
    public void PirateTargetTest () {
        Pirate pirateT = new Pirate();
        Ship shipT = new Ship();
        assertNull(pirateT.getTarget());
        pirateT.addTarget(shipT);
        assertEquals(shipT, pirateT.getTarget());
        pirateT.removeTarget();
        assertNull(pirateT.getTarget());
    }
}
