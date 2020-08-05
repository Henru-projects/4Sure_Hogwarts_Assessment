package com.example.hogwartsinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HousesMain extends AppCompatActivity {
    //For House info:
    //https://www.potterapi.com/v1/houses?key=%242a%2410%241JEnmtEF417yBaFZcr51qukRjaKv8d5toEG5DKP%2FIUZWIVwfsaF7y


    Button loadHouses;
    public static TextView houseData;

    Button loadGryffindorMembers;
    Button loadSlytherinMembers;
    Button loadRavenclawMembers;
    Button loadHufflepuffMembers;

    public static TextView memberData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_houses_main);

        loadHouses = (Button) findViewById(R.id.btnLoadHouses);
        houseData = (TextView) findViewById(R.id.lblHouseData);

        loadHouses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchHouseData process = new fetchHouseData();
                process.execute();
            }
        });

        loadGryffindorMembers = (Button) findViewById(R.id.btnGryffindorMembers);
        memberData = (TextView) findViewById(R.id.lblMemberData);

        loadGryffindorMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchGryffMemberData process = new fetchGryffMemberData();
                process.execute();
            }
        });

        loadSlytherinMembers = (Button) findViewById(R.id.btnSlytherinMembers);
        loadSlytherinMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchSlythMemberData process = new fetchSlythMemberData();
                process.execute();
            }
        });

        loadRavenclawMembers = (Button) findViewById(R.id.btnRavenClawMembers);
        loadRavenclawMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchRavenMemberData process = new fetchRavenMemberData();
                process.execute();
            }
        });

        loadHufflepuffMembers = (Button) findViewById(R.id.btnHufflepuffMembers);
        loadHufflepuffMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchHuffleMemberData process = new fetchHuffleMemberData();
                process.execute();
            }
        });
    }
}
