package com.mygdx.game.AI;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.mygdx.GdxTestRunner;
import com.mygdx.game.AI.Node;
import org.junit.Test;
import org.mockito.Mock;

import org.junit.*;
import com.mygdx.game.PirateGame;
import org.junit.runner.RunWith;

@RunWith(GdxTestRunner.class)
public class PathTest {
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
    public void PathNodeTest() {
        Node nodeT = mock(Node.class);
        Node nodeF = mock(Node.class);
        Path pathT = new Path(nodeF, nodeT);

        assertEquals(nodeT, pathT.getToNode());
        assertEquals(nodeF, pathT.getFromNode());
    }

    @Test
    public void PathCostTest() {
        Node nodeT = mock(Node.class);
        Node nodeF = mock(Node.class);
        Path pathT = new Path(nodeF, nodeT);

        assertEquals(nodeT.cost, pathT.getCost(), 0.1);
    }

}