package de.hhu.hhu_go.ui;

import android.media.tv.TvRecordingClient;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.time.temporal.ChronoUnit;

import de.hhu.hhu_go.R;
import de.hhu.hhu_go.domain.Article;
import de.hhu.hhu_go.domain.Events;
import de.hhu.hhu_go.domain.Locality;

public class HomeFragment extends Fragment{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // hot articles

        LinearLayout layout = (LinearLayout) inflater
                .inflate(R.layout.fragment_home,
                        container, false);

        TextView welcomeText = (TextView) layout.getChildAt(1);
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f , 1.0f ) ;
        welcomeText.startAnimation(fadeIn);
        fadeIn.setDuration(1500);
        fadeIn.setFillAfter(true);


        TextView clickHint = (TextView) layout.getChildAt(4);
        clickHint.startAnimation(fadeIn);
        fadeIn.setDuration(1000);
        fadeIn.setFillAfter(true);

        RecyclerView articleRecycler = (RecyclerView) layout.getChildAt(3);

        Article[] articles = DummyData.articles;

        for(Article a:articles) {
            a.addImage(R.drawable.study);
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(articles);
        articleRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        articleRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                ArticleDetailsFragment frag = new ArticleDetailsFragment(articles[position]);
                ((MainActivity) getActivity()).replaceFragment(position, frag);
            }
        });

        // hot events
        RecyclerView eventsRecycler = (RecyclerView) layout.findViewById(R.id.top_events_recycler);

        Events[] events = DummyData.events;

        // build view for hot events
        CaptionedImagesAdapterEvents eventsAdapter = new CaptionedImagesAdapterEvents(events);
        eventsRecycler.setAdapter(eventsAdapter);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        eventsRecycler.setLayoutManager(layoutManager2);

        eventsAdapter.setListener(new CaptionedImagesAdapterEvents.Listener() {
            @Override
            public void onClick(int position) {
                EventDetailsFragment frag = new EventDetailsFragment(events[position]);
                ((MainActivity) getActivity()).replaceFragment(position, frag);
            }
        });

        // hot locations

        RecyclerView hhuRecycler = layout.findViewById(R.id.top_locality_recycler);

        Locality[] hhuLocalities = DummyData.hhuLocalities;

        // build view for hhu locality
        CaptionedImagesAdapterLocality hhuAdapter = new CaptionedImagesAdapterLocality(hhuLocalities);
        hhuRecycler.setAdapter(hhuAdapter);

        LinearLayoutManager layoutManager3 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        hhuRecycler.setLayoutManager(layoutManager3);

        hhuAdapter.setListener(new CaptionedImagesAdapterLocality.Listener() {
            @Override
            public void onClick(int position) {
                LocalityDetailsFragment frag = new LocalityDetailsFragment(hhuLocalities[position]);
                ((MainActivity) getActivity()).replaceFragment(position, frag);
            }
        });

        return layout;
    }


}