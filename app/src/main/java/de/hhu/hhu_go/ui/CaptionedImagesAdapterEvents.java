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
import de.hhu.hhu_go.domain.Events;

public class CaptionedImagesAdapterEvents extends RecyclerView.Adapter<CaptionedImagesAdapterEvents.ViewHolder>{

    private Events[] events;
    private CaptionedImagesAdapterEvents.Listener listener;


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

    public CaptionedImagesAdapterEvents(Events[] events){
        this.events = events;
    }

    @Override
    public int getItemCount(){
        return events.length;
    }

    public void setListener(CaptionedImagesAdapterEvents.Listener listener){
        this.listener = listener;
    }

    @Override
    public CaptionedImagesAdapterEvents.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                int viewType){
        CardView cv = (CardView) LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_captioned_image_event,
                        parent, false);

        return new CaptionedImagesAdapterEvents.ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(CaptionedImagesAdapterEvents.ViewHolder holder, int position){
        CardView cardView = holder.cardView;
        Events e = events[position];

        ImageView imageView = (ImageView) cardView.findViewById(R.id.header_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), R.drawable.event);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(e.getEventName());

        TextView title = (TextView) cardView.findViewById(R.id.title);
        TextView subhead = (TextView) cardView.findViewById(R.id.subhead);
        TextView creator = (TextView) cardView.findViewById(R.id.creator);

        title.setText(e.getEventName()+", in " + e.getPlace() + ", um " + e.getDateTime().format(DateTimeFormatter.ofPattern("HH:mm, am dd.MM.yy")));
        subhead.setText(e.getDescription());
        creator.setText("veranstaltet von Max Musti");

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
