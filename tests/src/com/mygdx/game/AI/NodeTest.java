package com.mygdx.game.AI;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.mygdx.GdxTestRunner;
import com.mygdx.game.AI.Node;
import org.junit.Test;
import org.mockito.Mock;
import com.badlogic.gdx.math.Vector2;

import org.junit.*;
import com.mygdx.game.PirateGame;
import org.junit.runner.RunWith;

@RunWith(GdxTestRunner.class)
public class NodeTest {
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
    public void NodePositionTest () {
        Vector2 pos1 = new Vector2(40, -40);
        Vector2 pos2 = new Vector2(30, -30);
        Node testNode = new Node(40, -40);

        assertEquals(pos1, testNode.getPosition());
        testNode.set(30, -30);
        assertEquals(pos2, testNode.getPosition());
    }

}