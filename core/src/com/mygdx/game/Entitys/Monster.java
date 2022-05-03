package com.mygdx.game.Entitys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
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

import static com.mygdx.utils.Constants.TILE_SIZE;


/**
 * Simple entity shown on locate quests origin
 */
public class Monster extends Event {

    // Declare variables
    private Transform t;
    private RigidBody rb;
    private Renderable r;
    private Texture activeOpenTexture;
    private Texture activeClosedTexture;
    private Texture inactiveTexture;

    private Ship target;
    private boolean isActive;
    private boolean isAttacking;
    private float movementSpeed;
    private float attackDistance;
    private float attackDamage;
    private float attackTimerMax;
    private float attackTimer;
    private float openTimerMax;
    private float openTimer;
    private float attackDamage2;
    public int difficulty;


    public Monster(Vector2 pos, float duration, int zone_) {
        super(pos, duration, zone_);

        // Initialize components
        t = getComponent(Transform.class);
        r = new Renderable(ResourceManager.getId("mon64_s.png"), RenderLayer.Transparent);
        rb = new RigidBody(PhysicsBodyType.Static, r, t, true);
        rb.setCallback(this);
        addComponents(r, rb);

        // Setup sprites
        activeOpenTexture = ResourceManager.getTexture("mon64_o.png");
        activeClosedTexture = ResourceManager.getTexture("mon64_c.png");
        inactiveTexture = ResourceManager.getTexture("mon64_s.png");
        r.getSprite().setTexture(inactiveTexture);

        // Initialize storm radius
        rb.addTrigger(Utilities.tilesToDistance(EventManager.getSettings().get("monster").getInt("range")), "inside");

        // Initialize variables
        target = null;
        isActive = false;
        isAttacking = false;
        movementSpeed = EventManager.getSettings().get("monster").getFloat("movementSpeed");
        attackDistance = EventManager.getSettings().get("monster").getFloat("attackDistance") * TILE_SIZE;
        attackDamage = EventManager.getSettings().get("monster").getFloat("attackDamage");
        attackTimerMax = EventManager.getSettings().get("monster").getFloat("attackTimerMax");
        attackTimer = attackTimerMax;
        openTimerMax = EventManager.getSettings().get("monster").getFloat("openTimerMax");
        openTimer = openTimerMax;
        difficulty = (int) EventManager.getDiff();
    }


    @Override
    public void update() {
        super.update();
        if (!isActive) return;

        if (timer < 0.4) {
            target = null;
            isActive = false;
            isAttacking = false;
            r.getSprite().setTexture(inactiveTexture);
            return;
        }

        // Move towards target
        Vector2 dir = target.getPosition().cpy().sub(t.getPosition());
        rb.setPosition(t.getPosition().cpy().add(dir.cpy().nor().scl(TILE_SIZE * movementSpeed * Gdx.graphics.getDeltaTime())), true);

        // Begin attacking
        if (!isAttacking) {
            if (attackTimer == 0.0f) {
                isAttacking = true;
                attackTimer = attackTimerMax;
                openTimer = openTimerMax;
                r.getSprite().setTexture(activeOpenTexture);
                if (dir.len() < attackDistance){
                    target.takeDamage(attackDamage);
                }
                if (difficulty == 2){
                    attackDamage2 = (int) (attackDamage * 1.4);
                    if (dir.len() < attackDistance) {
                        target.takeDamage(attackDamage2);
                    }
                }else{
                    if (dir.len() < attackDistance){
                        target.takeDamage(attackDamage);
                    }
                }
                } else{
                attackTimer = Math.max(0.0f, attackTimer - Gdx.graphics.getDeltaTime());
            }
        // Stop attacking
        } else {
            if (openTimer == 0.0f) {
                isAttacking = false;
                r.getSprite().setTexture(activeClosedTexture);
            } else openTimer = Math.max(0.0f, openTimer - Gdx.graphics.getDeltaTime());
        }
    }


    @Override
    public void EnterTrigger(CollisionInfo info) {
        super.EnterTrigger(info);

        // Check if ship entering radius
        if (info.fB.getUserData() == "inside") {
            if (info.a instanceof Ship && !isActive) {
                target = (Ship)info.a;
                isActive = true;
                isAttacking = false;
                attackTimer = attackTimerMax;
                r.getSprite().setTexture(activeClosedTexture);
            }
        }
    }


    @Override
    public void ExitTrigger(CollisionInfo info) {
        super.ExitTrigger(info);

        // Check if ship leaving radius
        if (info.fB.getUserData() == "inside") {
            if (info.a instanceof Ship && isActive) {
                target = null;
                isActive = false;
                isAttacking = false;
                r.getSprite().setTexture(inactiveTexture);
            }
        }
    }
}
