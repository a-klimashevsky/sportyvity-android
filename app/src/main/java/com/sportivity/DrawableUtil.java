package com.sportivity;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.Shape;

/**
 * Created by Alex Klimashevsky on 13.12.2015.
 */
public class DrawableUtil {
    public static ShapeDrawable hex(){
        Path path = new Path();
        float stdW = 100;
        float stdH = 100;
        float w3 = stdW / 3;
        float h2 = stdH / 2;
        path.moveTo(0, h2);
        h2 -= 6 / 2;
        path.rLineTo(w3, -h2);         path.rLineTo(w3, 0); path.rLineTo(w3, h2);
        path.rLineTo(-w3, h2); path.rLineTo(-w3, 0); path.rLineTo(-w3, -h2);
        Shape s = new PathShape(path, stdW, stdH);
        ShapeDrawable d = new ShapeDrawable(s);
        Paint p = d.getPaint();
        p.setColor(0xff000000);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(6);

        return d;

    }
}
