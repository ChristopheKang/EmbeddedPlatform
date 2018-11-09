package com.example.neiris.embeddedplatform;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    final Context context = this;
    EditText editTxtName;
    EditText editTxtSurname;
    EditText editTxtMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        editTxtName = (EditText)findViewById(R.id.editTextName);
        System.out.println(editTxtName.getId());
        editTxtSurname = (EditText)findViewById(R.id.editTextSurname);
        System.out.println(editTxtSurname.getId());
        editTxtMail = (EditText)findViewById(R.id.editTextMail);
        System.out.println(editTxtMail.getId());;
    }

    public void pageConfirm1 (View view) {
        startActivity(new Intent(this, MainActivity.class));
    }


    public void deleteTextName(View view) {
        editTxtName.setText("");
    }
    public void deleteTextSurname(View view) {
        editTxtSurname.setText("");
    }
    public void deleteTextMail(View view) {
        editTxtMail.setText("");
    }
}
