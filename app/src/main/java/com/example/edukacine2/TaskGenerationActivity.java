package com.example.edukacine2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TaskGenerationActivity extends AppCompatActivity {
    DBHelper DB;
    String kid_username;
    int quantity;
    int type;
    int level;
    private Spinner uzduotiesTipas;
    private Spinner uzdKiekis;
    private Spinner vaikas;
    private Spinner sunkumoLvl;
    Button back;

    String[] uzduotis = new String[] {
            "Suskaičiuok", "Atpažink žodžius", "Atpažink spalvas"
    };
    String[] kiekis = new String[] {
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
    };

    String[] lygis = new String[] {
            "1 lygis", "2 lygis", "3 lygis"
    };


    Button skirti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_generation_activity);
        List<String> kidsNameList = new ArrayList<>();
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(TaskGenerationActivity.this, AdminMenuActivity.class);
                startActivity(I);
                finish();
            }
        });

        uzduotiesTipas = findViewById(R.id.taskSpinner);
        Spinner s = (Spinner) findViewById(R.id.taskSpinner);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, uzduotis);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter2);

        uzdKiekis = findViewById(R.id.kiekis);
        Spinner s2 = (Spinner) findViewById(R.id.kiekis);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, kiekis);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter3);

        vaikas = findViewById(R.id.vaikas);
        List<User> kidsList = gautiVaikuSarasa();
        Spinner s6 = (Spinner) findViewById(R.id.vaikas);
        for (int i =0; i<kidsList.size(); i++ ){
            kidsNameList.add(kidsList.get(i).getUsername());
        }
        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, kidsNameList);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s6.setAdapter(adapter6);

        sunkumoLvl = findViewById(R.id.lygis);
        Spinner s4 = (Spinner) findViewById(R.id.lygis);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lygis);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s4.setAdapter(adapter5);

        skirti = findViewById(R.id.skirtiUzd2);

        skirti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DB = new DBHelper(TaskGenerationActivity.this);
                kid_username = vaikas.getSelectedItem().toString();
                quantity = Integer.parseInt(uzdKiekis.getSelectedItem().toString());
                if(uzduotiesTipas.getSelectedItem().toString().equals("Suskaičiuok")){
                    type = 1;
                }
                else if (uzduotiesTipas.getSelectedItem().toString().equals("Atpažink žodžius")){
                    type = 2;
                }
                else if (uzduotiesTipas.getSelectedItem().toString().equals("Atpažink spalvas")){
                    type = 3;
                }

                if(sunkumoLvl.getSelectedItem().toString().equals("1 lygis")){
                    level = 1;
                }
                else if (sunkumoLvl.getSelectedItem().toString().equals("2 lygis")){
                    level = 2;
                }
                else if (sunkumoLvl.getSelectedItem().toString().equals("3 lygis")){
                    level = 3;
                }
                Boolean taskSended;
                Task task = new Task(-1, type, quantity, level, kid_username, false);
                taskSended = DB.skirtiUzduoti(task);

                Intent I = new Intent(TaskGenerationActivity.this, TaskGenerationSuccessActivity.class);
                startActivity(I);
            }
        });
    }


    public List<User> gautiVaikuSarasa () {
        DBHelper dbHelper = new DBHelper(TaskGenerationActivity.this);
        List<User> sarasas = new ArrayList<>();
        sarasas = dbHelper.returnKidsList2();
        return sarasas;
    }
}
