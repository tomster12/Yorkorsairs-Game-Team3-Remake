package com.mygdx.game.Entitys;

import com.badlogic.gdx.math.Vector2;
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
import java.util.concurrent.TimeUnit;

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
        double selector = Math.random();
        for (Ship ship : ships){
            EventManager.powerupRemove = 1;
            if (selector <= 0.2){
                int hp = ship.getMaxHealth();
                int chp = ship.getHealth();
                int newHealth = hp + 5;
                ship.increaseMaxHealth(newHealth);
                int difference = newHealth - chp;
                int addhp = difference * (-1);
                ship.takeDamage(addhp);
            }else if ((selector > 0.2) && (selector <= 0.4)){
                int hp = ship.getMaxHealth();
                int chp = ship.getHealth();
                if (hp == chp){
                    ship.takeDamage(10);
                }else{
                    int difference = hp - chp;
                    int addhp = difference * -1;
                    ship.takeDamage(addhp);
                }
            }else if ((selector > 0.4) && (selector <= 0.6)){
                double plun = Math.random() * 25;
                ship.plunder((int) plun);
            }else if ((selector > 0.6) && (selector <= 0.8)){
                double negplun = Math.random() * -5;
                int negplun2 = (int) negplun;
                ship.plunder(negplun2);
            }else{
                ship.level(100);

            }

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
    public void ExitTrigger(CollisionInfo info){
        ships.remove((Ship) info.a);
    }
}
