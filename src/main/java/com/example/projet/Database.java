package com.example.projet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "article_bd";
    private static final int DATABASE_VERSION = 1;

    private Context context;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase article_database) {

        // Creation de la table des articles
        String createTableArticle = "CREATE TABLE article (" +
                "idArticle INTEGER PRIMARY KEY AUTOINCREMENT," +
                "titre TEXT NOT NULL," +
                "contenu TEXT NOT NULL," +
                "auteur TEXT NOT NULL," +
                "date TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP" +
                ")";
        article_database.execSQL(createTableArticle);

    }

    @Override
    public void onUpgrade(SQLiteDatabase article_database, int i, int DATABASE_VERSION) {
        article_database.execSQL("DROP TABLE IF EXISTS article;");
        onCreate(article_database);

    }

    public void addArticle(Article article) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("titre", article.getTitle());
        values.put("content", article.getContent());
        values.put("auteur", article.getAuthor());
        //values.put("DATE", article.getDate().toString());

        db.insert("article", null, values);
        db.close();
    }
    public List<Article> getAllArticles() {
        List<Article> articleList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"idArticle","titre", "content"};
        Cursor cursor = db.query("articles", columns, null, null, null, null, null);

        while (cursor.moveToNext()) {
            @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex("titre"));
            @SuppressLint("Range") String idArticles = cursor.getString(cursor.getColumnIndex("idArticle"));
            @SuppressLint("Range") String content = cursor.getString(cursor.getColumnIndex("content"));

            Article article = new Article(title, idArticles, content);
            articleList.add(article);
        }

        cursor.close();
        db.close();

        return articleList;
    }

    public List<Article> getDetailsArticles() {
        List<Article> articleList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"auteur","titre", "content","date"};
        Cursor cursor = db.query("articles", columns, null, null, null, null, null);

        while (cursor.moveToNext()) {
            @SuppressLint("Range") String titre = cursor.getString(cursor.getColumnIndex("titre"));
            @SuppressLint("Range") String auteur = cursor.getString(cursor.getColumnIndex("auteur"));
            @SuppressLint("Range") String content = cursor.getString(cursor.getColumnIndex("content"));
            @SuppressLint("Range") String date = cursor.getString(cursor.getColumnIndex("date"));

            Article article = new Article(titre, auteur, content,date);
            articleList.add(article);
        }

        cursor.close();
        db.close();

        return articleList;
    }

}
