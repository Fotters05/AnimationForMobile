package com.example.praka1;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private ImageView animatoinIV;
    private Button startBnt;
    private Button pauseBnt;
    private Button backBnt;
    private Animation fadeAnimation;
    private Animation scaleDownAnimation;
    private Animation blinkAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        animatoinIV = findViewById(R.id.animImageView);
        startBnt = findViewById(R.id.startButton);
        pauseBnt = findViewById(R.id.pauseButton);
        backBnt = findViewById(R.id.backButton);

        fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_animation);
        scaleDownAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_down_animation);
        blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.blink_animation);

        startBnt.setOnClickListener(v -> {
            if (animatoinIV.getDrawable() instanceof AnimationDrawable) {
                AnimationDrawable frameAnimation = (AnimationDrawable) animatoinIV.getDrawable();
                if (!frameAnimation.isRunning()) {
                    frameAnimation.start();
                }
            }
            startBnt.startAnimation(fadeAnimation);
        });

        pauseBnt.setOnClickListener(v -> {
            if (animatoinIV.getDrawable() instanceof AnimationDrawable) {
                AnimationDrawable frameAnimation = (AnimationDrawable) animatoinIV.getDrawable();
                if (frameAnimation.isRunning()) {
                    frameAnimation.stop();
                }
            }
            pauseBnt.startAnimation(scaleDownAnimation);
        });

        backBnt.setOnClickListener(v -> {
            finish();
            backBnt.startAnimation(blinkAnimation);
        });
    }
}
