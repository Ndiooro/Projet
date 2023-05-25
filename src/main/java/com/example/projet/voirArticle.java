package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class voirArticle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voir_article);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("article")) {
            Article article = (Article) intent.getSerializableExtra("article");
            intent.putExtra("article",article);
            RelativeLayout detailsLayout = findViewById(R.id.relativeLayout);
            TextView dateTextView = detailsLayout.findViewById(R.id.date_TextView);
            TextView authorTextView = detailsLayout.findViewById(R.id.author_TextView);
            TextView titleTextView = findViewById(R.id.title_TextView);
            TextView contentTextView = findViewById(R.id.content_TextView);
            dateTextView.setText((CharSequence) article.getDate());
            authorTextView.setText(article.getAuthor());
            titleTextView.setText(article.getTitle());
            contentTextView.setText(article.getContent());
        }
        Button returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(voirArticle.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
