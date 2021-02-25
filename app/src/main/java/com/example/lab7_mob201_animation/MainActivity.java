package com.example.lab7_mob201_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button button_rotation,button_moving,button_zoom,button_sangbai2;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_moving = findViewById(R.id.button_b1_moving);
        button_rotation = findViewById(R.id.button_b1_rotation);
        button_zoom = findViewById(R.id.button_b1_zoom);
        button_sangbai2 = findViewById(R.id.button_sangbai2);
        imageView = findViewById(R.id.imageView_b1);

        button_rotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dest = 360;
                if (imageView.getRotation() == 360){
                    dest = 0;
                }
                ObjectAnimator animator = ObjectAnimator.ofFloat(imageView,"rotation",dest);
                animator.setDuration(2000);
                animator.setRepeatMode(ValueAnimator.REVERSE);
                animator.start();
            }
        });

        button_zoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.zoom);
                imageView.startAnimation(animation);
            }
        });

        button_moving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    ObjectAnimator animation = ObjectAnimator.ofFloat(imageView, "translationX", 0f,1000f);
                    animation.setDuration(2000);
                    animation.start();
                    animation.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            ObjectAnimator animation2 = ObjectAnimator.ofFloat(imageView, "translationX", 1000f,0f);
                            animation2.setDuration(2000);
                            animation2.start();
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
            }
        });

        button_sangbai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,bai2.class));
            }
        });


    }
}