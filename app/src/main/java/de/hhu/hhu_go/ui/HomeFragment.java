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

public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

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
                //ArticleFragment frag = new ArticleFragment();
                ((MainActivity) getActivity()).replaceFragment(position);
            }
        });

        return layout;
    }


}