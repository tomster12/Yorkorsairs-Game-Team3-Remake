package com.mygdx.game.Entitys.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.Entitys.Player;
import com.mygdx.game.Managers.GameManager;
import com.mygdx.game.Managers.ResourceManager;
import com.mygdx.game.PirateGame;

import static com.mygdx.utils.Constants.VIEWPORT_HEIGHT;

/**
 * Contains widgets defining the game end screen.
 */
public class EndScreen extends Page {
    Label wonText;
    Label playerStats;

    public EndScreen(PirateGame game) {
        super(game);
    }

    /**
     * Set game end screen status to report a win.
     */
    public void win() {
        wonText.setText("Congrats You Have Won");
    }

    /**
     * Create game end screen widgets, initialised to game loss status.
     */
    @Override
    protected void CreateActors() {
        Table t = new Table();
        int buttonwidth = Gdx.graphics.getWidth()/3;
        int buttonheight = Gdx.graphics.getHeight()/10;
        int fontscaleheader = Gdx.graphics.getHeight()/300;
        int fontscalebutton = Gdx.graphics.getHeight()/500;
        t.setBackground(new TextureRegionDrawable(ResourceManager.getTexture("menuBG.jpg")));

        float space = VIEWPORT_HEIGHT * 0.25f;
        t.setFillParent(true);
        actors.add(t);
        wonText = new Label("You have lost", parent.skin);
        wonText.setFontScale(fontscaleheader);
        t.top();
        t.add(wonText).top().spaceBottom(space);
        t.row();
        playerStats = new Label("Player Stats:\n", parent.skin);
        playerStats.setFontScale(fontscaleheader);
        t.add(playerStats).spaceBottom(space);
        t.row();
        TextButton b = new TextButton("Exit", parent.skin);
        b.getLabel().setFontScale(fontscalebutton);
        b.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.loadVisual();
                // Gdx.app.exit();
                // System.exit(0);
            }
        });
        t.add(b).size(buttonwidth, buttonheight);
    }

    @Override
    protected void update() {
        super.update();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
            System.exit(0);
        }
    }

    /**
     * Get player stats such as plunder etc. and display game end screen.
     */
    @Override
    public void show() {
        super.show();
        Player p = GameManager.getPlayer();
        String stats = String.format("Health: %s\nAmmo: %s\nPlunder: %s", p.getHealth(), p.getAmmo(), p.getPlunder());
        playerStats.setText(stats);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        Table t = (Table) actors.get(0);
        t.clearChildren();
        t.setBackground(new TextureRegionDrawable(ResourceManager.getTexture("menuBG.jpg")));
        int buttonwidth = Gdx.graphics.getWidth()/3;
        int buttonheight = Gdx.graphics.getHeight()/10;
        int fontscaleheader = Gdx.graphics.getHeight()/300;
        int fontscalebutton = Gdx.graphics.getHeight()/500;

        float space = VIEWPORT_HEIGHT * 0.25f;
        t.setFillParent(true);
        actors.add(t);
        wonText = new Label("You have lost", parent.skin);
        wonText.setFontScale(fontscaleheader);
        t.top();
        t.add(wonText).top().spaceBottom(space);
        t.row();
        playerStats = new Label("Player Stats:\n", parent.skin);
        show();
        playerStats.setFontScale(fontscaleheader);
        t.add(playerStats).spaceBottom(space);
        t.row();
        TextButton b = new TextButton("Exit", parent.skin);
        b.getLabel().setFontScale(fontscalebutton);
        b.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.loadVisual();
                // Gdx.app.exit();
                // System.exit(0);
            }
        });
        t.add(b).size(buttonwidth, buttonheight);
    }
}
