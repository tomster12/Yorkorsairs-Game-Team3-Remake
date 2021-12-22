package com.mygdx.game.Entitys;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Components.*;
import com.mygdx.game.Managers.RenderLayer;
import com.mygdx.game.Physics.PhysicsBodyType;

public class Player extends Ship {
    public Player(){
        super();
    }

    /**
     * The player
     * @param id sprite texture id
     * @param speed speed of movement
     */
    public Player(int id, float speed){
        super();

        PlayerController pc = new PlayerController(this, speed);
        addComponent(pc);

        setName("Player");
    }

    @Override
    public void cleanUp() {
        super.cleanUp();
    }


    public Vector2 getPos(){
        return getComponent(Transform.class).getPosition();
    }
    public void setPos(Vector2 pos){
        getComponent(Transform.class).setPosition(pos);
    }
}
