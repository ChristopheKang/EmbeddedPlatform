package com.example.neiris.embeddedplatform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Lobby extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);
    }

    public void pageBooking (View view) {
        startActivity(new Intent(this, Booking.class));
    }

    public void pageLogout (View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void pageNews (View view) {
        startActivity(new Intent(this, News.class));
    }





}
