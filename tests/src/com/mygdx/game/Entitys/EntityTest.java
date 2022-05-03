package com.mygdx.game.Entitys;

import static org.junit.Assert.*;
import com.mygdx.game.Components.AINavigation;
import com.mygdx.GdxTestRunner;
import com.mygdx.game.Components.ComponentType;
import com.mygdx.game.PirateGame;
import org.junit.*;
import org.junit.runner.RunWith;

@RunWith(GdxTestRunner.class)
public class EntityTest {
    private static Entity entity;
    private static PirateGame pg;

    @BeforeClass
    public static void setup() {
        pg = new PirateGame();
        PirateGame.loadStatic();
        entity = new Entity();
    }

    @AfterClass
    public static void cleanup() {
        pg.fullReset();
    }

    @Test
    public void EntityAddComponentTest () {
        AINavigation nav = new AINavigation();
        entity.addComponent(nav);

        assertEquals(nav.getClass(), entity.getComponent(ComponentType.AINavigation).getClass());
    }

    @Test
    public void EntityAddComponentsTest () {
        AINavigation nav = new AINavigation();
        AINavigation nav2 = new AINavigation();
        entity.addComponents(nav, nav2);

        assertEquals(nav.getClass(), entity.getComponent(ComponentType.AINavigation).getClass());
    }

    @Test
    public void EntityGetComponentTest () {
        AINavigation nav = new AINavigation();
        entity.addComponent(nav);

        assertEquals(nav, entity.getComponent(ComponentType.AINavigation));
    }
}
