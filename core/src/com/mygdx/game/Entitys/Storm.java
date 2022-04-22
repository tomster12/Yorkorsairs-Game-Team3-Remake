package com.mygdx.game.Entitys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Components.Renderable;
import com.mygdx.game.Components.RigidBody;
import com.mygdx.game.Components.Transform;
import com.mygdx.game.Managers.EventManager;
import com.mygdx.game.Managers.GameManager;
import com.mygdx.game.Managers.RenderLayer;
import com.mygdx.game.Managers.ResourceManager;
import com.mygdx.game.Physics.CollisionInfo;
import com.mygdx.game.Physics.PhysicsBodyType;
import com.mygdx.utils.Utilities;

import java.util.ArrayList;


/**
 * Simple entity shown on locate quests origin
 */
public class Storm extends Event {

    // Declare variables
    Vector2 windDir;
    ArrayList<Ship> ships;


    public Storm(Vector2 pos, float duration, int zone_) {
        super(pos, duration, zone_);

        // Initialize components
        Transform t = getComponent(Transform.class);
        Renderable r = new Renderable(ResourceManager.getId("storm.png"), RenderLayer.Above);
        RigidBody rb = new RigidBody(PhysicsBodyType.Static, r, t, true);
        rb.setCallback(this);
        addComponents(r, rb);

        // Initialize variables
        rb.addTrigger(Utilities.tilesToDistance(EventManager.getSettings().get("storm").getInt("range")), "inside");
        windDir = new Vector2();
        ships = new ArrayList<>();
    }


    @Override
    public void update() {
        super.update();

        // Remove all ships on death
        if (!isAlive) ships.clear();

        // Update windDir
        if (Math.random() < 0.04) {
            float xacc = ((float)Math.random() * 2 - 1) * 100;
            float yacc = ((float)Math.random() * 2 - 1) * 100;
            windDir.set(xacc, yacc);
        }

        // Update all ships inside storm
        for (Ship ship : ships) {
            RigidBody rb = ship.getComponent(RigidBody.class);
            Vector2 newVel = rb.getVelocity().cpy().scl(0.85f).add(windDir);
            rb.setVelocity(newVel);
        }
    }

    @Override
    public void EnterTrigger(CollisionInfo info) {
        // Check if ship entered radius
        if (info.fB.getUserData() == "inside") {
            if (info.a instanceof Ship) {
                ships.add((Ship) info.a);
            }
        }
    }


    @Override
    public void ExitTrigger(CollisionInfo info) {
        // Check if ship exited radius
        if (info.fB.getUserData() == "inside") {
            if (info.a instanceof Ship) {
                ships.remove((Ship) info.a);
            }
        }
    }
}
