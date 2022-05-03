//package com.mygdx.game.Components;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import com.badlogic.gdx.math.Vector2;
//import com.mygdx.GdxTestRunner;
//import com.mygdx.game.Entitys.Player;
//import com.mygdx.game.Entitys.Ship;
//import com.mygdx.game.PirateGame;
//import com.mygdx.utils.Constants;
//import org.junit.*;
//import org.junit.runner.RunWith;
//
//
//@RunWith(GdxTestRunner.class)
//public class PlayerControllerTest {
//    private static PirateGame pg;
//
//
//    @BeforeClass
//    public static void setup() {
//        pg = new PirateGame();
//        PirateGame.loadStatic();
//
//        Constants.INIT_CONSTANTS();
//    }
//
//    @AfterClass
//    public static void cleanup() {
//        pg.fullReset();
//    }
//
//    @Test
//    public void PCSpeedTest () {
//        Player player = new Player();
//        PlayerController controllerT = new PlayerController(player, 100);
//
//        assertEquals(controllerT.sp);
//    }
//
//}