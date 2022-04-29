package com.mygdx.game.Quests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.mygdx.GdxTestRunner;
import com.mygdx.game.Components.Pirate;
import com.mygdx.game.Entitys.Player;
import com.mygdx.game.Faction;
import org.junit.Test;
import org.mockito.Mock;

import org.junit.*;
import com.mygdx.game.PirateGame;
import org.junit.runner.RunWith;

@RunWith(GdxTestRunner.class)
public class KillQuestTest {
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
    public void KillQuestCompletionTest () {
        Pirate targetP = mock(Pirate.class);
        Faction fac = mock(Faction.class);
        Player player = mock(Player.class);

        when(targetP.getFaction()).thenReturn(fac);
        when(fac.getName()).thenReturn("factionMock");
        Quest questT = new KillQuest(targetP);

        when(targetP.isAlive()).thenReturn(true);
        assertFalse(questT.checkCompleted(player));
        when(targetP.isAlive()).thenReturn(false);
        assertTrue(questT.checkCompleted(player));
    }

    @Test
    public void KillQuestIsCompleteTest () {
        Pirate targetP = mock(Pirate.class);
        Faction fac = mock(Faction.class);

        when(targetP.getFaction()).thenReturn(fac);
        when(fac.getName()).thenReturn("factionMock");
        Quest questT = new KillQuest(targetP);

        assertFalse(questT.isCompleted());
    }

    @Test
    public void KillQuestPlunderTest () {
        Pirate targetP = mock(Pirate.class);
        Faction fac = mock(Faction.class);

        when(targetP.getFaction()).thenReturn(fac);
        when(fac.getName()).thenReturn("factionMock");
        Quest questT = new KillQuest(targetP);

        assertEquals(75, questT.getPlunderReward());
    }

    @Test
    public void KillQuestXPTest () {
        Pirate targetP = mock(Pirate.class);
        Faction fac = mock(Faction.class);

        when(targetP.getFaction()).thenReturn(fac);
        when(fac.getName()).thenReturn("factionMock");
        Quest questT = new KillQuest(targetP);

        assertEquals(80, questT.getXpReward());
    }

    @Test
    public void KillQuestAmmoTest () {
        Pirate targetP = mock(Pirate.class);
        Faction fac = mock(Faction.class);

        when(targetP.getFaction()).thenReturn(fac);
        when(fac.getName()).thenReturn("factionMock");
        Quest questT = new KillQuest(targetP);

        assertEquals(20, questT.getAmmoReward());
    }

    @Test
    public void KillQuestNameTest () {
        Pirate targetP = mock(Pirate.class);
        Faction fac = mock(Faction.class);

        when(targetP.getFaction()).thenReturn(fac);
        when(fac.getName()).thenReturn("factionMock");
        Quest questT = new KillQuest(targetP);

        assertEquals("Kill the college", questT.getName());
    }

    @Test
    public void KillQuestDescTest () {
        Pirate targetP = mock(Pirate.class);
        Faction fac = mock(Faction.class);

        when(targetP.getFaction()).thenReturn(fac);
        when(fac.getName()).thenReturn("factionMock");
        Quest questT = new KillQuest(targetP);

        assertEquals("factionMock", questT.getDescription());
    }

}