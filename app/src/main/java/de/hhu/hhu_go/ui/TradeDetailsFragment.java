package de.hhu.hhu_go.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.time.format.DateTimeFormatter;

import de.hhu.hhu_go.R;
import de.hhu.hhu_go.domain.Events;
import de.hhu.hhu_go.domain.Offer;

public class TradeDetailsFragment extends Fragment {
    private Offer data;

    public TradeDetailsFragment(Offer o) {
        this.data = o;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_trade_details, container, false);
        TextView title = (TextView) layout.getChildAt(0);
        TextView subheads = (TextView) layout.getChildAt(1);

        ImageView image = (ImageView) layout.getChildAt(2);
        TextView content = (TextView) layout.getChildAt(3);
        Integer offerId = R.drawable.book;

        if(data.getCategory().equals("Kleidung")) offerId = R.drawable.clothing;
        Drawable drawable = ContextCompat.getDrawable(getActivity(), offerId);

        title.setText(data.getName());

        subheads.setText("Preis: " + data.getPrice() + "€" + "\nAngeboten von: "
                + "Max Musti"
                + "\nAngeboten am: "
                + data
                .getDateTime()
                .format(DateTimeFormatter.ofPattern("HH:mm, am dd.MM.yy"))
                + "\nZustand: " + (data.isState() ? "neu":"gebraucht"));


        image.setImageDrawable(drawable);
        image.setContentDescription(data.getName());

        content.setText(data.getDescription());

        return layout;
    }


}