//package com.mygdx.game.Entitys;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import com.badlogic.gdx.math.Vector2;
//import com.mygdx.GdxTestRunner;
//import com.mygdx.game.Entitys.Entity;
//import com.mygdx.game.Entitys.Ship;
//import com.mygdx.game.Managers.ResourceManager;
//import com.mygdx.game.PirateGame;
//import com.mygdx.utils.Constants;
//import org.junit.*;
//import org.junit.runner.RunWith;
//import com.badlogic.gdx.graphics.g2d.BitmapFont;
//import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.math.Vector3;
//
//
//@RunWith(GdxTestRunner.class)
//public class WorldMapTest {
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
//    public void WorldMapTileTest () {
//        WorldMap mapT = new WorldMap(ResourceManager.mapID);
//    }
//
//}