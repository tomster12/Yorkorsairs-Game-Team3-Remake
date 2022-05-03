package com.mygdx.utils;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.*;

public class TileMapCellsTest {

    @Test
    public void TileMapCellsObstacleValueTest() {
        assertEquals(TileMapCells.OBSTACLE, 61);
    }

    @Test
    public void TileMapCellsPassableValueTest() {
        assertEquals(TileMapCells.PASSABLE, 97);
    }

    @Test
    public void TileMapCellsObstacleCostValueTest() {
        assertEquals(TileMapCells.OBSTACLE_COST, 100000f, 0.1);
    }
}
