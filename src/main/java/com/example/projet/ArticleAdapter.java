package com.example.projet;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import android.content.Intent;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;




public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    private List<Article> articles;
    private OnItemClickListener onItemClickListener;

    public ArticleAdapter(List<Article> articles) {
        this.articles = articles;
    }


    public static class ArticleViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView contentTextView;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            contentTextView = itemView.findViewById(R.id.contentTextView);
        }
    }





    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflater le layout de l'élément d'interface utilisateur
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_article, parent, false);

        // Créer un ViewHolder pour le stocker
        return new ArticleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        // Récupérer l'objet article à la position donnée
        Article article = articles.get(position);

        // Extraire les données de l'article
        String title = article.getTitle();
        String content = article.getContent();

        // Afficher les données dans les TextView de l'élément d'interface utilisateur
        holder.titleTextView.setText(title);
        holder.contentTextView.setText(getTruncatedContent(content));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), voirArticle.class);
                intent.putExtra("article", article);
                v.getContext().startActivity(intent);
            }
        });
    }

    private String getTruncatedContent(String content) {
        // Définir la longueur maximale pour le début de l'article que vous souhaitez afficher
        int maxLength = 30;

        // Tronquer le contenu si nécessaire
        if (content.length() > maxLength) {
            return content.substring(0, maxLength) + "...";
        } else {
            return content;
        }
    }

    public int getItemCount() {
        return articles.size();
    }


    public interface OnItemClickListener {
        void onItemClick(Article article);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

}


