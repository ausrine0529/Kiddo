package com.example.edukacine2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class GiveStickerActivity extends AppCompatActivity {

    private Spinner vaikas;
    Button skirti;
    Button atgal;
    DBHelper DB;
    String kid_username;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.give_sticker_activity);

        atgal = findViewById(R.id.backbtn);
        List<String> kidsNameList = new ArrayList<>();

        atgal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(GiveStickerActivity.this, AdminMenuActivity.class);
                startActivity(I);
                finish();
            }
        });

        vaikas = findViewById(R.id.vaikasZenkl);
        Spinner s3 = (Spinner) findViewById(R.id.vaikasZenkl);

        List<User> kidsList = gautiVaikuSarasa();

        for (int i =0; i<kidsList.size(); i++ ){
            kidsNameList.add(kidsList.get(i).getUsername());
        }

        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,
                R.layout.my_spinner, kidsNameList);

        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s3.setAdapter(adapter4);
        kid_username = vaikas.getSelectedItem().toString();
        skirti = findViewById(R.id.skirtiZenkl);

        skirti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB = new DBHelper(GiveStickerActivity.this);
                Boolean stickerSended;
                kid_username = vaikas.getSelectedItem().toString();
                stickerSended = DB.pridetiZenkliuka(kid_username);
                Toast.makeText(getApplicationContext(),
                        "Ženkliukas buvo skirtas",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public List<User> gautiVaikuSarasa () {
        DBHelper dbHelper = new DBHelper(GiveStickerActivity.this);
        List<User> sarasas = new ArrayList<>();
        sarasas = dbHelper.returnKidsList2();
        return sarasas;
    }
}
