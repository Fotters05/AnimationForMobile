package com.example.praka1;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private ImageView img;
    private Button startBtn;
    private Button pauseBtn;
    private Button backBtn;
    private Animation scaleDownAnimation;
    private Animation shakeLeftRightAnimation;
    private Animation pulseAnimation;
    private Animation blinkAnimation;
    private boolean isBlinking = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        img = findViewById(R.id.img_blink);
        startBtn = findViewById(R.id.startButton);
        pauseBtn = findViewById(R.id.pauseButton);
        backBtn = findViewById(R.id.backButton);

        scaleDownAnimation = AnimationUtils.loadAnimation(this, R.anim.button_scale_down);
        shakeLeftRightAnimation = AnimationUtils.loadAnimation(this, R.anim.shake_left_right);
        pulseAnimation = AnimationUtils.loadAnimation(this, R.anim.pulse_animation);
        blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.blink_animation);


        final int colorFrom = Color.RED;
        final int colorTo = Color.GREEN;
        final ValueAnimator colorAnimator = ValueAnimator.ofObject(new android.animation.ArgbEvaluator(), colorFrom, colorTo);
        colorAnimator.setDuration(300);

        colorAnimator.addUpdateListener(animator -> {
            int color = (int) animator.getAnimatedValue();
            pauseBtn.setBackgroundColor(color);
        });

        startBtn.setOnClickListener(v -> {

            startBtn.startAnimation(scaleDownAnimation);
            if (!isBlinking) {
                img.startAnimation(blinkAnimation);
                isBlinking = true;
            }
        });

        pauseBtn.setOnClickListener(v -> {
            colorAnimator.start();
            if (isBlinking) {
                img.clearAnimation();
                isBlinking = false;
            }
        });

        backBtn.setOnClickListener(v -> {
            backBtn.startAnimation(pulseAnimation);
            v.postDelayed(() -> finish(), pulseAnimation.getDuration());
        });
    }
}
