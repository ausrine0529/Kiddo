package com.example.edukacine2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TaskEndActivity extends AppCompatActivity {

    RadioGroup mGroup;
    Button toMenu;
    int kid_id;
    int questqntt;
    int correctAnsw;
    TextView resultMsg;
    String txtMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_end_activity);

        kid_id = Integer.valueOf(getIntent().getStringExtra("KID_ID"));
        questqntt = Integer.valueOf(getIntent().getStringExtra("questionsQntt"));
        correctAnsw = Integer.valueOf(getIntent().getStringExtra("correctAnsw"));

        toMenu = findViewById(R.id.goToMenu);
        mGroup = (RadioGroup) findViewById(R.id.atsakymai);
        resultMsg = findViewById(R.id.resultMsg);

        txtMsg = "Teisingai atsakei " + String.valueOf(correctAnsw) + " iš " + String.valueOf(questqntt);

        resultMsg.setText(txtMsg);

        toMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(TaskEndActivity.this, KidMenuActivity.class);
                I.putExtra("KID_ID", String.valueOf(kid_id));
                startActivity(I);
                finish();
            }
        });

    }

}
