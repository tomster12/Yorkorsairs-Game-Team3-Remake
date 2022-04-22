package com.mygdx.game.Entitys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Components.Renderable;
import com.mygdx.game.Components.RigidBody;
import com.mygdx.game.Components.Transform;
import com.mygdx.game.Managers.GameManager;
import com.mygdx.game.Managers.RenderLayer;
import com.mygdx.game.Managers.ResourceManager;
import com.mygdx.game.Physics.CollisionCallBack;
import com.mygdx.game.Physics.CollisionInfo;
import com.mygdx.game.Physics.PhysicsBodyType;
import com.mygdx.utils.Utilities;


/**
 * Simple entity shown on locate quests origin
 */
public class Event extends Entity implements CollisionCallBack {

    // Declare variables
    protected boolean isAlive;
    protected float timer;
    protected int zone;


    public Event(Vector2 pos, float duration, int zone_) {
        super(1);

        // Intialize components
        Transform t = new Transform();
        addComponents(t);

        // Initialize variables
        isAlive = true;
        t.setPosition(pos, true);
        timer = duration;
        zone = zone_;
    }


    @Override
    public void update() {
        super.update();
        if (!isAlive) return;

        // Update timer
        timer = (float)Math.max(0, timer - Gdx.graphics.getDeltaTime());
        if (timer == 0) isAlive = false;
    }


    public boolean isAlive() { return isAlive; }

    public int getZone() { return zone; }


    @Override
    public void BeginContact(CollisionInfo info) { }

    @Override
    public void EndContact(CollisionInfo info) { }

    @Override
    public void EnterTrigger(CollisionInfo info) { }

    @Override
    public void ExitTrigger(CollisionInfo info) { }
}
