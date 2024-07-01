package de.hhu.hhu_go.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

import de.hhu.hhu_go.R;
import de.hhu.hhu_go.domain.Article;

public class ArticleFragment extends Fragment implements View.OnClickListener {

    private LinearLayout layout;
    private RecyclerView recycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout layout = (LinearLayout) inflater
                .inflate(R.layout.fragment_article,
                        container, false);

        RecyclerView recycler = (RecyclerView) layout.getChildAt(2);

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
                Article a = DummyData.articles2[position];
                articles[position].addImage(R.drawable.bible_study);
                ArticleDetailsFragment frag = new ArticleDetailsFragment(a);
                ((MainActivity) getActivity()).replaceFragment(position, frag);
            }
        });

        Spinner categoryFilter = (Spinner) layout.findViewById(R.id.categoryFilter);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                DummyData.categories);

        categoryFilter.setAdapter(spinnerAdapter);

        Button addArticleButton = (Button) layout.findViewById(R.id.addArticle);
        addArticleButton.setOnClickListener(this);

        Button applyFilterButton = (Button) layout.findViewById(R.id.applyFilter);
        applyFilterButton.setOnClickListener(this);

        Button resetFilterButton = (Button) layout.findViewById(R.id.resetFilter);
        resetFilterButton.setOnClickListener(this);

        this.layout = layout;
        this.recycler = recycler;
        return layout;
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.addArticle:
                onAddArticle();
                break;
            case R.id.applyFilter:
                onApplyFilter();
                break;
            case R.id.resetFilter:
                onResetFilter();
                break;
        }
    }

    private void onAddArticle(){
    }

    private void onApplyFilter(){
        Spinner categoryFilter = (Spinner) layout.findViewById(R.id.categoryFilter);
        String category = String.valueOf(categoryFilter.getSelectedItem());
        boolean isAll = false;

        if(category.equals("Alle")){
            isAll = true;
        }

        Article[] articles = DummyData.articles2;

        if(!isAll)
            articles = Arrays.stream(DummyData.articles2)
                .filter(a->a.getCategory().equals(category))
                .toArray(Article[]::new);

        for(Article a:articles) {
            a.addImage(R.drawable.study);
        }

        ArticleCaptionedImagesAdapter adapter = new ArticleCaptionedImagesAdapter(articles);
        recycler.setAdapter(adapter);
        setUpAdapter(articles, adapter);
    }

    private void onResetFilter(){
        Spinner categoryFilter = (Spinner) layout.findViewById(R.id.categoryFilter);
        categoryFilter.setSelection(DummyData.categories.length-1);
        Article[] articles = DummyData.articles2;

        for(Article a:articles) {
            a.addImage(R.drawable.study);
        }

        ArticleCaptionedImagesAdapter adapter = new ArticleCaptionedImagesAdapter(articles);
        recycler.setAdapter(adapter);

        setUpAdapter(articles, adapter);
    }

    private void setUpAdapter(Article[] articles, ArticleCaptionedImagesAdapter adapter){
        recycler.setAdapter(adapter);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(2);
        recycler.setLayoutManager(layoutManager);

        adapter.setListener(new ArticleCaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Article a = articles[position];
                articles[position].addImage(R.drawable.bible_study);
                ArticleDetailsFragment frag = new ArticleDetailsFragment(a);
                ((MainActivity) getActivity()).replaceFragment(position, frag);
            }
        });

        Button addArticleButton = (Button) layout.findViewById(R.id.addArticle);
        addArticleButton.setOnClickListener(this);

        Button applyFilterButton = (Button) layout.findViewById(R.id.applyFilter);
        applyFilterButton.setOnClickListener(this);

        Button resetFilterButton = (Button) layout.findViewById(R.id.resetFilter);
        resetFilterButton.setOnClickListener(this);
    }
}