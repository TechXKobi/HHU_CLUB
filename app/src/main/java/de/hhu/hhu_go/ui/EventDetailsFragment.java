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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import de.hhu.hhu_go.R;
import de.hhu.hhu_go.domain.Events;

public class EventDetailsFragment extends Fragment {

    private Events data;

    public EventDetailsFragment(Events e) {
        this.data = e;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout layout = (LinearLayout) inflater
                .inflate(R.layout.fragment_event_details,
                        container, false);

        TextView title = (TextView) layout.getChildAt(0);
        TextView subheads = (TextView) layout.getChildAt(1);

        ImageView image = (ImageView) layout.getChildAt(2);
        TextView content = (TextView) layout.getChildAt(3);
        Drawable drawable = ContextCompat.getDrawable(getActivity(), R.drawable.event);

        title.setText(data.getEventName());

        subheads.setText("findet statt in " + data.getPlace() + " um " + data
                .getDateTime()
                .format(DateTimeFormatter.ofPattern("HH:mm, am dd.MM.yy")));


        image.setImageDrawable(drawable);
        image.setContentDescription(data.getEventName());

        content.setText(data.getDescription());

        return layout;
    }
}