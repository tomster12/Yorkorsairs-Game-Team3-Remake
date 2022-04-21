package com.mygdx.game.Managers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Components.Component;
import com.mygdx.game.Entitys.Building;

import java.util.ArrayList;

import static com.mygdx.utils.Constants.*;

/**
 * Responsible for all rending. Renders in layers render item layers can't be changed
 * holds the primary sprite batch and rendering camera
 */
public final class RenderingManager {
    private static boolean initialized = false;
    private static ArrayList<ArrayList<Component>> renderLayers;
    private static OrthographicCamera camera;
    private static SpriteBatch batch;


    public static void Initialize() {
        initialized = true;

        batch = new SpriteBatch();
        // batch.enableBlending();
        camera = new OrthographicCamera();
        camera.viewportHeight = VIEWPORT_HEIGHT / ZOOM;
        camera.viewportWidth = VIEWPORT_WIDTH / ZOOM;
        camera.update();

        renderLayers = new ArrayList<>(RenderLayer.values().length);

        for (int i = 0; i < RenderLayer.values().length; i++) {
            renderLayers.add(new ArrayList<>());
        }
    }

    /**
     * Resets the manager if initialized
     */
    public static void reset() {
        if (initialized) {
            initialized = false;
            renderLayers = null;
            camera = null;
            batch = null;
        }
    }

    private static void tryInit() {
        if (!initialized) {
            Initialize();
        }
    }

    public static OrthographicCamera getCamera() {
        return camera;
    }


    public static void setCamera(OrthographicCamera cam) {
        camera = cam;
    }

    /**
     * adds item to the list of renderable and adds to the correct layer
     *
     * @param item  component that utilises render
     * @param layer the layer that it will be rendered in
     */
    public static void addItem(Component item, RenderLayer layer) {
        tryInit();
        renderLayers.get(layer.ordinal()).add(item);
    }

    /**
     * Remove item to the list of renderable and removes to the correct layer
     *
     * @param item  component that utilises render
     * @param layer the layer that it will be removed from
     */
    public static void removeItem(Component item, RenderLayer layer) {
        tryInit();
        renderLayers.get(layer.ordinal()).remove(item);
    }

    /**
     * Renders all items in accordance with their layers on one sprite batch
     */
    public static void render() {
        tryInit();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        for (ArrayList<Component> renderLayer : renderLayers) {
            for (Component c : renderLayer) {
                c.render();
            }
        }

        /*for(int i = 0; i < renderItems.size(); i++){
            //renderItems.get(renderItems.size() - (1 + i)).render();
            renderItems.get(i).render();
        }*/

        batch.end();
    }

    public static void cleanUp() {
        batch.dispose();
    }

    public static SpriteBatch getBatch() {
        return batch;
    }
}
