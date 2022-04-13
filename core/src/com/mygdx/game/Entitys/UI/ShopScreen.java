package com.mygdx.game.Entitys.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.Managers.ResourceManager;
import com.mygdx.game.PirateGame;
import static com.mygdx.utils.Constants.VIEWPORT_HEIGHT;

public class ShopScreen extends Page {

    public ShopScreen(PirateGame parent) {
        super(parent);
    }

    @Override
    protected void CreateActors() {
        Table s = new Table();
        s.setFillParent(true);
        s.setDebug(true);

        int buttonwidth = Gdx.graphics.getWidth()/4;
        int buttonheight = Gdx.graphics.getHeight()/12;
        int fontscaleheader = Gdx.graphics.getHeight()/300;
        int fontscalebutton = Gdx.graphics.getHeight()/600;

        float space = VIEWPORT_HEIGHT * 0.1f;

        s.setBackground(new TextureRegionDrawable(ResourceManager.getTexture("menuBG.jpg")));
        Label l = new Label("Welcome to the shop", parent.skin);
        l.setFontScale(fontscaleheader);
        s.add(l).top().spaceBottom(space * 0.5f);
        s.row();

        Label l2 = new Label("Press E to exit the shop", parent.skin);
        l2.setFontScale(fontscalebutton);
        s.add(l2).top().spaceBottom(space * 0.5f);
        s.row();

        TextButton speed = new TextButton("Upgrade speed by 2%", parent.skin);
        speed.getLabel().setFontScale(fontscalebutton);
        speed.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.setScreen(parent.game);
            }
        });
        s.add(speed).size(buttonwidth, buttonheight).top().spaceBottom(space);
        s.row();

        TextButton cannon = new TextButton("Add 2nd Cannon", parent.skin);
        cannon.getLabel().setFontScale(fontscalebutton);
        cannon.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.setScreen(parent.game);
            }
        });
        s.add(cannon).size(buttonwidth, buttonheight).top().spaceBottom(space);
        s.row();

        TextButton health = new TextButton("Upgrade ships health by 5%", parent.skin);
        health.getLabel().setFontScale(fontscalebutton);
        health.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.setScreen(parent.game);
            }
        });
        s.add(health).size(buttonwidth, buttonheight).top().spaceBottom(space);
        health.row();

        s.top();

        actors.add(s);

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
        Table s = (Table) actors.get(0);
        s.clearChildren();
        s.setFillParent(true);

        int buttonwidth = Gdx.graphics.getWidth() / 4;
        int buttonheight = Gdx.graphics.getHeight() / 12;
        int fontscaleheader = Gdx.graphics.getHeight() / 300;
        int fontscalebutton = Gdx.graphics.getHeight() / 600;

        float space = VIEWPORT_HEIGHT * 0.15f;

        s.setBackground(new TextureRegionDrawable(ResourceManager.getTexture("menuBG.jpg")));
        Label l = new Label("Welcome to the shop", parent.skin);
        l.setFontScale(fontscaleheader);
        s.add(l).top().spaceBottom(space * 0.5f);
        s.row();

        Label l2 = new Label("Press E to exit the shop", parent.skin);
        l2.setFontScale(fontscalebutton);
        s.add(l2).top().spaceBottom(space * 0.5f);
        s.row();

        TextButton speed = new TextButton("Upgrade speed by 2%", parent.skin);
        speed.getLabel().setFontScale(fontscalebutton);
        speed.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.setScreen(parent.game);
            }
        });
        s.add(speed).size(buttonwidth, buttonheight).top().spaceBottom(space);
        s.row();

        TextButton cannon = new TextButton("Add 2nd Cannon", parent.skin);
        cannon.getLabel().setFontScale(fontscalebutton);
        cannon.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.setScreen(parent.game);
            }
        });
        s.add(cannon).size(buttonwidth, buttonheight).top().spaceBottom(space);
        s.row();

        TextButton health = new TextButton("Upgrade ships health by 5%", parent.skin);
        health.getLabel().setFontScale(fontscalebutton);
        health.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.setScreen(parent.game);
            }
        });
        s.add(health).size(buttonwidth, buttonheight).top().spaceBottom(space);
        health.row();

        s.top();

        actors.add(s);
    }

    @Override
    protected void update() {
        super.update();
        if (Gdx.input.isKeyJustPressed(Input.Keys.E)) {
            parent.setScreen(parent.game);
        }
    }
}
