package com.example.edukacine2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GiveStickerSuccessActivity extends AppCompatActivity {

    Button grizti;
    Button skirti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.give_sticker_success_activity);
        skirti = findViewById(R.id.grizti2);
        grizti = findViewById(R.id.backtoMenu);


        skirti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(GiveStickerSuccessActivity.this, TaskGenerationActivity.class);
                startActivity(I);
                finish();
            }
        });

        grizti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(GiveStickerSuccessActivity.this, AdminMenuActivity.class);
                startActivity(I);
                finish();
            }
        });
    }
}
