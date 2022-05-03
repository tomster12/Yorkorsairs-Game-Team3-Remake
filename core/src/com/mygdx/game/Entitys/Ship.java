package com.mygdx.game.Entitys;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.ObjectMap;
import com.mygdx.game.Components.Pirate;
import com.mygdx.game.Components.Renderable;
import com.mygdx.game.Components.RigidBody;
import com.mygdx.game.Components.Transform;
import com.mygdx.game.Faction;
import com.mygdx.game.Managers.GameManager;
import com.mygdx.game.Managers.RenderLayer;
import com.mygdx.game.Managers.ResourceManager;
import com.mygdx.game.Physics.CollisionCallBack;
import com.mygdx.game.Physics.CollisionInfo;
import com.mygdx.game.Physics.PhysicsBodyType;
import com.mygdx.game.PirateGame;
import com.mygdx.utils.Utilities;

import java.util.Objects;

/**
 * Base class for game ships, Player & NPC.
 */
public class Ship extends Entity implements CollisionCallBack {
    private static int shipCount = 0;
    public static ObjectMap<Vector2, String> shipDirections;

    private Transform t;
    private final Vector2 currentDir;
    private Healthbar healthbar;
    private int newHealth;

    /**
     * Creates a ship entity, containing Transform, Renderable, RigidBody, and Pirate components.
     */
    public Ship() {
        super(4);
        currentDir = new Vector2();
        setName("Ship (" + shipCount++ + ")"); // each ship has a unique name
//        maxHealth = GameManager.getSettings().get("").getFloat("");

        if (shipDirections == null) {
            shipDirections = new ObjectMap<>();
            shipDirections.put(new Vector2(0, 1), "-up");
            shipDirections.put(new Vector2(0, -1), "-down");
            shipDirections.put(new Vector2(1, 0), "-right");
            shipDirections.put(new Vector2(-1, 0), "-left");
            shipDirections.put(new Vector2(1, 1), "-ur");
            shipDirections.put(new Vector2(-1, 1), "-ul");
            shipDirections.put(new Vector2(1, -1), "-dr");
            shipDirections.put(new Vector2(-1, -1), "-dl");
        }

        t = new Transform();
        t.setPosition(800, 800);
        Renderable r = new Renderable(3, "white-up", RenderLayer.Transparent);
        RigidBody rb = new RigidBody(PhysicsBodyType.Dynamic, r, t);
        rb.setCallback(this);

        Pirate p = new Pirate();

        addComponents(t, r, rb, p);

        healthbar = new Healthbar(RenderLayer.Above);
        healthbar.setPosition(t.getPosition().add(0, -15f));
        healthbar.setScale(0.3f, 0.3f);
        healthbar.setOffset(new Vector2(r.getSprite().getWidth() * 0.5f, -10.0f));
        healthbar.setMaxValue(getMaxHealth());
    }


    @Override
    public void update() {
        super.update();

        healthbar.setPosition(t.getPosition());
        healthbar.setValue(getHealth());
    }


    public boolean isAlive() {
        return getComponent(Pirate.class).getHealth() > 0;
    }

    public static float getAttackRange() {
        return Utilities.tilesToDistance(GameManager.getSettings().get("starting").getFloat("attackRange_tiles"));
    }

    public void plunder(int money) {
        getComponent(Pirate.class).addPlunder(money);
    }

    public void reload(int ammo) { getComponent(Pirate.class).addAmmo(ammo); }

    public void level(float xp) { getComponent(Pirate.class).addXp(xp); }


    /**
     *
     * Tells pirate to take damage, and goes to end screen if needed
     *
     * @param damage amount to take
     */
    public void takeDamage(float damage) {
        // Pass damage to pirate
        getComponent(Pirate.class).takeDamage(damage);
        if (!isAlive() && this instanceof Player) {
            PirateGame.getInstance().setScreen(PirateGame.getInstance().end);
        }
    }

    /**
     * Associates ship with faction and orients it to the default northern direction.
     *
     * @param factionId the desired faction id
     */
    public void setFaction(int factionId) {
        getComponent(Pirate.class).setFactionId(factionId);
        setShipDirection("-up");
    }

    /**
     * gets the string representation of the direction the ship is facing
     *
     * @param dir the vector dir the ship is facing
     * @return the string representation of the direction
     */
    private String getShipDirection(Vector2 dir) {
        if (!currentDir.equals(dir) && shipDirections.containsKey(dir)) {
            currentDir.set(dir);
            return shipDirections.get(dir);
        }
        return "";
    }

    /**
     * gets the faction colour
     *
     * @return the faction colour
     */
    private String getColour() {
        return getComponent(Pirate.class).getFaction().getColour();
    }

    /**
     * will rotate the ship to face the direction (just changes the sprite doesn't actually rotate)
     *
     * @param dir the dir to face (used to get the correct sprite from the texture atlas
     */
    public void setShipDirection(Vector2 dir) {
        setShipDirection(getShipDirection(dir));
    }

    /**
     * will rotate the ship to face the right direction (just changes the sprite doesn't actually rotate)
     *
     * @param direction the dir to face (used to get the correct sprite from the texture atlas
     */
    public void setShipDirection(String direction) {
        if (Objects.equals(direction, "")) {
            return;
        }
        Renderable r = getComponent(Renderable.class);
        Sprite s = ResourceManager.getSprite(3, getColour() + direction);

        try {
            r.setTexture(s);
            
        } catch (Exception ignored) {

        }
    }

    public int getHealth() { return getComponent(Pirate.class).getHealth(); }

    public int getMaxHealth() { return getComponent(Pirate.class).getMaxHealth(); }

    public int getPlunder() {
        return getComponent(Pirate.class).getPlunder();
    }

    public int getAmmo() {
        return getComponent(Pirate.class).getAmmo();
    }

    public void shoot(Vector2 dir) { getComponent(Pirate.class).shoot(dir); }

    public void shoot() {
        getComponent(Pirate.class).shoot(currentDir);
    }

    public void increaseMaxHealth(int newHealth){
        getComponent(Pirate.class).increaseMaxHealth(newHealth);
        healthbar.setMaxValue(getMaxHealth());
        healthbar.setValue(getHealth());
    }

    /**
     * @return copy of the transform's position
     */
    public Vector2 getPosition() {
        return getComponent(Transform.class).getPosition().cpy();
    }

    @Override
    public void BeginContact(CollisionInfo info) {

    }

    @Override
    public void EndContact(CollisionInfo info) {

    }

    /**
     * if called on a Player against anything else call it on the other thing
     */
    @Override
    public void EnterTrigger(CollisionInfo info) {
        // Player TRIGGER ship - only calls on PLAYER for some reason - hence the else call
        // Otherwise works normally - meaning NPCShip override will call correctly for cannonball but not player^

        CannonBall ball = null;
        if (info.a instanceof CannonBall) ball = (CannonBall) info.a;
        if (info.b instanceof CannonBall) ball = (CannonBall) info.b;

        if (isAlive() && ball != null) {
            // the ball if from the same faction
            Faction ballFaction = ball.getShooter().getComponent(Pirate.class).getFaction();
            Faction thisFaction = getComponent(Pirate.class).getFaction();
            if (Objects.equals(ballFaction.getName(), thisFaction.getName())) return;

            takeDamage(ball.getDamage());
            ball.kill();

            if (!isAlive()) {
                Ship ship = ball.getShooter();
                ship.plunder((int) (Math.random() * 10 + 15));
                ship.reload((int) (Math.random() * 2 + 0));
                ship.level((int) (Math.random() * 10 + 15));
            }

        } else if (this instanceof Player && !(info.b instanceof Player)) {
            ((CollisionCallBack) info.b).EnterTrigger(info);
        }
    }

    /**
     * if called on a Player against anything else call it on the other thing
     */
    @Override
    public void ExitTrigger(CollisionInfo info) {
        if (this instanceof Player && !(info.b instanceof Player)) {
            ((CollisionCallBack) info.b).ExitTrigger(info);
        }
    }
}
