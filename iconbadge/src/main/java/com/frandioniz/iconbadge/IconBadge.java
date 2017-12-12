package com.frandioniz.iconbadge;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.IntDef;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.joanzapata.iconify.widget.IconTextView;


public class IconBadge extends RelativeLayout {

    private Context mContext;
    private IconTextView mIconTV;
    private TextView mBadgeTV;

    private int mIconColor;
    private int mBadgeTextColor;
    private int mBadgeBackgroundColor;
    private int mBorderColor;
    private int mBorderWidth = 1;
    private int mBadgeNumber = -1;
    private int mBadgeCornersRadius = -1;
    private @BadgeDimen int mBadgeDimen = DIM_SMALL;
    private @BadgePosition int mBadgePosition = POS_TOP_RIGHT;

    public IconBadge(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public IconBadge(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
        initAttrs(attrs);
    }

    public IconBadge(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
        initAttrs(attrs);
    }

    private void init() {
        inflate(mContext, R.layout.icon_badge, this);
        mIconTV = findViewById(R.id.itv_icon);
        mBadgeTV = findViewById(R.id.tv_badge);

        mBorderWidth = DimenUtils.dpToPx(mContext, mBorderWidth);
        mIconColor = ContextCompat.getColor(mContext, android.R.color.holo_blue_light);
        mBadgeBackgroundColor = ContextCompat.getColor(mContext, android.R.color.holo_red_light);
        mBadgeTextColor = ContextCompat.getColor(mContext, android.R.color.white);
        mBorderColor = ContextCompat.getColor(mContext, android.R.color.white);
        setDimens(20, DIM_SMALL);
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray a = mContext.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.IconBadge,
                0, 0);

        try {
            String icon = a.getString(R.styleable.IconBadge_iconsrc);
            if (icon != null) {
                setIcon(icon);
            }
            setIconColorAttr(a.getColor(R.styleable.IconBadge_iconColor, mIconColor));
            String badgeNumber = a.getString(R.styleable.IconBadge_badgeNumber);
            if (badgeNumber != null) {
                setBadgeNumber(Integer.parseInt(badgeNumber));
            }
            setBadgeTextColorAttr(a.getColor(R.styleable.IconBadge_badgeTextColor, mBadgeTextColor));
            setBadgeBackgroundColorAttr(a.getColor(R.styleable.IconBadge_badgeBackgroundColor, mBadgeBackgroundColor));
            setBadgeBorderColorAttr(a.getColor(R.styleable.IconBadge_badgeBorderColor, mBorderColor));
            setBadgeBorderWidth((int) a.getDimension(R.styleable.IconBadge_badgeBorderWidth, (float) mBorderWidth));

            mBadgeCornersRadius = (int) a.getDimension(R.styleable.IconBadge_badgeCornersRadius, mBadgeCornersRadius);
            if (mBadgeCornersRadius != -1) {
                setBadgeCornersRadius(mBadgeCornersRadius);
            } else {
                int topLeftCornerRadius = (int) a.getDimension(R.styleable.IconBadge_badgeCornersRadiusTopLeft, 10);
                int topRightCornerRadius = (int) a.getDimension(R.styleable.IconBadge_badgeCornersRadiusTopRight, 10);
                int bottomLeftCornerRadius = (int) a.getDimension(R.styleable.IconBadge_badgeCornersRadiusBottomLeft, 10);
                int bottomRightCornerRadius = (int) a.getDimension(R.styleable.IconBadge_badgeCornersRadiusBottomRight, 10);
                setBadgeCornersRadius(topLeftCornerRadius, topRightCornerRadius, bottomRightCornerRadius, bottomLeftCornerRadius);
            }

            int iconDimen = (int) a.getDimension(R.styleable.IconBadge_iconDimen, 10);
            int badgeDimen = a.getInt(R.styleable.IconBadge_badgeDimen, 0);
            setDimens(iconDimen, badgeDimen);

            int badgePosition = a.getInt(R.styleable.IconBadge_badgePosition, 1);
            setBadgePosition(badgePosition);

        } finally {
            a.recycle();
        }
    }


    private void setIconColorAttr(int color) {
        mIconColor = color;
        mIconTV.setTextColor(color);
    }

    private void setBadgeTextColorAttr(int color) {
        mBadgeTextColor = color;
        mBadgeTV.setTextColor(color);
    }

    private void setBadgeBackgroundColorAttr(int color) {
        mBadgeBackgroundColor = color;
        DrawableUtils.changeBackgroundColor(mBadgeTV, color);
    }

    private void setBadgeBorderColorAttr(int color) {
        mBorderColor = color;
        DrawableUtils.changeBorderColor(mBadgeTV, mBorderColor, mBorderWidth);
    }

    /* Icon methods */
    public void setIcon(String icon) {
        mIconTV.setText(icon);
    }

    public void setIconColor(int color) {
        mIconColor = ContextCompat.getColor(mContext, color);
        mIconTV.setTextColor(mIconColor);
    }

    /* Badge methods */
    public void setBadgeNumber(int number) {
        mBadgeNumber = number;
        mBadgeTV.setText(Integer.toString(mBadgeNumber));
    }

    public int getBadgeNumber() {
        return mBadgeNumber;
    }

    public void setBadgeTextColor(int color) {
        mBadgeTextColor = ContextCompat.getColor(mContext, color);
        mBadgeTV.setTextColor(mBadgeTextColor);
    }

    public void setBadgeBackgroundColor(int color) {
        mBadgeBackgroundColor = ContextCompat.getColor(mContext, color);
        DrawableUtils.changeBackgroundColor(mBadgeTV, mBadgeBackgroundColor);
    }

    public void setBadgeBorderColor(int color) {
        mBorderColor = ContextCompat.getColor(mContext, color);
        DrawableUtils.changeBorderColor(mBadgeTV, mBorderColor, mBorderWidth);
    }

    public void setBadgeBorderWidth(int width) {
        mBorderWidth = DimenUtils.dpToPx(mContext, width);
        DrawableUtils.changeBorderColor(mBadgeTV, mBorderColor, mBorderWidth);
    }

    public void setBadgeCornersRadius(int radius) {
        mBadgeCornersRadius = radius;
        setBadgeCornersRadius(radius, radius, radius, radius);
    }

    public void setBadgeCornersRadius(int topLeft, int topRight, int bottomRight, int bottomLeft) {
        topLeft = DimenUtils.dpToPx(mContext, topLeft);
        topRight = DimenUtils.dpToPx(mContext, topRight);
        bottomRight = DimenUtils.dpToPx(mContext, bottomRight);
        bottomLeft = DimenUtils.dpToPx(mContext, bottomLeft);
        DrawableUtils.changeCornerRadius(mBadgeTV, topLeft, topRight, bottomRight, bottomLeft);
    }

    /* Both methods */
    public void setDimens(int iconDimen, @BadgeDimen int badgeDimen) {
        mBadgeDimen = badgeDimen;
        int pixels = DimenUtils.dpToPx(mContext, iconDimen);
        mIconTV.setTextSize(pixels);

        float percent = 0.2f;
        switch (badgeDimen) {
            case DIM_SMALL:
                percent = 0.2f;
                break;
            case DIM_REGULAR:
                percent = 0.3f;
                break;
            case DIM_BIG:
                percent = 0.4f;
                break;
        }
        int badgePixels = Math.round(pixels * percent);
        mBadgeTV.setTextSize(badgePixels);

        ViewTreeObserver vto = mBadgeTV.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    mBadgeTV.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    mBadgeTV.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                int width  = mBadgeTV.getMeasuredWidth();
                int height = mBadgeTV.getMeasuredHeight();
                mBadgeTV.setWidth(height);
            }
        });
    }

    public @BadgeDimen int getBadgeDimen() {
        return mBadgeDimen;
    }

    public void setBadgePosition(@BadgePosition int badgePosition) {
        mBadgePosition = badgePosition;
        RelativeLayout.LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        int[] verbs = new int[2];
        switch (badgePosition){
            case POS_TOP_LEFT:
                verbs[0] = ALIGN_LEFT;
                verbs[1] = ALIGN_TOP;
                break;
            case POS_TOP_RIGHT:
                verbs[0] = ALIGN_RIGHT;
                verbs[1] = ALIGN_TOP;
                break;
            case POS_BOTTOM_LEFT:
                verbs[0] = ALIGN_LEFT;
                verbs[1] = ALIGN_BOTTOM;
                break;
            case POS_BOTTOM_RIGHT:
                verbs[0] = ALIGN_RIGHT;
                verbs[1] = ALIGN_BOTTOM;
                break;
            default:
                verbs[0] = ALIGN_RIGHT;
                verbs[1] = ALIGN_TOP;
        }
        for (int verb : verbs) {
            params.addRule(verb, R.id.itv_icon);
        }
        mBadgeTV.setLayoutParams(params);
    }

    public @BadgePosition int getBadgePosition() {
        return mBadgePosition;
    }

    @IntDef({DIM_SMALL, DIM_REGULAR, DIM_BIG})
    @interface BadgeDimen {}

    public static final int DIM_SMALL = 0;
    public static final int DIM_REGULAR = 1;
    public static final int DIM_BIG = 2;


    @IntDef({POS_TOP_LEFT, POS_TOP_RIGHT, POS_BOTTOM_LEFT, POS_BOTTOM_RIGHT})
    @interface BadgePosition {}

    public static final int POS_TOP_LEFT = 0;
    public static final int POS_TOP_RIGHT = 1;
    public static final int POS_BOTTOM_LEFT = 2;
    public static final int POS_BOTTOM_RIGHT = 3;

}
