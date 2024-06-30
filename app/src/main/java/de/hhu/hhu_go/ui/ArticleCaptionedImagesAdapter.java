package de.hhu.hhu_go.ui;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import de.hhu.hhu_go.R;
import de.hhu.hhu_go.domain.Article;

class ArticleCaptionedImagesAdapter
        extends RecyclerView.Adapter<ArticleCaptionedImagesAdapter.ViewHolder>{

    private Article[] articles;
    private Listener listener;


    interface Listener{
        void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public ArticleCaptionedImagesAdapter(Article[] articles){
        this.articles = articles;
    }

    @Override
    public int getItemCount(){
        return articles.length;
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

    @Override
    public ArticleCaptionedImagesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                       int viewType){
        CardView cv = (CardView) LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_captioned_image_article,
                        parent, false);

        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        CardView cardView = holder.cardView;
        Article a = articles[position];

        ImageView imageView = (ImageView) cardView.findViewById(R.id.header_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), a.getImageIds().get(0));
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(a.getTitle());

        TextView title = (TextView) cardView.findViewById(R.id.title);
        TextView subhead = (TextView) cardView.findViewById(R.id.subhead);

        title.setText(a.getTitle());
        subhead.setText("von Max Musti");

        if(a.getTitle().length() > 25) {
            CardView.LayoutParams params = new CardView.LayoutParams(CardView.LayoutParams.WRAP_CONTENT, CardView.LayoutParams.WRAP_CONTENT);
            params.setMargins(0,430,0,0);
            params.gravity = 1;
            title.setLayoutParams(params);
        }

        cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(listener != null){
                    listener.onClick(holder.getAdapterPosition());
                }
            }
        });
    }
}
