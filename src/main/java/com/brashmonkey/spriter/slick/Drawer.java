package com.brashmonkey.spriter.slick;


import com.brashmonkey.spriter.Timeline;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * Created by Trixt0r on 01.12.2016.
 */
public class Drawer extends com.brashmonkey.spriter.Drawer<Image> {

    private GameContainer gc;
    private Graphics graphics;

    public Drawer(final GameContainer gc, Loader loader) {
        super(loader);
        this.gc = gc;
        this.graphics = gc.getGraphics();
    }

    @Override
    public void setColor(float r, float g, float b, float a) {
    }

    @Override
    public void line(float x1, float y1, float x2, float y2) {
    }

    @Override
    public void rectangle(float x, float y, float width,  float height) {
    }

    @Override
    public void circle(float x, float y, float radius) {
    }

    @Override
    public void draw(Timeline.Key.Object object) {
        Image image = loader.get(object.ref);
        // Avoid NullPointerExceptions
        if (image == null) return;
        float newPivotX = (image.getWidth() * object.pivot.x);
        float newX = object.position.x - newPivotX*object.scale.x;

        float newPivotY = (image.getHeight() * object.pivot.y);
        float newY = (gc.getHeight() - object.position.y) - (image.getHeight() - newPivotY)*object.scale.y;

        graphics.rotate(object.position.x, (gc.getHeight() - object.position.y), - object.angle);
        image.setAlpha(object.alpha);
        image.draw(newX, newY,image.getWidth()*object.scale.x,image.getHeight()*object.scale.y);
        graphics.resetTransform();
    }
}
