package com.example.neiris.embeddedplatform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class News extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        helper.fillArticlesInDb();
        System.out.println("---[NEWS PAGE CREATED]---");
    }

    public void displayArticle(View V) {
        TextView editTxtArticle = (TextView) findViewById(R.id.textViewNews);
        // prevents crash
//        String articleTxt = helper.getArticle(0);
//        editTxtArticle.setText(articleTxt);

    }

}
