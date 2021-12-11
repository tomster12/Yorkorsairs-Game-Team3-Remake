package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Components.ComponentEvent;
import com.mygdx.game.Entitys.Image;
import com.mygdx.game.Entitys.Player;
import com.mygdx.game.Entitys.WorldMap;
import com.mygdx.game.Managers.EntityManager;
import com.mygdx.game.Managers.RenderLayer;
import com.mygdx.game.Managers.RenderingManager;
import com.mygdx.utils.ResourceManager;

import static com.mygdx.utils.Constants.*;

public class PirateGame extends ApplicationAdapter {
	@Override
	public void create () {
		INIT_CONSTANTS();

		int id_ship = ResourceManager.addTexture("ship.png");
		int id_img = ResourceManager.addTexture("background.png");
		int id_map = ResourceManager.addTileMap("Map.tmx");


		ResourceManager.loadAssets();

		WorldMap worldMap = new WorldMap(id_map);
		Player player = new Player(id_ship, 10);
		Image img = new Image(id_img, RenderLayer.Two);


		EntityManager.raiseEvents(ComponentEvent.Awake, ComponentEvent.Start);
	}

	@Override
	public void render () {
		ScreenUtils.clear(BACKGROUND_COLOUR.x, BACKGROUND_COLOUR.y, BACKGROUND_COLOUR.z, 1);

		EntityManager.raiseEvents(ComponentEvent.Update, ComponentEvent.Render);

		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			Gdx.app.exit();
			System.exit(0);
		}
	}
	
	@Override
	public void dispose () {
		ResourceManager.cleanUp();
		EntityManager.cleanUp();
		RenderingManager.cleanUp();
	}
}
