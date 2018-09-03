package com.roshan_rawal.swachhagraha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends Activity {
    EditText username,Email,Password,RePassword;
    DatabaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sign_up);
        username = (EditText) findViewById(R.id.username);
        Email = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.Password);
        RePassword = (EditText) findViewById(R.id.RePassword);
        helper = new DatabaseHelper(this);
        Button SignUp = (Button) findViewById(R.id.SignUp);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (formValid()) {
                    PerformSignUp();

                }
            }
        });
    }
    private void PerformSignUp() {

        int check = helper.checkMail(Email.getText().toString().trim());
        if (check == 0) {
            Toast.makeText(this, "Email is already registered", Toast.LENGTH_LONG).show();
        }
        else {
            boolean isInsert = helper.insertData(username.getText().toString().trim(), Email.getText().toString().trim(), Password.getText().toString().trim());
            if (isInsert) {
                Toast.makeText(this, "Congrats! " + username.getText().toString().trim() + " You have Successfully Registered in", Toast.LENGTH_LONG).show();
                Intent i = new Intent(SignUp.this, MainActivity.class);
                startActivity(i);
            } else {
                Toast.makeText(this, "Data is not inserted", Toast.LENGTH_LONG).show();
            }
        }
    }

    private Boolean formValid()
    {
            if(username.getText().toString().trim().isEmpty())
            {
                Toast.makeText(this,"Please enter the Username", Toast.LENGTH_LONG).show();
                return false;
            }
            if(Email.getText().toString().trim().isEmpty())
            {
                Toast.makeText(this,"Please enter the Email", Toast.LENGTH_LONG).show();
                return false;
            }
            if(!(Patterns.EMAIL_ADDRESS.matcher(Email.getText().toString().trim()).matches()))
            {
                Toast.makeText(this,"Please enter the valid Email", Toast.LENGTH_LONG).show();
                return false;
            }
            if (Password.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "Please Enter the Password", Toast.LENGTH_LONG).show();
                return false;
            }
            if (RePassword.getText().toString().trim().isEmpty())
            {
                Toast.makeText(this,"Please Re Enter the Password", Toast.LENGTH_LONG).show();
                return false;
            }
            if(!(Password.getText().toString().trim().equals(RePassword.getText().toString().trim())))
            {
                Toast.makeText(this,"Password does not match", Toast.LENGTH_LONG).show();
                return false;

            }
        return true;
        }
    }

