package com.example.dragandrop.custom;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by mjovanovic on 13.03.14..
 */
public class RobotoTextView extends CustomFontTextView {


    public RobotoTextView(Context context, AttributeSet a) {
        super(context, a);
    }

    @Override
    public String getFontName() {
        return "Roboto-Thin";
    }
}
