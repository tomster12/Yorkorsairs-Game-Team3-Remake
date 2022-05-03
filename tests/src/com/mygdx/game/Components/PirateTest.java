package com.mygdx.game.Components;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.GdxTestRunner;
import com.mygdx.game.Entitys.Ship;
import com.mygdx.game.PirateGame;
import com.mygdx.utils.Constants;
import org.junit.*;
import org.junit.runner.RunWith;


@RunWith(GdxTestRunner.class)
public class PirateTest {
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
        Ship shipT = mock(Ship.class);
        assertNull(pirateT.getTarget());
        pirateT.addTarget(shipT);
        assertEquals(shipT, pirateT.getTarget());
        assertEquals(1, pirateT.targetCount());
        pirateT.removeTarget();
        assertNull(pirateT.getTarget());
    }

    @Test
    public void PirateXpTest() {
        Pirate pirateT = new Pirate();

        assertEquals(pirateT.getXp(), 0, 0.1);
        assertEquals(pirateT.getLevel(), 1);

        pirateT.addXp(100);
        assertEquals(pirateT.getXp(), 100, 0.1);
        assertEquals(pirateT.getLevel(), 1);

        pirateT.addXp(1);
        assertEquals(pirateT.getXp(), 1, 0.1);
        assertEquals(pirateT.getLevel(), 2);

        pirateT.addXp(200);
        assertEquals(pirateT.getXp(), 1, 0.1);
        assertEquals(pirateT.getLevel(), 2);
    }

    @Test
    public void PiratePlunderTest() {
        Pirate pirateT = new Pirate();

        assertEquals(pirateT.getPlunder(), 0);
        pirateT.addPlunder(50);
        assertEquals(pirateT.getPlunder(), 50);
    }

    @Test
    public void PirateAmmoTest() {
        Pirate pirateT = new Pirate();

        assertEquals(pirateT.getAmmo(), 50);
        pirateT.addAmmo(50);
        assertEquals(pirateT.getAmmo(), 100);
    }

    @Test
    public void PirateMaxHealthTest() {
        Pirate pirateT = new Pirate();

        assertEquals(pirateT.getMaxHealth(), 100);
    }

    @Test
    public void PirateCanAttackTest() {
        Ship parentShip = new Ship();
        Ship ship1 = mock(Ship.class);
        Pirate pirateT = parentShip.getComponent(Pirate.class);
        pirateT.addTarget(ship1);

        Vector2 shipPos = new Vector2(800, 658);
        when(ship1.getPosition()).thenReturn(shipPos);

        assertTrue(pirateT.canAttack());

        Vector2 shipPos2 = new Vector2(800, 657);
        when(ship1.getPosition()).thenReturn(shipPos2);

        assertFalse(pirateT.canAttack());
    }

    @Test
    public void PirateAgroTest() {
        Ship parentShip = new Ship();
        Ship ship1 = mock(Ship.class);
        Pirate pirateT = parentShip.getComponent(Pirate.class);
        pirateT.addTarget(ship1);

        Vector2 shipPos = new Vector2(800, 657);
        when(ship1.getPosition()).thenReturn(shipPos);

        assertTrue(pirateT.isAgro());

        Vector2 shipPos2 = new Vector2(800, 658);
        when(ship1.getPosition()).thenReturn(shipPos2);


        assertFalse(pirateT.isAgro());
    }

}
