package com.example.edukacine2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class AddUserActivity extends AppCompatActivity {

    Button register,back;
    EditText username,pwd, pwd2;
    DBHelper DB;
    RadioGroup type;
    String selectedType = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        register = (Button)findViewById(R.id.registerBtn);
        pwd = (EditText)findViewById(R.id.passwordField);
        pwd2 = (EditText)findViewById(R.id.passwordField2);
        username = (EditText)findViewById(R.id.userNameField);
        type = (RadioGroup) findViewById(R.id.typeRadio);
        back = (Button)findViewById(R.id.exit);
        DB = new DBHelper(this);


        type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.teacherRadio:
                        selectedType = "Auklėtoja";

                        break;
                    case R.id.kidRadio:
                        selectedType = "Vaikas";
                        break;
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = username.getText().toString();
                String inputPassword = pwd.getText().toString();
                String inputPassword2 = pwd2.getText().toString();
                String hashedPwd;
                Boolean checkName;

                hashedPwd = hashPassword(inputPassword);

                User user = new User(-1, inputName, hashedPwd, selectedType, true);

                if (inputName.isEmpty() || inputPassword.isEmpty() || inputPassword2.isEmpty() || selectedType == null)
                {
                    Toast.makeText(getApplicationContext(),
                            "Įveskite reikiamus duomenis",Toast.LENGTH_SHORT).show();
                }

                else if (!inputName.isEmpty() && !inputPassword.isEmpty() &&  !inputPassword2.isEmpty() && selectedType!=null) {
                    if (inputPassword.length()<6){
                        Toast.makeText(getApplicationContext(),
                                "Slaptažodis per trumpas",Toast.LENGTH_SHORT).show();
                    }
                    else if (inputPassword.equals(inputPassword2)){
                        checkName  = DB.checkUsername(inputName);
                        if (!checkName){
                            DBHelper dbHelper = new DBHelper(AddUserActivity.this);
                            dbHelper.pridetiNaudotoja(user);
                            Toast.makeText(getApplicationContext(),
                                    "Naudotojas užregistruotas sėkmingai",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),
                                    "Toks vartotojas jau egzistuoja!",Toast.LENGTH_SHORT).show();
                        }
                    }

                    else {
                        Toast.makeText(getApplicationContext(),
                                "Slaptažodžiai nesutampa!",Toast.LENGTH_SHORT).show();
                    }

                }

                username.getText().clear();
                pwd.getText().clear();
                pwd2.getText().clear();
                type.clearCheck();
            }
        });

    }

    public String hashPassword(String password){
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        return bcryptHashString;
    }

}