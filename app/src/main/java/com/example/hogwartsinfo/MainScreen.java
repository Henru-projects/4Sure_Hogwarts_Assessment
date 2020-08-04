package com.example.hogwartsinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class MainScreen extends AppCompatActivity {
    //Vars
    ImageButton houseBtnClick;
    ImageButton spellsBtnClick;
    ImageButton studentBtnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_screen);

        houseBtnClick = (ImageButton) findViewById(R.id.btnHouses);
        spellsBtnClick = (ImageButton) findViewById(R.id.btnSpells);
        studentBtnClick = (ImageButton) findViewById(R.id.btnStudents);

        houseBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openHousesMain();

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

    public void clickExit(View v){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
