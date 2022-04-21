package com.mygdx.game.Entitys;

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

/**
 * Simple entity shown on locate quests origin
 */
public class Storm extends Event {


    public Storm(Vector2 pos, float duration, int zone_) {
        super(pos, duration, zone_);

        // Initialize components
        Transform t = getComponent(Transform.class);
        Renderable r = new Renderable(ResourceManager.getId("storm.png"), RenderLayer.Above);
        RigidBody rb = new RigidBody(PhysicsBodyType.Static, r, t, true);
        rb.setCallback(this);
        addComponents(r, rb);

        // Initialize storm radius
        rb.addTrigger(Utilities.tilesToDistance(EventManager.getSettings().get("storm").getInt("range")), "inside");
    }


    public void EnterTrigger(CollisionInfo info) {
        // Check if ship inside radius
        if (info.fB.getUserData() == "inside") {
            if (info.a instanceof Ship) {
                System.out.println("Ship inside weather");
            }
        }
    }
}
