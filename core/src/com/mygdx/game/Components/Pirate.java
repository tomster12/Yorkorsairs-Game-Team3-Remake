package com.mygdx.game.Components;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonValue;
import com.mygdx.game.Entitys.Ship;
import com.mygdx.game.Faction;
import com.mygdx.game.Managers.GameManager;
import com.mygdx.utils.QueueFIFO;

/**
 * Gives the concepts of health plunder, etc. Allows for firing of cannonballs, factions, death, targets
 */
public class Pirate extends Component {

    private int factionId;
    private int plunder;
    protected boolean isAlive;
    private int health;
    private int maxHealth;
    private int ammo;
    private float xp = 0;
    private int level = 1;
    private final int attackDmg;

    /**
     * The enemy that is being targeted by the AI.
     */
    private final QueueFIFO<Ship> targets;

    public Pirate() {
        super();
        targets = new QueueFIFO<>();
        type = ComponentType.Pirate;
        plunder = GameManager.getSettings().get("starting").getInt("plunder");
        factionId = 1;
        isAlive = true;
        JsonValue starting = GameManager.getSettings().get("starting");
        health = starting.getInt("health");
        maxHealth = health;
        ammo = starting.getInt("ammo");
        attackDmg = starting.getInt("damage");
    }

    public void addTarget(Ship target) {
        targets.add(target);
    }

    public Faction getFaction() {
        return GameManager.getFaction(factionId);
    }

    public void setFactionId(int factionId) {
        this.factionId = factionId;
    }

    public void takeDamage(float dmg) {
        health -= dmg;
        if (health <= 0) {
            health = 0;
            isAlive = false;
        }
    }

    public void increaseMaxHealth(int newMaxHealth){
        maxHealth = newMaxHealth;
    }


    private void updateXp() {
        // Check levelled up
        float req = GameManager.getSettings().get("Level").getFloat("xpPerLevel");
        if (xp > req) {
            level++;
            xp = xp - req;
        }

        // Update xp bar
    }

    /**
     * Will shoot a cannonball assigning this.parent as the cannonball's parent (must be Ship atm)
     *
     * @param dir the direction to shoot in
     */
    public void shoot(Vector2 dir) {
        if (ammo == 0) return;
        ammo--;
        float inc = GameManager.getSettings().get("Level").getFloat("cannonSpeedMultIncrease");
        float speedMult = 1.0f + level * inc;
        GameManager.shoot((Ship) parent, dir, attackDmg, speedMult);
    }

    /**
     * if dst to target is less than attack range
     * target will be null if not in agro range
     */
    public boolean canAttack() {
        if (targets.peek() != null) {
            final Ship p = (Ship) parent;
            final Vector2 pos = p.getPosition();
            final float dst = pos.dst(targets.peek().getPosition());
            // withing attack range
            return dst < Ship.getAttackRange();
        }
        return false;
    }

    /**
     * if dst to target is >= attack range
     * target will be null if not in agro range
     */
    public boolean isAgro() {
        if (targets.peek() != null) {
            final Ship p = (Ship) parent;
            final Vector2 pos = p.getPosition();
            final float dst = pos.dst(targets.peek().getPosition());
            // out of attack range but in agro range
            return dst >= Ship.getAttackRange();
        }
        return false;
    }

    public Vector2 printPos() {
        if (targets.peek() != null) {
            final Ship p = (Ship) parent;
            final Vector2 pos = p.getPosition();
            return pos;
        }
        return null;
    }

    public Ship getTarget() {
        return targets.peek();
    }

    public void removeTarget() {
        targets.pop();
    }

    public boolean isAlive() {
        return isAlive;
    }

    /**
     * Kill its self
     */
    public void kill() {
        health = 0;
        isAlive = false;
    }

    /**
     * Adds ammo
     *
     * @param ammo amount to add
     */
    public void addAmmo(int ammo) { this.ammo += ammo; }

    public void addPlunder(int plunder) { this.plunder += plunder; }

    public void addXp(float xp) { this.xp += xp; this.updateXp(); }

    public int getAmmo() { return ammo; }

    public int getPlunder() { return plunder; }

    public float getXp() { return xp; }

    public int getLevel() { return level; }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }


    public int targetCount() {
        return targets.size();
    }

    public QueueFIFO<Ship> getTargets() {
        return targets;
    }
}
