package com.mygdx.game.Entitys;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Components.HealthbarRenderable;
import com.mygdx.game.Components.Renderable;
import com.mygdx.game.Components.Transform;
import com.mygdx.game.Managers.RenderLayer;
import com.mygdx.game.Managers.ResourceManager;

/**
 * Entity to show the amount of health
 */
public class Healthbar extends Entity {

    private HealthbarRenderable hr;

    private Vector2 offset = new Vector2(0.0f, 0.0f);


    public Healthbar(RenderLayer layer) {
        super(2);
        Transform t = new Transform();
        HealthbarRenderable hr = new HealthbarRenderable(layer);
        addComponents(t, hr);
        this.hr = hr;
    }


    public void setPosition(Vector2 pos) { getComponent(Transform.class).setPosition(pos.cpy().add(offset)); }

    public void setScale(float x, float y) { getComponent(Transform.class).setScale(x, y); }

    public void setOffset(Vector2 offset_) { offset = offset_; }

    public void setValue(float value) { hr.setValue(value); }
    public void setMaxValue(float value) { hr.setMaxValue(value); }
}
