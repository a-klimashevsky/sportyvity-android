package com.sportivity;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.CornerPathEffect;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.ViewDebug;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by Alex Klimashevsky on 23.12.2015.
 */
public class Color1Drawable extends Drawable {
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    @ViewDebug.ExportedProperty(deepExport = true, prefix = "state_")
    private ColorState mColorState;

    private Path hexagonPath;
    private float mWidth=-1, mHeight=-1;
    private int mBackgroundColor;
    private int mStrokeColor;
    private int mStrokeWidth;

    private PorterDuffColorFilter mTintFilter;

    private boolean mMutated;

    /**
     * Creates a new black ColorDrawable.
     */
    public Color1Drawable() {
        mColorState = new ColorState();

        init();
    }

    private void init() {
        hexagonPath = new Path();
        mBackgroundColor = Color.BLUE;
        mStrokeColor = Color.GREEN;
        mStrokeWidth = 4;
    }

    /**
     * Creates a new ColorDrawable with the specified color.
     *
     * @param color The color to draw.
     */
    public Color1Drawable(@ColorInt int color) {
        mColorState = new ColorState();

        setColor(color);

        init();
    }

    @Override
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | mColorState.getChangingConfigurations();
    }

    /**
     * A mutable BitmapDrawable still shares its Bitmap with any other Drawable
     * that comes from the same resource.
     *
     * @return This drawable.
     */
    @Override
    public Drawable mutate() {
        if (!mMutated && super.mutate() == this) {
            mColorState = new ColorState(mColorState);
            mMutated = true;
        }
        return this;
    }

    /**
     * @hide
     */
    public void clearMutated() {
       // super.clearMutated();
        mMutated = false;
    }

    private void calculatePath() {
        float p = mStrokeWidth / 2;
        float w = mWidth - 2 * p;
        float h = mHeight - 2 * p;
        float r = h / 2;
        float a = (float) (r / Math.sqrt(3));
        float d = w- 2*p - 2*a;
        PointF X = new PointF(p + a + d/3, p);
        PointF Y = new PointF(p + a + d/2 , p);
        PointF A = new PointF(p + a, p + 0f);
        PointF B = new PointF(p + 0f, p + r);
        PointF C = new PointF(p + a, p + 2 * r);
        PointF D = new PointF(p + w - a, p + 2 * r);
        PointF E = new PointF(p + w, p + r);
        PointF F = new PointF(p + w - a, p + 0);
        hexagonPath.moveTo(Y.x, Y.y);
        hexagonPath.lineTo(A.x, A.y);
        hexagonPath.lineTo(B.x, B.y);
        hexagonPath.lineTo(C.x, C.y);
        hexagonPath.lineTo(D.x, D.y);
        hexagonPath.lineTo(E.x, E.y);
        hexagonPath.lineTo(F.x, F.y);
        hexagonPath.lineTo(X.x, X.y);
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        mWidth = bounds.width();
        mHeight = bounds.height();
        calculatePath();
    }

    @Override
    public void draw(Canvas canvas) {

       /* final ColorFilter colorFilter = mPaint.getColorFilter();
        if ((mColorState.mUseColor >>> 24) != 0 || colorFilter != null || mTintFilter != null) {
            if (colorFilter == null) {
                mPaint.setColorFilter(mTintFilter);
            }

            mPaint.setColor(mColorState.mUseColor);
            canvas.drawRect(getBounds(), mPaint);

            // Restore original color filter.
            mPaint.setColorFilter(colorFilter);
        }*/

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(mStrokeColor);                    // set the color
        paint.setStrokeWidth(mStrokeWidth);               // set the size
        paint.setDither(true);                    // set the dither to true
        paint.setStyle(Paint.Style.STROKE);       // set to STOKE
        paint.setStrokeJoin(Paint.Join.ROUND);    // set the join to round you want
        paint.setStrokeCap(Paint.Cap.ROUND);      // set the paint cap to round too
        paint.setPathEffect(new CornerPathEffect(mStrokeWidth));   // set the path effect when they join.
        paint.setAntiAlias(true);
        canvas.drawPath(hexagonPath, paint);
        canvas.clipPath(hexagonPath, Region.Op.REPLACE);
        canvas.drawColor(mBackgroundColor);
        canvas.drawPath(hexagonPath, paint);

    }

    /**
     * Gets the drawable's color value.
     *
     * @return int The color to draw.
     */
    @ColorInt
    public int getColor() {
        return mColorState.mUseColor;
    }

    /**
     * Sets the drawable's color value. This action will clobber the results of
     * prior calls to {@link #setAlpha(int)} on this object, which side-affected
     * the underlying color.
     *
     * @param color The color to draw.
     */
    public void setColor(@ColorInt int color) {
        if (mColorState.mBaseColor != color || mColorState.mUseColor != color) {
            mColorState.mBaseColor = mColorState.mUseColor = color;
            invalidateSelf();
        }
    }

    /**
     * Returns the alpha value of this drawable's color.
     *
     * @return A value between 0 and 255.
     */
    @Override
    public int getAlpha() {
        return mColorState.mUseColor >>> 24;
    }

    /**
     * Sets the color's alpha value.
     *
     * @param alpha The alpha value to set, between 0 and 255.
     */
    @Override
    public void setAlpha(int alpha) {
        alpha += alpha >> 7;   // make it 0..256
        final int baseAlpha = mColorState.mBaseColor >>> 24;
        final int useAlpha = baseAlpha * alpha >> 8;
        final int useColor = (mColorState.mBaseColor << 8 >>> 8) | (useAlpha << 24);
        if (mColorState.mUseColor != useColor) {
            mColorState.mUseColor = useColor;
            invalidateSelf();
        }
    }

    /**
     * Sets the color filter applied to this color.
     * <p>
     * Only supported on version {@link android.os.Build.VERSION_CODES#LOLLIPOP} and
     * above. Calling this method has no effect on earlier versions.
     *
     * @see android.graphics.drawable.Drawable#setColorFilter(ColorFilter)
     */
    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public void setTintList(ColorStateList tint) {
        mColorState.mTint = tint;
        //mTintFilter = updateTintFilter(mTintFilter, tint, mColorState.mTintMode);
        invalidateSelf();
    }

    @Override
    public void setTintMode(PorterDuff.Mode tintMode) {
        mColorState.mTintMode = tintMode;
        //mTintFilter = updateTintFilter(mTintFilter, mColorState.mTint, tintMode);
        invalidateSelf();
    }

    @Override
    protected boolean onStateChange(int[] stateSet) {
        final ColorState state = mColorState;
        if (state.mTint != null && state.mTintMode != null) {
            //mTintFilter = updateTintFilter(mTintFilter, state.mTint, state.mTintMode);
            return true;
        }
        return false;
    }

    @Override
    public boolean isStateful() {
        return mColorState.mTint != null && mColorState.mTint.isStateful();
    }

    @Override
    public int getOpacity() {
        if (mTintFilter != null || mPaint.getColorFilter() != null) {
            return PixelFormat.TRANSLUCENT;
        }

        switch (mColorState.mUseColor >>> 24) {
            case 255:
                return PixelFormat.OPAQUE;
            case 0:
                return PixelFormat.TRANSPARENT;
        }
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public void getOutline(@NonNull Outline outline) {
        outline.setRect(getBounds());
        outline.setAlpha(getAlpha() / 255.0f);
    }

    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme)
            throws XmlPullParserException, IOException {
        super.inflate(r, parser, attrs, theme);
    }

    /**
     * Updates the constant state from the values in the typed array.
     */
    private void updateStateFromTypedArray(TypedArray a) {

    }

    @Override
    public boolean canApplyTheme() {
        return mColorState.canApplyTheme() || super.canApplyTheme();
    }

    @Override
    public void applyTheme(Resources.Theme t) {
        super.applyTheme(t);
    }

    @Override
    public ConstantState getConstantState() {
        return mColorState;
    }

    final static class ColorState extends ConstantState {
        int[] mThemeAttrs;
        int mBaseColor; // base color, independent of setAlpha()
        @ViewDebug.ExportedProperty
        int mUseColor;  // basecolor modulated by setAlpha()
        int mChangingConfigurations;
        ColorStateList mTint = null;
        PorterDuff.Mode mTintMode = PorterDuff.Mode.ADD;

        ColorState() {
            // Empty constructor.
        }

        ColorState(ColorState state) {
            mThemeAttrs = state.mThemeAttrs;
            mBaseColor = state.mBaseColor;
            mUseColor = state.mUseColor;
            mChangingConfigurations = state.mChangingConfigurations;
            mTint = state.mTint;
            mTintMode = state.mTintMode;
        }

        @Override
        public boolean canApplyTheme() {
            return false;
        }

        @Override
        public Drawable newDrawable() {
            return new Color1Drawable(this, null);
        }

        @Override
        public Drawable newDrawable(Resources res) {
            return new Color1Drawable(this, res);
        }

        @Override
        public int getChangingConfigurations() {
            return mChangingConfigurations
                    | (mTint != null ? mTint.getChangingConfigurations() : 0);
        }
    }

    private Color1Drawable(ColorState state, Resources res) {
        mColorState = state;

        updateLocalState(res);

        init();
    }

    /**
     * Initializes local dynamic properties from state. This should be called
     * after significant state changes, e.g. from the One True Constructor and
     * after inflating or applying a theme.
     */
    private void updateLocalState(Resources r) {
       //mTintFilter = updateTintFilter(mTintFilter, mColorState.mTint, mColorState.mTintMode);
    }
}
