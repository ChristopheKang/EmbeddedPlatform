package com.example.neiris.embeddedplatform;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignIn extends AppCompatActivity {

    final Context context = this;
    EditText editTxtLogin;
    EditText editTxtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        editTxtLogin = (EditText)findViewById(R.id.edittext);
        System.out.println("---[DEBUG]---\n\neditTxtLogin: " + editTxtLogin.getId());
        editTxtPassword = (EditText)findViewById(R.id.edittext);
        System.out.println("editTxtPassword: " + editTxtPassword.getId());
    }

    public void pageConfirm2 (View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        alertDialogBuilder.setTitle("Your Title");
        alertDialogBuilder
                .setMessage("Login or password invalid!")
                .setCancelable(false)
                .setPositiveButton("Close",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();

        if (this.editTxtLogin.getText().length() <= 0 || this.editTxtPassword.getText().length() <= 0) {
            alertDialog.show();
        }
        else {
            startActivity(new Intent(this, Lobby.class));
        }
    }


}
