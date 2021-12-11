package com.mygdx.game.Entitys;

import com.mygdx.game.Components.BoundingBox;
import com.mygdx.game.Components.Renderable;
import com.mygdx.game.Components.Transform;
import com.mygdx.game.Managers.RenderLayer;
import com.mygdx.utils.ResourceManager;

public class Enemy extends Entity {
    public Enemy() {
        super(3);

        Transform t = new Transform();
        t.setPosition(200, 200);
        addComponent(t);

        Renderable r = new Renderable(1, RenderLayer.Five);
        addComponent(r);

        BoundingBox bb = new BoundingBox(r, t);
        addComponent(bb);

    }
}