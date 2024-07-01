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
import de.hhu.hhu_go.domain.Locality;

public class LocalityDetailsFragment extends Fragment {

    private Locality data;

    public LocalityDetailsFragment(Locality l) {
        this.data = l;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        LinearLayout layout = (LinearLayout) inflater
                .inflate(R.layout.fragment_locality_details,
                        container, false);

        TextView title = (TextView) layout.findViewById(R.id.title);
        TextView subheads = (TextView) layout.findViewById(R.id.subhead);

        ImageView image = (ImageView) layout.findViewById(R.id.header_image);
        TextView content = (TextView) layout.findViewById(R.id.body);
        TextView link = (TextView) layout.findViewById(R.id.link);

        Drawable drawable = ContextCompat.getDrawable(getActivity(), data.getImageId());

        title.setText(data.getLocationName());

        subheads.setText(data.getAddress());

        image.setImageDrawable(drawable);
        image.setContentDescription(data.getLocationName());

        content.setText(data.getDescription());

        link.setText(data.getLink());

        return layout;
    }
}