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
import de.hhu.hhu_go.domain.Offer;

public class CaptionedImagesAdapterFood extends RecyclerView.Adapter<de.hhu.hhu_go.ui.CaptionedImagesAdapterFood.ViewHolder>{

        private Locality[] foodRecommendations;
        private de.hhu.hhu_go.ui.CaptionedImagesAdapterFood.Listener listener;


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

        public CaptionedImagesAdapterFood(Locality[] foodRecommendations){
            this.foodRecommendations = foodRecommendations;
        }

        @Override
        public int getItemCount(){
            return foodRecommendations.length;
        }

        public void setListener(de.hhu.hhu_go.ui.CaptionedImagesAdapterFood.Listener listener){
            this.listener = listener;
        }

        @Override
        public de.hhu.hhu_go.ui.CaptionedImagesAdapterFood.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                                             int viewType){
            CardView cv = (CardView) LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.card_captioned_image_trade_all,
                            parent, false);

            return new de.hhu.hhu_go.ui.CaptionedImagesAdapterFood.ViewHolder(cv);
        }

        @Override
        public void onBindViewHolder(de.hhu.hhu_go.ui.CaptionedImagesAdapterFood.ViewHolder holder, int position){
            CardView cardView = holder.cardView;
            Locality l = foodRecommendations[position];

            ImageView imageView = (ImageView) cardView.findViewById(R.id.header_image);
            Drawable drawable= ContextCompat.getDrawable(cardView.getContext(), l.getImageId());
            imageView.setImageDrawable(drawable);
            imageView.setContentDescription(l.getLocationName());

            TextView title = (TextView) cardView.findViewById(R.id.title);
            TextView subhead = (TextView) cardView.findViewById(R.id.subhead);
            TextView trader = (TextView) cardView.findViewById(R.id.trader);
            title.setText(l.getLocationName());

            subhead.setText(l.getDescription());
            trader.setText("Empfohlen von: Lena Musti" + "\nBewertung: 99 \uD83C\uDF1F");

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



