package com.mygdx.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TileMapCellsTest {
    TileMapCells cells;

    @BeforeEach
    void setUp () {
        cells = new TileMapCells();
    }

    @Test
    void TileMapCellsObstacleValueTest() {
        assertEquals(TileMapCells.OBSTACLE, 61);
    }

    @Test
    void TileMapCellsPassableValueTest() {
        assertEquals(TileMapCells.PASSABLE, 97);
    }

    @Test
    void TileMapCellsObstacleCostValueTest() {
        assertEquals(TileMapCells.OBSTACLE_COST, 100000f);
    }
}
