package com.mygdx.game.Entitys.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.Components.Pirate;
import com.mygdx.game.Entitys.Player;
import com.mygdx.game.Entitys.Ship;
import com.mygdx.game.Managers.GameManager;
import com.mygdx.game.Managers.ResourceManager;
import com.mygdx.game.PirateGame;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.ArrayList;

import static com.mygdx.utils.Constants.VIEWPORT_HEIGHT;

public class ShopScreen extends Page {
    Ship ship = GameManager.ships.get(0);
    public ShopScreen(PirateGame parent) {
        super(parent);
    }

    @Override
    protected void CreateActors() {
        Table s = new Table();
        s.setFillParent(true);

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

        TextButton speed = new TextButton("Buy 20 Cannonballs (30 gold)", parent.skin);
        speed.getLabel().setFontScale(fontscalebutton);
        speed.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (ship.getPlunder() <= 20) {
                    System.out.println("Unable to buy");
                } else {
                    ship.plunder(-20);
                    ship.reload(20);
                }
            }
        });
        s.add(speed).size(buttonwidth, buttonheight).top().spaceBottom(space);
        s.row();

        TextButton cannon = new TextButton("Standard heal (20 gold)", parent.skin);
        cannon.getLabel().setFontScale(fontscalebutton);
        cannon.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (ship.getPlunder() <= 20) {
                    System.out.println("Unable to buy");
                }else{
                    int hp = ship.getMaxHealth();
                    int chp = ship.getHealth();
                    int difference = hp - chp;
                    int addhp = difference * (-1);
                    if (difference == 0){
                        System.out.println("Health already full");
                    }else {
                        ship.takeDamage(addhp);
                        ship.plunder(-20);
                    }
                }
            }
        });
        s.add(cannon).size(buttonwidth, buttonheight).top().spaceBottom(space);
        s.row();

        TextButton health = new TextButton("Add 25 to max health + heal (50 gold)", parent.skin);
        health.getLabel().setFontScale(fontscalebutton);
        health.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (ship.getPlunder() <= 50){
                    System.out.println("Unable to buy");
                }else{
                    ship.plunder(-50);
                    int hp = ship.getMaxHealth();
                    int chp = ship.getHealth();
                    int newHealth = hp + 25;
                    ship.increaseMaxHealth(newHealth);
                    int difference = newHealth - chp;
                    int addhp = difference * (-1);
                    ship.takeDamage(addhp);
                }
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

        TextButton speed = new TextButton("Buy 20 Cannonballs (30 gold)", parent.skin);
        speed.getLabel().setFontScale(fontscalebutton);
        speed.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (ship.getPlunder() <= 30) {
                    System.out.println("Unable to buy");
                } else {
                    ship.plunder(-30);
                    ship.reload(20);
                }
            }
        });
        s.add(speed).size(buttonwidth, buttonheight).top().spaceBottom(space);
        s.row();

        TextButton cannon = new TextButton("Standard heal (20 gold)", parent.skin);
        cannon.getLabel().setFontScale(fontscalebutton);
        cannon.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (ship.getPlunder() <= 20) {
                    System.out.println("Unable to buy");
                }else{
                    int hp = ship.getMaxHealth();
                    int chp = ship.getHealth();
                    int difference = hp - chp;
                    int addhp = difference * (-1);
                    if (difference == 0){
                        System.out.println("Health already full");
                    }else {
                        ship.takeDamage(addhp);
                        ship.plunder(-20);
                    }
                }
            }
        });
        s.add(cannon).size(buttonwidth, buttonheight).top().spaceBottom(space);
        s.row();

        TextButton health = new TextButton("Add 25 to max health + heal (50 gold)", parent.skin);
        health.getLabel().setFontScale(fontscalebutton);
        health.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (ship.getPlunder() <= 50){
                    System.out.println("Unable to buy");
                }else{
                    ship.plunder(-50);
                    int hp = ship.getMaxHealth();
                    int chp = ship.getHealth();
                    int newHealth = hp + 25;
                    ship.increaseMaxHealth(newHealth);
                    int difference = newHealth - chp;
                    int addhp = difference * (-1);
                    ship.takeDamage(addhp);
                }
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
