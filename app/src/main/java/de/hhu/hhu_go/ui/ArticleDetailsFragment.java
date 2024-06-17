package de.hhu.hhu_go.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import de.hhu.hhu_go.R;
import de.hhu.hhu_go.domain.Article;

public class ArticleDetailsFragment extends Fragment {

    private Article data;

    public ArticleDetailsFragment(Article a){
        this.data = a;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LinearLayout layout = (LinearLayout) inflater
                .inflate(R.layout.fragment_article_details,
                        container, false);

        TextView title = (TextView) layout.getChildAt(0);
        TextView subheads = (TextView) layout.getChildAt(1);

        ImageView image = (ImageView) layout.getChildAt(2);
        TextView content = (TextView) layout.getChildAt(3);
        Drawable drawable = ContextCompat.getDrawable(getActivity(), R.drawable.bible_study);

        title.setText(data.getTitle());


        subheads.setText("verfasst von " + "Max Musti " + data
                .getDateTime()
                .format(DateTimeFormatter.ofPattern("HH:mm, am dd.MM.yy")));


        image.setImageDrawable(drawable);
        image.setContentDescription(data.getTitle());

        content.setText(data.getContent());

        return layout;
    }
}