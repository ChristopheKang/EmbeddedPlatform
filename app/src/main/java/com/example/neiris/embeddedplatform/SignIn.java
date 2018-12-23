package com.example.neiris.embeddedplatform;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    final Context context = this;
    EditText editTxtUser;
    EditText editTxtPassword;

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editTxtUser = (EditText)findViewById(R.id.editTextUser);

        editTxtPassword = (EditText)findViewById(R.id.editTextPassword);





    }


    public void onSigninClick(View v){
        if(v.getId() == R.id.buttonSignIn2)
        {
            String str = editTxtUser.getText().toString();
            String pass = editTxtPassword.getText().toString();

            String password = helper.searchPass(str);
            if(pass.equals(password))
            {
                Intent i = new Intent(SignIn.this, Lobby.class);
                startActivity(i);
            }
            else{//popup msg:
                Toast temp = Toast.makeText(SignIn.this, "username & passwords don't match", Toast.LENGTH_LONG);
                temp.show();}
        }

    }

}
