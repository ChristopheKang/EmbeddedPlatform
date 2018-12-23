package com.example.neiris.embeddedplatform;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText editTxtName;
    EditText editTxtSurname;
    EditText editTxtMail;
    EditText editTxtPassword;
    Button signupBtn;
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTxtName = (EditText)findViewById(R.id.editTextName);

        editTxtSurname = (EditText)findViewById(R.id.editTextSurname);

        editTxtMail = (EditText)findViewById(R.id.editTextMail);

        editTxtPassword = (EditText)findViewById(R.id.editTextPassword);

        signupBtn = (Button)findViewById(R.id.buttonSignup2);
    }



    public void onSignUpClick(View v){
        if(v.getId() == R.id.buttonSignup2)
        {


            String namestr = editTxtName.getText().toString();
            String emailstr = editTxtMail.getText().toString();
            String pass1str = editTxtPassword.getText().toString();
            String surnstr = editTxtSurname.getText().toString();


            //insert the details in DB:
             Contact c = new Contact();
             c.setName(namestr);
             c.setEmail(emailstr);
             c.setPass(pass1str);
             c.setUname(surnstr);

             helper.insertContact(c);

            startActivity(new Intent(this, MainActivity.class));


        }
    }

}
