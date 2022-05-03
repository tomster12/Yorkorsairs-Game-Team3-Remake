//package com.mygdx.game.Components;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import com.badlogic.gdx.graphics.g2d.Sprite;
//import com.badlogic.gdx.math.Vector2;
//import com.mygdx.GdxTestRunner;
//import com.mygdx.game.Entitys.Monster;
//import com.mygdx.game.Managers.EventManager;
//import com.mygdx.game.Managers.PhysicsManager;
//import com.mygdx.game.Managers.RenderLayer;
//import com.mygdx.game.Managers.ResourceManager;
//import com.mygdx.game.Physics.PhysicsBodyType;
//import com.mygdx.game.PirateGame;
//import com.mygdx.utils.Constants;
//import com.mygdx.utils.Utilities;
//import org.junit.*;
//import org.junit.runner.RunWith;
//
//
//@RunWith(GdxTestRunner.class)
//public class RigidBodyTest {
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
//    public void RBVelocityTest () {
//        Transform t = new Transform();
//        Renderable r = new Renderable(ResourceManager.getId("mon64_s.png"), RenderLayer.Transparent);
//        RigidBody bodyT = new RigidBody(PhysicsBodyType.Static, r, t);
//        bodyT.addTrigger(Utilities.tilesToDistance(EventManager.getSettings().get("monster").getInt("range")), "inside");
//
//        System.out.println(PhysicsManager.getBody(bodyT.bodyId).getPosition());
//
//        Vector2 vel = new Vector2(1, -1);
//        bodyT.setPosition(vel);
//
//        System.out.println(PhysicsManager.getBody(bodyT.bodyId).getPosition());
//    }
//}
