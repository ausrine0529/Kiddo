package com.example.edukacine2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AdminResultActivity extends AppCompatActivity {

    Button grizti;
    ListView listView;
    public static List<Result> allResultList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_result_activity);
        grizti = findViewById(R.id.griztiRez);
        DBHelper db = new DBHelper(AdminResultActivity.this);
        allResultList = db.getAllResults();
        listView = findViewById(R.id.kidsRezList);

        setupList();
        initSearch();
        setupOnClickListener();

        grizti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(AdminResultActivity.this, AdminMenuActivity.class);
                startActivity(I);
                finish();
            }
        });
    }

    private void initSearch(){
        SearchView searchview = (SearchView) findViewById(R.id.search);

        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<Result> filteredResult = new ArrayList<Result>();

                for (Result rez: allResultList){
                    if (rez.getUsername().toLowerCase().contains(s.toLowerCase())){
                        filteredResult.add(rez);
                    }
                }
                ResultAdapter adapter = new ResultAdapter(getApplicationContext(), 0, filteredResult);
                listView.setAdapter(adapter);

                return false;
            }
        });
    }

    private void setupList(){
        ResultAdapter adapter = new ResultAdapter(getApplicationContext(), 0, allResultList);
        listView.setAdapter(adapter);
    }

    private void setupOnClickListener(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Result selectedRez = (Result) (listView.getItemAtPosition(position));
                Intent i = new Intent(getApplicationContext(), ResultDetailActivity.class);
                i.putExtra("id", String.valueOf(selectedRez.getResult_id()));
                i.putExtra("name", selectedRez.getUsername());
                i.putExtra("type", selectedRez.getTaskType());
                i.putExtra("level",  String.valueOf(selectedRez.getLevel()));
                i.putExtra("correct",  String.valueOf(selectedRez.getCorrectAnsw()));
                i.putExtra("quantity",  String.valueOf(selectedRez.getQuestionQntt()));
                i.putExtra("date",  String.valueOf(selectedRez.getDate()));
                startActivity(i);
            }
        });
    }

}
