package com.example.hogwartsinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //Vars
    Animation topAnimate;
    ImageView img;

    private static int SPLASH_SCREEN = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animations
        topAnimate = AnimationUtils.loadAnimation(this, R.anim.top_animation);

        //Hooks
        img = findViewById(R.id.imgHogwartsLogo);

        img.setAnimation(topAnimate);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, MainScreen.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}
