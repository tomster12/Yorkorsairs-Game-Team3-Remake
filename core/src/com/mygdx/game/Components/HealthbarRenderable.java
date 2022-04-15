package com.mygdx.game.Components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Managers.RenderLayer;
import com.mygdx.game.Managers.RenderingManager;
import com.mygdx.game.Managers.ResourceManager;

/**
 * Add the ability for the object to be shown
 */
public class HealthbarRenderable extends Renderable {

    private Sprite fillSprite;

    private float value;
    private float maxValue;


    public HealthbarRenderable(RenderLayer layer) {
        super(ResourceManager.getId("healthbar.png"), layer);
        fillSprite = new Sprite(ResourceManager.getTexture(ResourceManager.getId("healthbarfill.png")));
        sprite.setOrigin(sprite.getWidth() * 0.5f, sprite.getHeight() * 0.5f);
        fillSprite.setOrigin(fillSprite.getWidth() * 0.5f, fillSprite.getHeight() * 0.5f);
    }


    @Override
    public void update() {
        super.update();

        if (sprite == null) return;
        if (fillSprite == null) return;
        Transform c = parent.getComponent(Transform.class);
        if (c == null) return;
        Vector2 p = c.getPosition();
        Vector2 s = c.getScale();

        sprite.setOriginBasedPosition(p.x, p.y);
        fillSprite.setOriginBasedPosition(p.x, p.y);
        fillSprite.setRotation(MathUtils.radiansToDegrees * c.getRotation());
        fillSprite.setScale((value / maxValue) * s.x, s.y);

        if (value == 0) {
            fillSprite.setColor(Color.BLACK);
            fillSprite.setScale(s.x, s.y);

        } else {
            fillSprite.setColor(Color.WHITE);
            fillSprite.setScale((value / maxValue) * s.x, s.y);
        }
    }


    @Override
    public void render() {
        super.render();

        if (sprite == null || !isVisible) return;
        fillSprite.draw(RenderingManager.getBatch());
    }


    public void setValue(float value) { this.value = value; }

    public void setMaxValue(float value) { this.maxValue = value; }
}