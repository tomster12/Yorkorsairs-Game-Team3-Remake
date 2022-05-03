//package com.mygdx.game.Components;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;
//
//import com.badlogic.gdx.maps.tiled.TiledMap;
//import com.badlogic.gdx.maps.tiled.TmxMapLoader;
//import com.badlogic.gdx.math.Vector2;
//import com.mygdx.GdxTestRunner;
//import com.mygdx.game.Managers.RenderLayer;
//import com.mygdx.game.Managers.ResourceManager;
//import com.mygdx.utils.Constants;
//import org.junit.Test;
//import org.mockito.Mock;
//import com.badlogic.gdx.graphics.GL20;
//
//import org.junit.*;
//import com.mygdx.game.PirateGame;
//import org.junit.runner.RunWith;
//
//@RunWith(GdxTestRunner.class)
//public class TileMapTest {
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
//    public void TileMapCellTest () {
//        TileMap tmapT = new TileMap(ResourceManager.mapID, RenderLayer.Five);
//
//        Vector2 pos = new Vector2(40, -40);
//        System.out.println(1);
//        System.out.println(tmapT.getCell(pos));
//        System.out.println(1);
//
//    }
//
//
//}