package com.example.edukacine2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StickersActivity extends AppCompatActivity {

    GridView gridview;
    String kid_id;
    Sticker stickers = new Sticker();
    int quantity;
    Button back;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stickers_activity);

        DBHelper dbHelper = new DBHelper(StickersActivity.this);
        kid_id = getIntent().getStringExtra("KID_ID");
        stickers = dbHelper.getKidStickers(Integer.valueOf(kid_id));
        quantity = stickers.getSticker_ID();
        back = findViewById(R.id.atgalIVaikoMenu);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(StickersActivity.this, KidMenuActivity.class);
                I.putExtra("KID_ID", kid_id);
                startActivity(I);
                finish();
            }
        });

        gridview = (GridView) findViewById(R.id.stickersGrid);
        gridview.setAdapter(new ImageAdapter(this, quantity));

    }
}
