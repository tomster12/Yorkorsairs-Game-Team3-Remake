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
import com.badlogic.gdx.math.Vector3;


@RunWith(GdxTestRunner.class)
public class ShipTest {
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
    public void ShipPlunderTest () {
        Ship ship = new Ship();

        assertEquals(ship.getPlunder(), 0);
        ship.plunder(20);
        assertEquals(ship.getPlunder(), 20);
    }

    @Test
    public void ShipAmmoTest () {
        Ship ship = new Ship();

        assertEquals(ship.getAmmo(), 50);
        ship.reload(20);
        assertEquals(ship.getAmmo(), 70);
    }

    @Test
    public void ShipLevelTest () {
        Ship ship = new Ship();

        assertEquals(ship.getComponent(Pirate.class).getLevel(), 1);
        ship.level(100);
        assertEquals(ship.getComponent(Pirate.class).getLevel(), 1);
        ship.level(1);
        assertEquals(ship.getComponent(Pirate.class).getLevel(), 2);
    }

    @Test
    public void ShipAttackRangeTest () {
        assertEquals(Ship.getAttackRange(), 128, 0.1);
    }

    @Test
    public void ShipDamageTest () {
        Ship ship = new Ship();

        assertEquals(ship.getMaxHealth(), 100);
        assertTrue(ship.isAlive());

        ship.takeDamage(99);
        assertEquals(ship.getHealth(), 1);
        assertTrue(ship.isAlive());

        ship.takeDamage(1);
        assertEquals(ship.getHealth(), 0);
        assertFalse(ship.isAlive());
    }

    @Test
    public void ShipFactionTest () {
        Ship ship = new Ship();
        ship.setFaction(1);

        assertEquals(ship.getComponent(Pirate.class).getFaction().id, 1);
    }

}