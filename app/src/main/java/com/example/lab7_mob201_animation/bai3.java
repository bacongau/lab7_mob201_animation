package com.example.lab7_mob201_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class bai3 extends AppCompatActivity {
    ImageView hour, min, sec;
    Button button;
    float m = 0, h = 0;
    int dem = 0;
    ObjectAnimator animation, animation2, animation3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);

        hour = findViewById(R.id.imageView_b3_hour);
        min = findViewById(R.id.imageView_b3_minute);
        sec = findViewById(R.id.imageView_b3_second);
        button = findViewById(R.id.button_b3_run);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dem++;
                m = 0;
                h = 0;
                animation = ObjectAnimator.ofFloat(sec, "rotation", 0f, 360f);
                animation.setDuration(200);
                animation.setRepeatCount(39600);
                animation.start();

                ///////
                animation.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                        m += 6f;
                        animation2 = ObjectAnimator.ofFloat(min, "rotation", m);
                        animation2.setDuration(100);
                        animation2.start();
                        animation2.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {

                                h += 0.5f;
                                animation3 = ObjectAnimator.ofFloat(hour, "rotation", h);
                                animation3.setDuration(100);
                                animation3.start();

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
                ////////
                if (dem > 1) {
                    animation.end();
                    animation3.end();
                    animation2.end();
                }

            }
        });
    }
}