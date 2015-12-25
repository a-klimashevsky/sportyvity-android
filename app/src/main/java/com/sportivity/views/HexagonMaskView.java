package com.sportivity.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Alex Klimashevsky on 13.12.2015.
 */
public class HexagonMaskView extends View {
    private Path hexagonPath;
    private float mWidth, mHeight;
    private int mBackgroundColor;
    private int mStrokeColor;
    private int mStrokeWidth;

    public HexagonMaskView(Context context) {
        super(context);
        init();
    }

    public HexagonMaskView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HexagonMaskView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        hexagonPath = new Path();
        mBackgroundColor = 0xFF01FF77;
        mStrokeColor = Color.GREEN;
        mStrokeWidth = 30;
    }

    public void setBackgroundColor(int color) {
        mBackgroundColor = color;
        invalidate();
    }

    public void setStrokeWidth(int width) {
        mStrokeWidth = width;
        invalidate();
    }

    public void setStrokeColor(int color) {
        mStrokeColor = color;
        invalidate();
    }

    private void calculatePath() {
        float p = mStrokeWidth / 2;
        float w = mWidth - 2 * p;
        float h = mHeight - 2 * p;
        float r = h / 2;
        float a = (float) (r / Math.sqrt(3));
        PointF X = new PointF(p + a + r / 2, p);
        PointF A = new PointF(p + a, p + 0f);
        PointF B = new PointF(p + 0f, p + r);
        PointF C = new PointF(p + a, p + 2 * r);
        PointF D = new PointF(p + w - a, p + 2 * r);
        PointF E = new PointF(p + w, p + r);
        PointF F = new PointF(p + w - a, p + 0);
        hexagonPath.moveTo(X.x, X.y);
        hexagonPath.lineTo(A.x, A.y);
        hexagonPath.lineTo(B.x, B.y);
        hexagonPath.lineTo(C.x, C.y);
        hexagonPath.lineTo(D.x, D.y);
        hexagonPath.lineTo(E.x, E.y);
        hexagonPath.lineTo(F.x, F.y);
        hexagonPath.lineTo(X.x, X.y);

        invalidate();
    }

    @Override
    public void onDraw(Canvas c) {
        super.onDraw(c);

        Paint paint = new Paint();
        paint.setColor(mStrokeColor);                    // set the color
        paint.setStrokeWidth(mStrokeWidth);               // set the size
        paint.setDither(true);                    // set the dither to true
        paint.setStyle(Paint.Style.STROKE);       // set to STOKE
        paint.setStrokeJoin(Paint.Join.ROUND);    // set the join to round you want
        paint.setStrokeCap(Paint.Cap.ROUND);      // set the paint cap to round too
        paint.setPathEffect(new CornerPathEffect(mStrokeWidth));   // set the path effect when they join.
        paint.setAntiAlias(true);
        c.drawPath(hexagonPath, paint);
        c.clipPath(hexagonPath, Region.Op.INTERSECT);
        c.drawColor(mBackgroundColor);
        c.drawPath(hexagonPath, paint);
        c.save();
    }

    // getting the view size and default radius
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
        calculatePath();
    }
}