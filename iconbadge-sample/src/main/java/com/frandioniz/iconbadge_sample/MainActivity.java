package com.frandioniz.iconbadge_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.frandioniz.iconbadge.IconBadge;
import com.joanzapata.iconify.widget.IconTextView;

public class MainActivity extends AppCompatActivity {

    private IconTextView[] btn = new IconTextView[4];
    private IconTextView btn_unfocus;
    private int[] btn_id = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3};
    private int unfocusColor;
    private IconBadge iconBadge;
    private Button mSwitchBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iconBadge = findViewById(R.id.iconbadge);

        // Seekbar
        SeekBar seekBar = findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                iconBadge.setDimens(i, iconBadge.getBadgeDimen());
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
                            break;

                        case R.id.btn1 :
                            setFocus(btn_unfocus, btn[1]);
                            iconBadge.setBadgePosition(IconBadge.POS_TOP_RIGHT);
                            break;

                        case R.id.btn2 :
                            setFocus(btn_unfocus, btn[2]);
                            iconBadge.setBadgePosition(IconBadge.POS_BOTTOM_LEFT);
                            break;

                        case R.id.btn3 :
                            setFocus(btn_unfocus, btn[3]);
                            iconBadge.setBadgePosition(IconBadge.POS_BOTTOM_RIGHT);
                            break;
                    }
                }
            });
        }

        btn_unfocus = btn[0];
        setFocus(btn_unfocus, btn[iconBadge.getBadgePosition()]);

        mSwitchBTN = findViewById(R.id.btn_switch);
        mSwitchBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iconBadge.setIcon("{fa-heart}");
                iconBadge.setIconColor(R.color.colorBlue);
                iconBadge.setBadgePosition(IconBadge.POS_TOP_LEFT);
                iconBadge.setBadgeNumber(1);
                iconBadge.setDimens(30, IconBadge.DIM_BIG);
                iconBadge.setBadgeTextColor(android.R.color.white);
                iconBadge.setBadgeBorderColor(android.R.color.white);
                iconBadge.setBadgeBorderWidth(2);
                iconBadge.setBadgeBackgroundColor(R.color.colorOrange);
                iconBadge.setBadgeCornersRadius(200);
            }
        });
    }

    private void setFocus(IconTextView btn_unfocus, IconTextView btn_focus){
        btn_unfocus.setTextColor(unfocusColor);
        btn_focus.setTextColor(getResources().getColor(R.color.colorAccent));
        this.btn_unfocus = btn_focus;
    }
}
