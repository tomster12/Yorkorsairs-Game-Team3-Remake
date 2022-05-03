package com.mygdx.game.Components;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.GdxTestRunner;
import com.mygdx.game.Entitys.Entity;
import com.mygdx.game.PirateGame;
import com.mygdx.utils.Constants;
import org.junit.*;
import org.junit.runner.RunWith;
import com.badlogic.gdx.math.Vector3;


@RunWith(GdxTestRunner.class)
public class TextTest {
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
    public void TextPosTest () {
        Vector3 colour = new Vector3(20, 20, 20);
        Text textT = new Text(colour);

        Vector2 pos = new Vector2(40, -40);
        textT.setPosition(40, -40);
        assertEquals(pos, textT.position);
    }

    @Test
    public void TextColourTest () {
        Vector3 colour = new Vector3(20, 20, 20);
        Text textT = new Text(colour);

        Vector3 col = new Vector3(10, 10, 10);
        textT.setFontColour(col);
        assertEquals(col, textT.fontColour);
    }

    @Test
    public void TextEGTextTest () {
        Vector3 colour = new Vector3(20, 20, 20);
        Text textT = new Text(colour);

        String tex = "Example Text";
        textT.setText(tex);
        assertEquals("Example Text", textT.text);
    }

    @Test
    public void TextUpdateTest () {
        Vector3 colour = new Vector3(20, 20, 20);
        Text textT = new Text(colour);
        Transform transform = mock(Transform.class);
        Entity entParent = mock(Entity.class);
        textT.setParent(entParent);

        Vector2 pos = new Vector2(40, -40);
        textT.setPosition(40, -40);
        assertEquals(textT.position, pos);

        Vector2 v1 = new Vector2(40, -30);
        when(transform.getPosition()).thenReturn(v1);
        when(textT.parent.getComponent(Transform.class)).thenReturn(transform);

        textT.update();
        assertEquals(textT.position, v1);
    }

}