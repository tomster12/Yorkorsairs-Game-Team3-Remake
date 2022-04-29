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
public class NodeHeuristicTest {
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
    public void EuclideanHeuristicTest() {
        Node node1 = mock(Node.class);
        Node node2 = mock(Node.class);
        NodeHeuristic heuristicT = new NodeHeuristic();

        Vector2 v1 = new Vector2(2, 3);
        Vector2 v2 = new Vector2(4, 5);
        when(node1.getPosition()).thenReturn(v1);
        when(node2.getPosition()).thenReturn(v2);
        assertEquals(8, heuristicT.estimate(node1, node2), 0.1);
    }

}