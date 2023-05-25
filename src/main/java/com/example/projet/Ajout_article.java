package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Ajout_article extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajouter_article);





        EditText contentEditText = findViewById(R.id.edit_content);
        EditText TitleEditText = findViewById(R.id.edit_title);
        EditText authorEditText = findViewById(R.id.edit_author);
        Button addButton = findViewById(R.id.Button_add);
        Button resetButton = findViewById(R.id.Button_reset);

        Database database = new Database(this);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérez les valeurs des champs de saisie
                String title = TitleEditText.getText().toString();
                String author = authorEditText.getText().toString();
                String content = contentEditText.getText().toString();

                // Créez une instance de l'article avec les valeurs saisies
                Article article = new Article(title, author, content);

                // Ajoutez l'article à la base de données en utilisant votre classe de gestion de base de données appropriée
                // Par exemple, si vous avez une instance de la classe Database nommée "database", vous pouvez appeler la méthode addArticle(article)


                database.addArticle(article);

                // Récupérer la liste des articles après l'ajout
                List<Article> articleList = database.getAllArticles();
                ArrayList<Parcelable> parcelableList = new ArrayList<>();

                for (Article cuarticle : articleList) {
                    parcelableList.add((Parcelable) cuarticle);
                }

                Intent intent = new Intent(Ajout_article.this, MainActivity.class);
                intent.putParcelableArrayListExtra("articleList", parcelableList);
                startActivity(intent);



                // Effacer les champs de saisie après l'ajout de l'article
                TitleEditText.setText("");
                authorEditText.setText("");
                contentEditText.setText("");


            }
        });


        resetButton.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ajout_article.this, MainActivity.class);
                startActivity(intent);
            }
        });




    }
}
