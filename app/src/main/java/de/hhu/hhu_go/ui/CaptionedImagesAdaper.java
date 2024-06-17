package de.hhu.hhu_go.ui;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.net.URL;

import de.hhu.hhu_go.R;
import de.hhu.hhu_go.domain.Article;

class CaptionedImagesAdapter
        extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>{

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

    public CaptionedImagesAdapter(Article[] articles){
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
    public CaptionedImagesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                int viewType){
        CardView cv = (CardView) LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_captioned_image,
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
        TextView text = (TextView) cardView.findViewById(R.id.body);

        title.setText(a.getTitle());
        subhead.setText("Max Musti");
        text.setText(a.getContent());

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
