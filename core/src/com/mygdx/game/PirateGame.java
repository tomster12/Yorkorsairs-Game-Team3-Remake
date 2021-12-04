package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Components.ComponentEvent;
import com.mygdx.game.Components.EntityManager;
import com.mygdx.game.Entitys.Background;
import com.mygdx.game.Entitys.Player;
import com.mygdx.utils.ResourceManager;

import static com.mygdx.utils.Constants.*;

public class PirateGame extends ApplicationAdapter {
	OrthographicCamera camera;
	Player player;
	Background bg;


	@Override
	public void create () {
		INIT_CONSTANTS();

		int id_ship = ResourceManager.addTexture("ship.png");
		int id_map = ResourceManager.addTexture("tile map.png");

		ResourceManager.loadAssets();


		bg = new Background(id_map);
		player = new Player(id_ship);

		camera = new OrthographicCamera();
		camera.setToOrtho(false, VIEWPORT_WIDTH, VIEWPORT_HEIGHT);

		EntityManager.raiseEvents(ComponentEvent.Awake, ComponentEvent.Start);
	}

	@Override
	public void render () {
		ScreenUtils.clear(BACKGROUND_COLOUR.x, BACKGROUND_COLOUR.y, BACKGROUND_COLOUR.z, 1);

		camera.position.set(new Vector3(player.getPos(), 0.0f));
		camera.update();

		EntityManager.getBatch().setProjectionMatrix(camera.combined);

		EntityManager.raiseEvents(ComponentEvent.Update, ComponentEvent.Render);

		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			Gdx.app.exit();
			System.exit(0);
		}

		float speed = HALF_VIEWPORT_WIDTH * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			Vector2 pos = player.getPos();
			pos.y += speed;
			player.setPos(pos);
		}

		if(Gdx.input.isKeyPressed(Input.Keys.S)){
			Vector2 pos = player.getPos();
			pos.y -= speed;
			player.setPos(pos);
		}

		if(Gdx.input.isKeyPressed(Input.Keys.A)){
			Vector2 pos = player.getPos();
			pos.x -= speed;
			player.setPos(pos);
		}

		if(Gdx.input.isKeyPressed(Input.Keys.D)){
			Vector2 pos = player.getPos();
			pos.x += speed;
			player.setPos(pos);
		}
	}
	
	@Override
	public void dispose () {
		ResourceManager.cleanUp();
		EntityManager.cleanUp();
	}
}
