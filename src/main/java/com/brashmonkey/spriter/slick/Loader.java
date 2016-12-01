package com.brashmonkey.spriter.slick;

import com.brashmonkey.spriter.Data;
import com.brashmonkey.spriter.FileReference;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created by Trixt0r on 01.12.2016.
 */
public class Loader extends com.brashmonkey.spriter.Loader<Image> {

    public Loader(Data data) {
        super(data);
    }

    @Override
    protected Image loadResource(FileReference ref) {
        Image img = null;
        try {
            img = new Image(super.root + "/" + data.getFile(ref).name);
        } catch (SlickException e) {
            e.printStackTrace();
        } finally {
            return img;
        }
    }
}
