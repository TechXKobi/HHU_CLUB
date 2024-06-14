package de.hhu.hhu_go;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    Drawable drawable = ContextCompat.getDrawable(this, R.drawable.hhuwhite2);

    // set toolbar icon
    // toolbar.setNavigationIcon(drawable);

    setSupportActionBar(toolbar);

    // enable up navigation
    ActionBar actionBar = getSupportActionBar();
    actionBar.setDisplayHomeAsUpEnabled(true);

    // attach sections page adapter to the ViewPager

    SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
    ViewPager pager = (ViewPager) findViewById(R.id.pager);
    pager.setAdapter(pagerAdapter);
    }

    @Override
    public boolean onCreateOptions(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
    }
}