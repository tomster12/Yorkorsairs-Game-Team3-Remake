package com.mygdx.game.Quests;

import com.mygdx.game.Entitys.Player;

/**
 * Base class for all quests facilitates the checking of completion
 */
public abstract class Quest {
    protected String name;
    protected String description;
    protected boolean isCompleted;
    protected int plunderReward;
    protected int xpReward;
    protected int ammoReward;

    public Quest() {
        name = "";
        description = "";
        plunderReward = 0;
        xpReward = 0;
        ammoReward = 0;
        isCompleted = false;
    }

    /**
     * Checks if the given player has met the complete condition
     *
     * @param p the player
     * @return has completed
     */
    public abstract boolean checkCompleted(Player p);

    public boolean isCompleted() {
        return isCompleted;
    }

    public int getPlunderReward() {
        return plunderReward;
    }

    public int getXpReward() {
        return xpReward;
    }

    public int getAmmoReward() {
        return ammoReward;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
