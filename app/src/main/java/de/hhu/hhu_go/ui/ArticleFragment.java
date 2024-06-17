package de.hhu.hhu_go.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import de.hhu.hhu_go.R;
import de.hhu.hhu_go.domain.Article;

public class ArticleFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout layout = (LinearLayout) inflater
                .inflate(R.layout.fragment_article,
                        container, false);

        RecyclerView recycler = (RecyclerView) layout.getChildAt(1);
        Article[] articles = DummyData.articles2;

        for(Article a:articles) {
            a.addImage(R.drawable.study);
        }

        ArticleCaptionedImagesAdapter adapter = new ArticleCaptionedImagesAdapter(articles);
        recycler.setAdapter(adapter);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(2);
        recycler.setLayoutManager(layoutManager);

        adapter.setListener(new ArticleCaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Article a = DummyData.articles[position];
                articles[position].addImage(R.drawable.bible_study);
                ArticleDetailsFragment frag = new ArticleDetailsFragment(a);
                ((MainActivity) getActivity()).replaceFragment(position, frag);
            }
        });

        return layout;
    }
}