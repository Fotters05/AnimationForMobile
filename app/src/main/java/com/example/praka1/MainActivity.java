package com.example.praka1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonOne;
    private Button buttonTwo;
    private Animation rotateAnimation;
    private Animation scaleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonOne = findViewById(R.id.button_one);
        buttonTwo = findViewById(R.id.button_two);


        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_animation);
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_animation);


        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buttonOne.startAnimation(rotateAnimation);


                v.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                    }
                }, rotateAnimation.getDuration());
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buttonTwo.startAnimation(scaleAnimation);

                v.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                        startActivity(intent);
                    }
                }, scaleAnimation.getDuration());
            }
        });
    }
}
