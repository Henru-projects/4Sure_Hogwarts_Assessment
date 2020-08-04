package com.example.hogwartsinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpellsMain extends AppCompatActivity {
    //https://www.potterapi.com/v1/spells?key=$2a$10$1JEnmtEF417yBaFZcr51qukRjaKv8d5toEG5DKP/IUZWIVwfsaF7y
    Button loadSpells;
    public static TextView spellData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spells_main);

        loadSpells = (Button) findViewById(R.id.btnLoadSpells);
        spellData = (TextView) findViewById(R.id.lblSpellData);

        loadSpells.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchSpellData process = new fetchSpellData();
                process.execute();
            }
        });
    }
}
