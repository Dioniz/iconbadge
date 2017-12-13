package com.frandioniz.iconbadge;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;


public final class DrawableUtils {

    public static void changeBackgroundColor(View view, int color) {
        Drawable background = view.getBackground().mutate();
        if (background instanceof ShapeDrawable) {
            ((ShapeDrawable)background).getPaint().setColor(color);
        } else if (background instanceof GradientDrawable) {
            ((GradientDrawable)background).setColor(color);
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable)background).setColor(color);
        }
    }

    public static void changeBorderColor(View view, int color, int stroke) {
        Drawable background = view.getBackground().mutate();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable)background).setStroke(stroke, color);
        }
    }

    public static void changeCornerRadius(View view, int topLeft, int topRight, int bottomRight, int bottomLeft) {
        Drawable background = view.getBackground().mutate();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable)background).setCornerRadii(new float[]{topLeft, topLeft,
                                                                      topRight, topRight,
                                                                      bottomRight, bottomRight,
                                                                      bottomLeft, bottomLeft});
        }
    }
}
