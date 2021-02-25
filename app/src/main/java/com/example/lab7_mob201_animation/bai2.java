package com.example.lab7_mob201_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class bai2 extends AppCompatActivity {
    Button button_all,button_dora,button_nobita,button_sangbai3;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        imageView = findViewById(R.id.imageView_b2);
        button_all = findViewById(R.id.button_b2_all);
        button_dora = findViewById(R.id.button_b2_doremon);
        button_nobita = findViewById(R.id.button_b2_nobita);
        button_sangbai3 = findViewById(R.id.button_sangbai3);

        button_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage("All");
            }
        });

        button_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage("All");
            }
        });

        button_nobita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage("nobita");
            }
        });

        button_dora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage("doremon");
            }
        });

        button_sangbai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(bai2.this,bai3.class));
            }
        });
    }

    private void showImage(String a) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(imageView,"translationX",0f,500f);
        anim.setDuration(2000);
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(imageView,"alpha",1f,0f);
        anim1.setDuration(2000);

        ObjectAnimator anim2 = ObjectAnimator.ofFloat(imageView,"translationX",-500f,0f);
        anim.setDuration(2000);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(imageView,"alpha",0f,1f);
        anim1.setDuration(2000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(anim2).with(anim3).after(anim).after(anim1);
        animatorSet.start();

        final String imgName = a;
        anim1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (imgName == "nobita"){
                    imageView.setImageResource(R.drawable.nobita);
                }
                if (imgName == "doremon"){
                    imageView.setImageResource(R.drawable.doraemon);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }
}