package com.example.edukacine2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResultDetailActivity extends AppCompatActivity {

    Result selectedRez;
    Button back;
    Button send;
    DBHelper DB;
    String name;
    String type;
    String level;
    String correct;
    String quantity;
    String date;
    String id;
    int taskType2;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_detail_activity);

        back = findViewById(R.id.backButton);
        send = findViewById(R.id.skirti);

        Intent i = getIntent();
        id = i.getStringExtra("id");
        name = i.getStringExtra("name");
        type = i.getStringExtra("type");
        level = i.getStringExtra("level");
        correct = i.getStringExtra("correct");
        quantity = i.getStringExtra("quantity");
        date = i.getStringExtra("date");

        if(type.equals("Suskaičiuok")){
            taskType2 = 1;
        }
        else if (type.equals("Atpažink žodžius")){
            taskType2 = 2;
        }
        else if (type == "Atpažink spalvas"){
            taskType2 = 3;
        }


        TextView kidName = (TextView) findViewById(R.id.kidUsername);
        TextView taskId = (TextView) findViewById(R.id.taskid);
        final TextView taskType = (TextView) findViewById(R.id.tasktype);
        TextView tvlevel = (TextView) findViewById(R.id.tasklevel);
        TextView tvcorrect = (TextView) findViewById(R.id.correctans);
        TextView tvquantity = (TextView) findViewById(R.id.questquant);
        TextView tvdate = (TextView) findViewById(R.id.performdate);


        kidName.setText(name);
        taskId.setText(id);
        taskType.setText(type);
        tvlevel.setText(level);
        tvcorrect.setText(correct);
        tvquantity.setText(quantity);
        tvdate.setText(date);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(ResultDetailActivity.this, AdminResultActivity.class);
                startActivity(I);
                finish();
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Task task = new Task(-1, taskType2, Integer.valueOf(quantity), Integer.valueOf(level), name, false);
                Boolean taskSended;
                DB = new DBHelper(ResultDetailActivity.this);
                taskSended = DB.skirtiUzduoti(task);
                if (taskSended){
                    Toast.makeText(getApplicationContext(),
                            "Užduotis buvo skirta",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),
                            "Nenumatyta klaida",Toast.LENGTH_SHORT).show();
                }

            }
        });

        long percent = Math.round(Double.valueOf(correct)/Double.valueOf(quantity)*100);

        if(percent>=50){
            send.setText("Skirti ženkliuką");
            send.setBackgroundColor(Color.parseColor("#90EE90"));

            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DB = new DBHelper(ResultDetailActivity.this);
                    Boolean stickerSended;
                    stickerSended = DB.pridetiZenkliuka(name);
                    if(stickerSended){
                        Toast.makeText(getApplicationContext(),
                                "Ženkliukas buvo skirtas",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else{
            send.setBackgroundColor(Color.parseColor("#FF1493"));
            send.setText("Siųsti sugeneruotą užduotį");
        }
    }

}
