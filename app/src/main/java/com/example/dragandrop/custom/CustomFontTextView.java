package com.example.dragandrop.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by mjovanovic on 13.03.14..
 */
public abstract class CustomFontTextView extends TextView {

    private Context ctx;

    public CustomFontTextView(Context context) {
        super(context);
        this.ctx = context;
        init();
    }

    public CustomFontTextView(Context context, AttributeSet a) {
        super(context, a);
        this.ctx = context;
        init();
    }

    public CustomFontTextView(Context ctx, AttributeSet a, int d){
        super(ctx, a, d);
        this.ctx = ctx;
        init();
    }

    private void init() {
        this.setTypeface(FontCache.getFont(this.ctx, getFontName()));
    }

    @Override
    public void setTypeface(Typeface tf){
        super.setTypeface(tf);
    }

    public abstract String getFontName();
}
