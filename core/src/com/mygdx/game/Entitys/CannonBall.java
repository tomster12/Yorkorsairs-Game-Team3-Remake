package com.mygdx.game.Entitys;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Components.Renderable;
import com.mygdx.game.Components.RigidBody;
import com.mygdx.game.Components.Transform;
import com.mygdx.game.Managers.EntityManager;
import com.mygdx.game.Managers.GameManager;
import com.mygdx.game.Managers.RenderLayer;
import com.mygdx.game.Physics.CollisionCallBack;
import com.mygdx.game.Physics.CollisionInfo;
import com.mygdx.game.Physics.PhysicsBodyType;

import static com.mygdx.utils.Constants.TILE_SIZE;

/**
 * Cannonball entity and the methods to get it flying.
 */
public class CannonBall extends Entity implements CollisionCallBack {

    private static final int MAX_AGE = 5;
    private static float speed = 0.0f;

    private boolean isAlive = false;
    private boolean shouldBeAlive = false;
    private Ship shooter = null;
    private float age = 0;


    public CannonBall() {
        super(3);

        Transform t = new Transform();
        t.setPosition(-1000, -1000);
        t.setScale(0.5f, 0.5f);
        Renderable r = new Renderable(4, "ball", RenderLayer.Transparent);
        RigidBody rb = new RigidBody(PhysicsBodyType.Dynamic, r, t, true);
        rb.setCallback(this);
        addComponents(t, r, rb);

        setName("ball");
        speed = GameManager.getSettings().get("starting").getFloat("cannonSpeed");
        shouldBeAlive = false;
    }


    @Override
    public void update() {
        super.update();
        updateAlive();
    }


    /**
     * Removes the cannonball offscreen and also update whether alive.
     */
    private void updateAlive() {
        // Update age
        age += EntityManager.getDeltaTime();
        if(age > MAX_AGE) kill();

        // Kill if needed
        if (shouldBeAlive != isAlive) {

            if (!shouldBeAlive) {
                getComponent(Renderable.class).hide();
                getComponent(RigidBody.class).setPosition(new Vector2(-1000, -1000));
                getComponent(RigidBody.class).setVelocity(0, 0);

            } else {
                getComponent(Renderable.class).show();
                age = 0;
            }

            isAlive = shouldBeAlive;
        }
    }


    /**
     * Teleport the cannonball in from offscreen and set in flying away from the ship.
     *
     * @param pos    2D vector location from where it sets off
     * @param dir    2D vector direction for its movement
     * @param sender ship entity firing it
     */
    public void fire(Vector2 pos, Vector2 dir, Ship sender) {
        // Update components
        Transform t = getComponent(Transform.class);

        RigidBody rb = getComponent(RigidBody.class);
        Vector2 ta = dir.cpy().scl(speed * EntityManager.getDeltaTime());
        Vector2 o = new Vector2(TILE_SIZE * t.getScale().x, TILE_SIZE * t.getScale().y);
        Vector2 v = ta.cpy().sub(o);
        rb.setPosition(pos, true);
        rb.setVelocity(v);

        // Update variables
        shooter = sender;
        shouldBeAlive = true;
    }


    /**
     * Marks cannonball for removal on next update.
     */
    public void kill() { shouldBeAlive = false; }

    public Ship getShooter() { return shooter; }


    @Override
    public void BeginContact(CollisionInfo info) { }

    @Override
    public void EndContact(CollisionInfo info) { }

    @Override
    public void EnterTrigger(CollisionInfo info) { }

    @Override
    public void ExitTrigger(CollisionInfo info) { }
}
