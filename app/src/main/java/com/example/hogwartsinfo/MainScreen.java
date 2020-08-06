package com.example.hogwartsinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainScreen extends AppCompatActivity {
    //Vars
    ImageButton houseBtnClick;
    ImageButton spellsBtnClick;
    ImageButton studentBtnClick;
    ImageButton sortingHatBtnClick;
    TextView sortingHatResult;
    private long backPressTime;
    private Toast backToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_screen);

        houseBtnClick = (ImageButton) findViewById(R.id.btnHouses);
        spellsBtnClick = (ImageButton) findViewById(R.id.btnSpells);
        studentBtnClick = (ImageButton) findViewById(R.id.btnStudents);
        sortingHatBtnClick = (ImageButton) findViewById(R.id.btnSortingHat);
        sortingHatResult = (TextView) findViewById(R.id.lblSortingHatResult);

        houseBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openHousesMain();

            }
        });

        sortingHatBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortingHatAnim();
                sortingHatGenerator();

            }
        });

        spellsBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSpellsMain();

            }
        });

        studentBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStudentMain();

            }
        });
    }

    public void sortingHatGenerator(){
        String[] houseNames = {"Griffindor", "Slytherin", "Raven Claw", "Huffle Puff"};
        Random random = new Random();
        final int rando = random.nextInt(4);
        sortingHatResult.setText(houseNames[rando]);
    }
    private void sortingHatAnim(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        sortingHatResult.startAnimation(animation);
    }

    public void openHousesMain(){
        Intent intent = new Intent(MainScreen.this, HousesMain.class);
        startActivity(intent);
    }

    public void openSpellsMain(){
        Intent intent = new Intent(MainScreen.this, SpellsMain.class);
        startActivity(intent);
    }

    public void openStudentMain(){
        Intent intent = new Intent(MainScreen.this, StudentMain.class);
        startActivity(intent);
    }
    //double click to exit
    @Override
    public void onBackPressed() {

        if(backPressTime + 2000 > System.currentTimeMillis())
        {
            backToast.cancel();
            super.onBackPressed();
            return;
        }else{
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressTime = System.currentTimeMillis();
    }
}
