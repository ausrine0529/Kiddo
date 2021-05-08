package com.example.edukacine2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AdminMenuActivity extends AppCompatActivity {

    Button skirti;
    Button vertintiUz;
    Button zenkliukas;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_menu_activity);

        skirti = (Button)findViewById(R.id.skirtiUzd);
        vertintiUz = (Button) findViewById(R.id.vertinti);
        zenkliukas = (Button) findViewById(R.id.skirtiZenkl);
        logout = findViewById(R.id.logout2);

        skirti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(AdminMenuActivity.this, TaskGenerationActivity.class);
                startActivity(I);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(AdminMenuActivity.this, MainActivity.class);
                startActivity(I);
            }
        });

        zenkliukas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(AdminMenuActivity.this, GiveStickerActivity.class);
                startActivity(I);
            }
        });

        vertintiUz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(AdminMenuActivity.this, AdminResultActivity.class);
                startActivity(I);
            }
        });

    }
}
