package com.example.edukacine2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TaskPerformActivity extends AppCompatActivity implements View.OnClickListener {

    Button next;
    TextView questionTxt;
    ImageView image;
    TextView answ1;
    TextView answ2;
    TextView answ3;
    int currentPosition = 1;
    List<Question> questionsList = null;
    int selectedPosition = 0;
    int correctAnswers = 0;
    int kid_id;
    int task_id;
    DBHelper DB;
    String username;
    int taskLevel;
    String taskType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_perform_activity);

        kid_id = Integer.valueOf(getIntent().getStringExtra("KID_ID"));
        DBHelper db = new DBHelper(TaskPerformActivity.this);
        username = db.getKidUsernameById(kid_id);
        List<Task> tasks = db.getKidUndoneTask(username);
        task_id = tasks.get(0).getTask_id();
        taskLevel = tasks.get(0).getLevel();
        if(tasks.get(0).getType() == 1){
            taskType = "Suskaičiuok";
        }
        else if (tasks.get(0).getType() == 2){
            taskType = "Atpažink žodžius";
        }
        else if (tasks.get(0).getType() == 3){
            taskType = "Atpažink spalvas";
        }

        if(tasks.get(0).level == 1 && tasks.get(0).type == 1){
            questionsList = Constants.getType1Lvl1(tasks.get(0).questquantitiy);
        }
        else if (tasks.get(0).level == 1 && tasks.get(0).type ==2){
            questionsList = Constants.getType2Lvl1(tasks.get(0).questquantitiy);
        }
        else if (tasks.get(0).level == 1 && tasks.get(0).type ==3){
            questionsList = Constants.getType3Lvl1(tasks.get(0).questquantitiy);
        }
        else if (tasks.get(0).level == 2 && tasks.get(0).type ==1){
            questionsList = Constants.getType1Lvl2(tasks.get(0).questquantitiy);
        }
        else if (tasks.get(0).level == 2 && tasks.get(0).type ==2){
            questionsList = Constants.getType2Lvl2(tasks.get(0).questquantitiy);
        }
        else if (tasks.get(0).level == 2 && tasks.get(0).type ==3){
            questionsList = Constants.getType3Lvl2(tasks.get(0).questquantitiy);
        }
        else if (tasks.get(0).level == 3 && tasks.get(0).type ==1){
            questionsList = Constants.getType1Lvl3(tasks.get(0).questquantitiy);
        }
        else if (tasks.get(0).level == 3 && tasks.get(0).type ==2){
            questionsList = Constants.getType2Lvl3(tasks.get(0).questquantitiy);
        }
        else if (tasks.get(0).level == 3 && tasks.get(0).type ==3){
            questionsList = Constants.getType3Lvl3(tasks.get(0).questquantitiy);
        }

        setQuestion();

        answ1.setOnClickListener(this);
        answ2.setOnClickListener(this);
        answ3.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    private void answerView(int answer, int drawableView){
        if (answer == 1){
            answ1.setBackground(ContextCompat.getDrawable(this, drawableView));
        }
        if (answer == 2){
            answ2.setBackground(ContextCompat.getDrawable(this, drawableView));
        }
        if (answer == 3){
            answ3.setBackground(ContextCompat.getDrawable(this, drawableView));
        }
    }

    private void setQuestion(){

        Question quest = questionsList.get(currentPosition-1);


        questionTxt = findViewById(R.id.questionTxt);
        image = findViewById(R.id.imageView2);
        answ1 = findViewById(R.id.answerTxt1);
        answ2 = findViewById(R.id.answerTxt2);
        answ3 = findViewById(R.id.answerTxt3);
        next = findViewById(R.id.next);

        answ1.setText(quest.getOption1());
        answ2.setText(quest.getOption2());
        answ3.setText(quest.getOption3());

        defaultOptionsView();

        if (currentPosition == questionsList.size()+1){
            next.setText("Baigti");
        }
        else{
            next.setText("Atsakyti");
        }

        questionTxt.setText(quest.getQuestion_txt());
        image.setImageResource(quest.getImage());
    }

    private void defaultOptionsView(){
        List<TextView> options = new ArrayList<TextView>();
        options.add(0, answ1);
        options.add(1, answ2);
        options.add(2, answ3);

        for (TextView o : options){
            o.setTextColor(Color.parseColor("#7A8089"));
            o.setTypeface(Typeface.DEFAULT);
            o.setBackground(ContextCompat.getDrawable(this, R.drawable.default_option));
        }

    }

    @Override
    public void onClick(View v) {
        if (v==answ1){
            selectedOptionView(answ1, 1);
        }
        if (v==answ2){
            selectedOptionView(answ2, 2);
        }
        if (v==answ3){
            selectedOptionView(answ3, 3);
        }
        if (v==next){
            if(selectedPosition == 0){
                currentPosition++;

                if(currentPosition <= questionsList.size()){
                    setQuestion();
                }
                else{
                    DB = new DBHelper(TaskPerformActivity.this);

                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date();
                    String date2 = formatter.format(date);

                    Result rez = new Result(-1, kid_id, username, taskType, taskLevel, task_id, correctAnswers, questionsList.size(), date2);
                    DB.atliktiUzduoti(rez);

                    Intent I = new Intent(TaskPerformActivity.this, TaskEndActivity.class);
                    I.putExtra("KID_ID", String.valueOf(kid_id));
                    I.putExtra("questionsQntt", String.valueOf(questionsList.size()));
                    I.putExtra("correctAnsw", String.valueOf(correctAnswers));
                    startActivity(I);

                    Toast.makeText(getApplicationContext(),
                            "Uzduotis atlikta",Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Question question = questionsList.get(currentPosition-1);
                if(question.getCorrectAnsw()!= selectedPosition){
                    answerView(selectedPosition, R.drawable.incorrect_option);
                }
                else{
                    correctAnswers++;
                }
                answerView(question.getCorrectAnsw(), R.drawable.correct_option);

                if(currentPosition == questionsList.size()){
                    next.setText("Baigti");
                }
                else{
                    next.setText("Toliau");
                }
                selectedPosition = 0;
            }
        }

    }

    private void selectedOptionView(TextView txtVw, int selectedOption){
        defaultOptionsView();
        selectedPosition = selectedOption;

        txtVw.setTextColor(Color.parseColor("#363A43"));
        txtVw.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        txtVw.setBackground(ContextCompat.getDrawable(this, R.drawable.selected_option));
    }
}
