package com.mygdx.game.Quests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.mygdx.GdxTestRunner;
import com.mygdx.game.Entitys.Player;
import com.badlogic.gdx.math.Vector2;
import org.junit.Test;
import org.mockito.Mock;

import org.junit.*;
import com.mygdx.game.PirateGame;
import org.junit.runner.RunWith;


@RunWith(GdxTestRunner.class)
public class LocateQuestTest {
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
    public void LocateQuestCompletionTest () {
        Vector2 qPos = new Vector2(40, -40);
        LocateQuest questT = new LocateQuest(qPos, 10);

        Player player = mock(Player.class);

        Vector2 playerPos1 = new Vector2(30, -40);
        doReturn(playerPos1).when(player).getPosition();
        System.out.println(player.getPosition());
        assertFalse(questT.checkCompleted(player));

        Vector2 playerPos2 = new Vector2(31, -40);
        when(player.getPosition()).thenReturn(playerPos2);
        assertTrue(questT.checkCompleted(player));
    }

    @Test
    public void LocateQuestPosTest () {
        Vector2 qPos = new Vector2(40, -40);
        LocateQuest questT = new LocateQuest(qPos, 10);

        Vector2 qP = new Vector2(40, -40);
        assertEquals(qP, questT.getLocation());
    }

    @Test
    public void LocateQuestIsCompleteTest () {
        Vector2 qPos = new Vector2(40, -40);
        LocateQuest questT = new LocateQuest(qPos, 10);

        assertFalse(questT.isCompleted());
    }

    @Test
    public void LocateQuestPlunderTest () {
        Vector2 qPos = new Vector2(40, -40);
        LocateQuest questT = new LocateQuest(qPos, 10);

        assertEquals(135, questT.getPlunderReward());
    }

    @Test
    public void LocateQuestXPTest () {
        Vector2 qPos = new Vector2(40, -40);
        LocateQuest questT = new LocateQuest(qPos, 10);

        assertEquals(50, questT.getXpReward());
    }

    @Test
    public void LocateQuestAmmoTest () {
        Vector2 qPos = new Vector2(40, -40);
        LocateQuest questT = new LocateQuest(qPos, 10);

        assertEquals(5, questT.getAmmoReward());
    }

    @Test
    public void LocateQuestNameTest () {
        Vector2 qPos = new Vector2(40, -40);
        LocateQuest questT = new LocateQuest(qPos, 10);

        assertEquals("Find a chest", questT.getName());
    }

    @Test
    public void LocateQuestDescTest () {
        Vector2 qPos = new Vector2(40, 40);
        LocateQuest questT = new LocateQuest(qPos, 10);
        assertEquals("North East", questT.getDescription());

        Vector2 newPos = new Vector2(-40, -40);
        LocateQuest questT2 = new LocateQuest(newPos, 10);
        assertEquals("South West", questT2.getDescription());
    }

}