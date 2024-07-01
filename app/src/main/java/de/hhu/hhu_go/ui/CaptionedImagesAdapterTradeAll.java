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
import de.hhu.hhu_go.domain.Book;
import de.hhu.hhu_go.domain.Offer;

public class CaptionedImagesAdapterTradeAll extends RecyclerView.Adapter<CaptionedImagesAdapterTradeAll.ViewHolder>{

    private Offer[] offers;
    private CaptionedImagesAdapterTradeAll.Listener listener;


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

    public CaptionedImagesAdapterTradeAll(Offer[] offers){
        this.offers = offers;
    }

    @Override
    public int getItemCount(){
        return offers.length;
    }

    public void setListener(CaptionedImagesAdapterTradeAll.Listener listener){
        this.listener = listener;
    }

    @Override
    public CaptionedImagesAdapterTradeAll.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                        int viewType){
        CardView cv = (CardView) LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_captioned_image_trade_all,
                        parent, false);

        return new CaptionedImagesAdapterTradeAll.ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(CaptionedImagesAdapterTradeAll.ViewHolder holder, int position){
        CardView cardView = holder.cardView;
        Offer o = offers[position];
        Integer drawableId = R.drawable.clothing;

        if(o.getCategory().equals("Buch")) drawableId = R.drawable.book;

        ImageView imageView = (ImageView) cardView.findViewById(R.id.header_image);
        Drawable drawable= ContextCompat.getDrawable(cardView.getContext(), drawableId);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(o.getName());

        TextView title = (TextView) cardView.findViewById(R.id.title);
        TextView subhead = (TextView) cardView.findViewById(R.id.subhead);
        TextView trader = (TextView) cardView.findViewById(R.id.trader);

        title.setText(o.getName());

        String priceOrSwitch = "Tausch";
        if(o.getPrice() > 0) priceOrSwitch = o.getPrice() + "€";
        subhead.setText("Preis: " + priceOrSwitch +"\nZustand: " + o.isState()
                + "\nDatum: " + o.getDateTime().format(DateTimeFormatter.ofPattern("HH:mm, am dd.MM.yy"))
                + "\n");
        trader.setText("Von: Max Musti");

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


