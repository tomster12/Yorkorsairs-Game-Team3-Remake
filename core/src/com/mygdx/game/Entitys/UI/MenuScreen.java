package com.mygdx.game.Entitys.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.Managers.ResourceManager;
import com.mygdx.game.PirateGame;

import static com.mygdx.utils.Constants.VIEWPORT_HEIGHT;

/**
 * Contains widgets defining the start-of-game menu screen.
 */
public class MenuScreen extends Page {
    public MenuScreen(PirateGame parent) {
        super(parent);
    }


    /**
     * Create menu widgets such as start button, labels, etc.
     */
    @Override
    protected void CreateActors() {
        Table t = new Table();
        t.setFillParent(true);

        int buttonwidth = Gdx.graphics.getWidth()/3;
        int buttonheight = Gdx.graphics.getHeight()/10;
        int fontscaleheader = Gdx.graphics.getHeight()/300;
        int fontscalebutton = Gdx.graphics.getHeight()/500;


        float space = VIEWPORT_HEIGHT * 0.25f;

        t.setBackground(new TextureRegionDrawable(ResourceManager.getTexture("menuBG.jpg")));
        Label l = new Label("Pirates the movie the game", parent.skin);
        l.setFontScale(fontscaleheader);
        t.add(l).top().spaceBottom(space * 0.5f);
        t.row();

        TextButton play = new TextButton("Play", parent.skin);
        play.getLabel().setFontScale(fontscalebutton);
        play.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.setScreen(parent.game);
            }
        });
        t.add(play).size(buttonwidth, buttonheight).top().spaceBottom(space);
        t.row();

        TextButton quit = new TextButton("Quit", parent.skin);
        quit.getLabel().setFontScale(fontscalebutton);
        quit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
                System.exit(0);
            }
        });
        t.add(quit).size(buttonwidth, buttonheight).top().spaceBottom(space);

        t.top();

        actors.add(t);
    }

    @Override
    public void show() {
        super.show();
    }


    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        Table t = (Table) actors.get(0);
        t.clearChildren();
        t.setFillParent(true);

        int buttonwidth = Gdx.graphics.getWidth()/3;
        int buttonheight = Gdx.graphics.getHeight()/10;
        int fontscaleheader = Gdx.graphics.getHeight()/300;
        int fontscalebutton = Gdx.graphics.getHeight()/500;


        float space = VIEWPORT_HEIGHT * 0.25f;

        t.setBackground(new TextureRegionDrawable(ResourceManager.getTexture("menuBG.jpg")));
        Label l = new Label("Pirates the movie the game", parent.skin);
        l.setFontScale(fontscaleheader);
        t.add(l).top().spaceBottom(space * 0.5f);
        t.row();

        TextButton play = new TextButton("Play", parent.skin);
        play.getLabel().setFontScale(fontscalebutton);
        play.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.setScreen(parent.game);
            }
        });
        t.add(play).size(buttonwidth, buttonheight).top().spaceBottom(space);
        t.row();

        TextButton quit = new TextButton("Quit", parent.skin);
        quit.getLabel().setFontScale(fontscalebutton);
        quit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
                System.exit(0);
            }
        });
        t.add(quit).size(buttonwidth, buttonheight).top().spaceBottom(space);

        t.top();

        actors.add(t);
    }
}
