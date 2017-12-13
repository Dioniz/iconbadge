package com.frandioniz.iconbadge_sample;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.frandioniz.iconbadge.IconBadge;
import com.joanzapata.iconify.widget.IconTextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private IconTextView[] btn = new IconTextView[4];
    private IconTextView btn_unfocus;
    private int[] btn_id = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3};
    private int unfocusColor;
    private IconBadge iconBadge, iconBadge2;
    private Button mSwitchBTN;

    private String[] icons = {"{fa-heart}", "{ion-alert-circled}", "{md-email}", "{wi_day_sunny}"};
    private int[] colors = {R.color.colorBlue, R.color.colorRed, R.color.colorGreen, R.color.colorOrange, R.color.colorYellow};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iconBadge = findViewById(R.id.iconbadge);
        iconBadge2 = findViewById(R.id.iconbadge2);

        iconBadge2.setIcon("{fa-heart}");
        //iconBadge2.setIcon(R.drawable.ic_launcher_background);
        iconBadge2.setIconColor(R.color.colorBlue);
        iconBadge2.setBadgePosition(IconBadge.POS_TOP_LEFT);
        iconBadge2.setBadgeNumber(1);
        iconBadge2.setDimens(20, IconBadge.DIM_REGULAR);
        iconBadge2.setBadgeTextColor(android.R.color.white);
        iconBadge2.setBadgeBorderColor(android.R.color.white);
        iconBadge2.setBadgeBorderWidth(2);
        iconBadge2.setBadgeBackgroundColor(R.color.colorOrange);
        iconBadge2.setBadgeCornersRadius(200);
        iconBadge2.setBadgeCornersRadius(5, 5, 200, 200);

        // Seekbar
        SeekBar seekBar = findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                iconBadge.setDimens(i, iconBadge.getBadgeDimen());
                iconBadge2.setDimens(i, iconBadge2.getBadgeDimen());
                ((TextView) findViewById(R.id.tv_seekbar_progress)).setText("Dimens: " + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Buttons
        for(int i = 0; i < btn.length; i++){
            btn[i] = (IconTextView) findViewById(btn_id[i]);
            unfocusColor = btn[i].getCurrentTextColor();
            btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()){
                        case R.id.btn0 :
                            setFocus(btn_unfocus, btn[0]);
                            iconBadge.setBadgePosition(IconBadge.POS_TOP_LEFT);
                            iconBadge2.setBadgePosition(IconBadge.POS_TOP_LEFT);
                            break;

                        case R.id.btn1 :
                            setFocus(btn_unfocus, btn[1]);
                            iconBadge.setBadgePosition(IconBadge.POS_TOP_RIGHT);
                            iconBadge2.setBadgePosition(IconBadge.POS_TOP_RIGHT);
                            break;

                        case R.id.btn2 :
                            setFocus(btn_unfocus, btn[2]);
                            iconBadge.setBadgePosition(IconBadge.POS_BOTTOM_LEFT);
                            iconBadge2.setBadgePosition(IconBadge.POS_BOTTOM_LEFT);
                            break;

                        case R.id.btn3 :
                            setFocus(btn_unfocus, btn[3]);
                            iconBadge.setBadgePosition(IconBadge.POS_BOTTOM_RIGHT);
                            iconBadge2.setBadgePosition(IconBadge.POS_BOTTOM_RIGHT);
                            break;
                    }
                }
            });
        }

        btn_unfocus = btn[0];
        setFocus(btn_unfocus, btn[iconBadge.getBadgePosition()]);

        mSwitchBTN = findViewById(R.id.btn_switch);
        final Random random = new Random(SystemClock.currentThreadTimeMillis());
        mSwitchBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int iconPos = random.nextInt(icons.length);
                int colorPos = random.nextInt(colors.length);
                iconBadge2.setIcon(icons[iconPos]);
                //iconBadge2.setIcon(R.drawable.ic_launcher_background);
                iconBadge2.setIconColor(colors[colorPos]);
                iconBadge2.setBadgePosition(iconBadge2.getBadgePosition());
                iconBadge2.setBadgeNumber(1);
                iconBadge2.setDimens(iconBadge2.getIconDimen(), IconBadge.DIM_SMALL);
                iconBadge2.setBadgeTextColor(android.R.color.white);
                iconBadge2.setBadgeBorderColor(android.R.color.white);
                iconBadge2.setBadgeBorderWidth(2);
                colorPos = random.nextInt(colors.length);
                iconBadge2.setBadgeBackgroundColor(colors[colorPos]);
                iconBadge2.setBadgeCornersRadius(200);
                iconBadge2.setBadgeCornersRadius(5, 5, 200, 200);
            }
        });
    }

    private void setFocus(IconTextView btn_unfocus, IconTextView btn_focus){
        btn_unfocus.setTextColor(unfocusColor);
        btn_focus.setTextColor(getResources().getColor(R.color.colorAccent));
        this.btn_unfocus = btn_focus;
    }
}
