package de.hhu.hhu_go.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.hhu.hhu_go.R;

public class CreateArticleFragment extends Fragment implements View.OnClickListener{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_article, container, false);
    }

    @Override
    public void onClick(View view){
        onCreateArticle();
    }

    private void onCreateArticle(){
        ArticleFragment frag = new ArticleFragment();
        // position wird in der Methode nicht genutzt
        ((MainActivity) getActivity()).replaceFragment(0, frag);
    }
}