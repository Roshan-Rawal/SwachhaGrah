package com.roshan_rawal.swachhagraha;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends Activity {
    EditText user,password ;
    DatabaseHelper  helper;
   // String str2 = password.getText().toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        user = (EditText)findViewById(R.id.user);
        password = (EditText)findViewById(R.id.password);
        helper=new DatabaseHelper(this);
        Button login_btn = (Button) findViewById(R.id.Login);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    //Perform Login
                    performLogin(view);

            }
        });
        Button SignUp_btn = (Button) findViewById(R.id.SignUp);
        SignUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Perform SignUp
                SignUp(view);

            }
        });

    }
    private void SignUp(View v)
    {
        if(v.getId()== R.id.SignUp)
        {
            Intent i= new Intent(HomeActivity.this,SignUp.class);
            startActivity(i);
        }
    }
    private void performLogin(View v) {
        if (v.getId() == R.id.Login) {
            if (isFormValid()) {
                    int passValue = helper.searchPass(user.getText().toString().trim(),password.getText().toString().trim());
                if(passValue==1)
                {
                    Toast.makeText(this,"Congrats! "+user.getText().toString().trim()+" You have Successfully Logged in", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(HomeActivity.this,MainActivity.class);
                    startActivity(i);
                }
                else if(passValue==0)
                {
                    Toast.makeText(this,"Username  is incorrect", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(this,"Password is incorrect", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    private void showAlert(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }
    private Boolean isFormValid() {
        if (user.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please Enter the Username", Toast.LENGTH_LONG).show();
            return false;
        }
        if (password.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please Enter the Password", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }
}
