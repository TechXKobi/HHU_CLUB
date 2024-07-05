package de.hhu.hhu_go.ui;

import static android.widget.Toast.makeText;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import de.hhu.hhu_go.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private final String shareText = "Du willst Events der HHU nicht verpassen?\nDu willst gemeinsam mit Kommilitonen Lerntreffen organisieren?\nDu willst Beiträge schreiben und sie für andere Studierende veröffentlichen?\nDu willst Kleidung oder Bücher verkaufen, kaufen oder mit anderen Studierenden tauschen?\nDu willst Düsseldorf kennenlernen?\nDann ist hhuGo genau die richtige App! Lade sie Dir jetzt herunter!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.nav_open_drawer, R.string.nav_close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.NavyBlue, getTheme()));
        toggle.syncState();
        drawer.getBackground().setAlpha(220);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment frag = new HomeFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.content_frame, frag);
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item){
        int id = item.getItemId();
        Fragment fragment = null;

        if(id == R.id.nav_article) fragment = new ArticleFragment();

        else if(id == R.id.nav_events) fragment = new EventsFragment();

        else if(id == R.id.nav_trade) fragment = new TradeFragment();

        else if(id == R.id.nav_locality) fragment = new LocalityFragment();

        else if(id == R.id.nav_message) fragment = new MessageFragment();

        else fragment = new HomeFragment();

        if (fragment != null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.addToBackStack(null);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void replaceFragment(int position, Fragment frag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, frag);
        ft.addToBackStack(null);
        ft.commit();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_share:
                setShareActionIntent(shareText);
                return true;
            default:
                return false;
        }
    }

    private void setShareActionIntent(String text){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        Intent chosenIntent = Intent.createChooser(intent, getString(R.string.action_share));
        startActivity(chosenIntent);
    }


}