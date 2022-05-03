package com.mygdx.game.Entitys;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Components.Pirate;
import com.mygdx.game.Components.Renderable;

import com.mygdx.game.Components.RigidBody;
import com.mygdx.game.Components.Transform;
import com.mygdx.game.Managers.EventManager;
import com.mygdx.game.Managers.RenderLayer;
import com.mygdx.game.Managers.ResourceManager;
import com.mygdx.game.Physics.CollisionInfo;
import com.mygdx.game.Physics.PhysicsBodyType;
import com.mygdx.utils.Utilities;

import java.util.ArrayList;

public class Powerup extends Event{
    ArrayList<Ship> ships;
    public Powerup(Vector2 pos, float duration, int zone_) {
        super(pos, duration, zone_);

        Transform t = getComponent(Transform.class);
        Renderable r = new Renderable(ResourceManager.getId("PowerUp.png"), RenderLayer.Above);
        RigidBody rb = new RigidBody(PhysicsBodyType.Static, r, t, true);
        rb.setCallback(this);
        addComponents(r, rb);

        rb.addTrigger(Utilities.tilesToDistance(EventManager.getSettings().get("Powerup").getInt("range")), "inside");
        ships = new ArrayList<>();
    }

    public void update(){
        super.update();

        for (Ship ship : ships){
            int hp = ship.getHealth();
            System.out.println(hp);
        }
    }
    public void EnterTrigger(CollisionInfo info){
        super.EnterTrigger(info);

        if (info.fB.getUserData() == "inside"){
            if (info.a instanceof Ship){
                System.out.println("Ship on powerup");
                ships.add((Ship) info.a);
            }
        }
    }
}
