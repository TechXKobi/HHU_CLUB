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
import de.hhu.hhu_go.domain.Contact;
import de.hhu.hhu_go.domain.Offer;


public class CaptionedImagesAdapterMessaging extends RecyclerView.Adapter<CaptionedImagesAdapterMessaging.ViewHolder>{

    private Contact[] contacts;
    private CaptionedImagesAdapterMessaging.Listener listener;


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

    public CaptionedImagesAdapterMessaging(Contact[] contacts){
        this.contacts = contacts;
    }

    @Override
    public int getItemCount(){
        return contacts.length;
    }

    public void setListener(CaptionedImagesAdapterMessaging.Listener listener){
        this.listener = listener;
    }

    @Override
    public CaptionedImagesAdapterMessaging.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                        int viewType){
        CardView cv = (CardView) LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_captioned_image_messaging,
                        parent, false);

        return new CaptionedImagesAdapterMessaging.ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(CaptionedImagesAdapterMessaging.ViewHolder holder, int position){
        CardView cardView = holder.cardView;
        Contact c = contacts[position];

        Integer pictureId = c.getProfilePictureId();
        String chatPartnerName = pictureId == R.drawable.profile2 ? "Lena Musti" : "Max Musti";

        ImageView imageView = (ImageView) cardView.findViewById(R.id.header_image);
        Drawable drawable= ContextCompat.getDrawable(cardView.getContext(), pictureId);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(chatPartnerName);

        TextView title = (TextView) cardView.findViewById(R.id.title);
        TextView subhead = (TextView) cardView.findViewById(R.id.subhead);

        title.setText(chatPartnerName);
        String lastMessage = c.getLastMessage();

        subhead.setText((lastMessage.length() > 54 ? lastMessage.substring(0,50) + "..." : lastMessage) + "\nam " +c.getLastTimeChatted().format(DateTimeFormatter.ofPattern("HH:mm, am dd.MM.yy"))
                + "\n");

        cardView.setOnClickListener(v -> {
            if(listener != null){
                listener.onClick(holder.getAdapterPosition());
            }
        });
    }
}



