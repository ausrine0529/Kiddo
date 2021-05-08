package com.example.edukacine2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.List;
import at.favre.lib.crypto.bcrypt.BCrypt;

public class MainActivity extends Activity  {
    Button login,close, addUser;
    EditText username,pwd;
    DBHelper DB;
    int ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button)findViewById(R.id.loginBtn);
        pwd = (EditText)findViewById(R.id.passwordField);
        username = (EditText)findViewById(R.id.userNameField);
        close = (Button)findViewById(R.id.exit);
        addUser = (Button)findViewById(R.id.newAdmin);
        DB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputName = username.getText().toString();
                String inputPassword = pwd.getText().toString();
                Boolean checkUserPass;
                String acctype;


                if (inputName.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),
                            "Įveskite prsijungimo duomenis",Toast.LENGTH_SHORT).show();
                }

                else if (!inputName.isEmpty() && !inputPassword.isEmpty()){

                    List<User> users = DB.checkUserPassword(inputName);
                    if(users!=null && users.size()>0){
                        String passwordhash = users.get(0).getPwdhash();
                        acctype = users.get(0).getType();
                        ID = users.get(0).getID();
                        BCrypt.Result result = BCrypt.verifyer().verify(inputPassword.toCharArray(), passwordhash);
                        if (result.verified) {
                            checkUserPass = true;
                        }
                        else{
                            checkUserPass = false;
                        }
                        if (checkUserPass && acctype.equals("Auklėtoja")){
                            Toast.makeText(getApplicationContext(),
                                    "Jungiama į auklėtojo meniu",Toast.LENGTH_SHORT).show();
                            Intent I = new Intent(MainActivity.this, AdminMenuActivity.class);
                            startActivity(I);

                        }
                        else if (checkUserPass && acctype.equals("Vaikas")){
                            Toast.makeText(getApplicationContext(),
                                    "Jungiama į vaiko meniu",Toast.LENGTH_SHORT).show();
                            Intent I2 = new Intent(MainActivity.this, KidMenuActivity.class);
                            I2.putExtra("KID_ID", String.valueOf(ID));
                            startActivity(I2);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),
                                    "Blogi prisijungimo duomenys",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(),
                                "Blogi prisijungimo duomenys",Toast.LENGTH_SHORT).show();
                    }
                }

                else if(username.getText().toString().equals("admin") &&
                        pwd.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Jungiama...",Toast.LENGTH_SHORT).show();
                    Intent I = new Intent(MainActivity.this, AdminMenuActivity.class);
                    startActivity(I);
                }
                else if (username.getText().toString().equals("vaikas") &&
                        pwd.getText().toString().equals("vaikas")) {
                    Toast.makeText(getApplicationContext(),
                            "Jungiama...",Toast.LENGTH_SHORT).show();
                    Intent I = new Intent(MainActivity.this, KidMenuActivity.class);
                    startActivity(I);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Blogi prisijungimo duomenys",Toast.LENGTH_SHORT).show();
                }
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addUser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent I = new Intent(MainActivity.this, AddUserActivity.class);
                startActivity(I);
            }
        });
    }
}