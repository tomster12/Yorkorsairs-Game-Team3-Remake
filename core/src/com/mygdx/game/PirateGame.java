package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Managers.*;
import com.mygdx.game.Entitys.UI.EndScreen;
import com.mygdx.game.Entitys.UI.GameScreen;
import com.mygdx.game.Entitys.UI.MenuScreen;

/**
 * Contains class instances of game UI screens.
 */
public class PirateGame extends Game {

    public MenuScreen menu;
    public GameScreen game;
    public EndScreen end;
    public Stage stage;
    public Skin skin;

    private int id_map; // Keep track in between resets


    /**
     * Create instances of game stage and UI screens.
     */
    @Override
    public void create() {
        // load resources
        ResourceManager.addTexture("ship.png");
        id_map = ResourceManager.addTileMap("Map.tmx");
        ResourceManager.addTextureAtlas("Boats.txt");
        ResourceManager.addTextureAtlas("UISkin/skin.atlas");
        ResourceManager.addTextureAtlas("Buildings.txt");
        ResourceManager.addTexture("menuBG.jpg");
        ResourceManager.addTexture("Chest.png");
        ResourceManager.addTexture("healthbar.png");
        ResourceManager.addTexture("healthbarfill.png");
        ResourceManager.loadAssets();
        reload();
    }


    public void reload() {
        // Reset all managers
        RenderingManager.reset();
        GameManager.reset();
        PhysicsManager.reset();
        CollisionManager.reset();
        QuestManager.reset();
        EntityManager.reset();

        // Fully reset pirate game
        stage = new Stage(new ScreenViewport());
        createSkin();
        menu = new MenuScreen(this);
        game = new GameScreen(this, id_map);
        end = new EndScreen(this);
        setScreen(menu);
    }


    /**
     * Clean up prevent memory leeks
     */
    @Override
    public void dispose() {
        menu.dispose();
        game.dispose();
        stage.dispose();
        skin.dispose();
    }


    /**
     * load ui skin from assets
     */
    private void createSkin() {
        skin = new Skin(Gdx.files.internal("UISkin/skin.json"));
    }
}
