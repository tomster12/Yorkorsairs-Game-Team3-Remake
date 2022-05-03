//package com.mygdx.game.Entitys;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.physics.box2d.Fixture;
//import com.mygdx.GdxTestRunner;
//import com.mygdx.game.Entitys.Entity;
//import com.mygdx.game.Physics.CollisionInfo;
//import com.mygdx.game.PirateGame;
//import org.junit.*;
//import org.junit.runner.RunWith;
//
//import java.util.ArrayList;
//
//
//@RunWith(GdxTestRunner.class)
//public class StormTest {
//    private static PirateGame pg;
//
//
//    @BeforeClass
//    public static void setup() {
//        pg = new PirateGame();
//        PirateGame.loadStatic();
//    }
//
//    @AfterClass
//    public static void cleanup() {
//        pg.fullReset();
//    }
//
//    @Test
//    public void StormEnterTest () {
//        Vector2 pos = new Vector2(40, -40);
//        Storm stormT = new Storm(pos, 10, 1);
//        Ship ship = mock(Ship.class);
//        CollisionInfo info = mock(CollisionInfo.class);
//
//        Fixture fb = mock(Fixture.class);
//        when(info.fB).thenReturn(fb);
////        when(fb.getUserData()).thenReturn("inside");
////        when(info.a).thenReturn(ship);
////        stormT.EnterTrigger(info);
////
////        ArrayList<Ship> shipEx = new ArrayList<>();
////        shipEx.add(ship);
////
////        assertEquals(shipEx, stormT.ships);
//
//    }
//
//}