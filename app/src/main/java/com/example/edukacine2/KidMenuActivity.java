package com.example.edukacine2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class KidMenuActivity extends AppCompatActivity {

    Button atlikti;
    Button profilis;
    Button logout;
    String kid_id;
    String username;
    List<Task> tasks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("KID_ID");
        }
        setContentView(R.layout.kid_menu_activity);

        atlikti = findViewById(R.id.atliktiUzd);
        profilis = findViewById(R.id.skirtiZenkl);
        logout = findViewById(R.id.logout);

        DBHelper db = new DBHelper(KidMenuActivity.this);
        kid_id = getIntent().getStringExtra("KID_ID");
        username = db.getKidUsernameById(Integer.valueOf(kid_id));
        tasks = db.getKidUndoneTask(username);

        atlikti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tasks.size()<1){
                    Toast.makeText(getApplicationContext(),
                            "Naujų užduotėlių dar neturi",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent I = new Intent(KidMenuActivity.this, TaskPerformActivity.class);
                    I.putExtra("KID_ID", kid_id);
                    startActivity(I);
                }
            }
        });

        profilis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(KidMenuActivity.this, StickersActivity.class);
                I.putExtra("KID_ID", String.valueOf(kid_id));
                startActivity(I);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(KidMenuActivity.this, MainActivity.class);
                startActivity(I);
            }
        });
    }
}
