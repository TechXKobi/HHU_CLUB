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

import java.time.format.DateTimeFormatter;

import de.hhu.hhu_go.R;
import de.hhu.hhu_go.domain.Locality;

public class CaptionedImagesAdapterLocality extends RecyclerView.Adapter<CaptionedImagesAdapterLocality.ViewHolder>{

    private Locality[] localities;
    private CaptionedImagesAdapterLocality.Listener listener;


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

    public CaptionedImagesAdapterLocality(Locality[] localities){
        this.localities = localities;
    }

    @Override
    public int getItemCount(){
        return localities.length;
    }

    public void setListener(CaptionedImagesAdapterLocality.Listener listener){
        this.listener = listener;
    }

    @Override
    public CaptionedImagesAdapterLocality.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                      int viewType){
        CardView cv = (CardView) LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_captioned_image_locality,
                        parent, false);

        return new CaptionedImagesAdapterLocality.ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(CaptionedImagesAdapterLocality.ViewHolder holder, int position){
        CardView cardView = holder.cardView;
        Locality l = localities[position];

        ImageView imageView = (ImageView) cardView.findViewById(R.id.header_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), l.getImageId());
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(l.getLocationName());

        TextView title = (TextView) cardView.findViewById(R.id.title);
        TextView stars = (TextView) cardView.findViewById(R.id.stars);

        title.setText(l.getLocationName());
        stars.setText("99 " + "🌟");

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
