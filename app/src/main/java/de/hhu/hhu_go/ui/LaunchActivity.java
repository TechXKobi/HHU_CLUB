package de.hhu.hhu_go.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import de.hhu.hhu_go.R;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        ImageView image = (ImageView) findViewById(R.id.launch_img);

        AlphaAnimation fadeIn = new AlphaAnimation(0.0f , 1.0f ) ;
        image.startAnimation(fadeIn);
        fadeIn.setDuration(3000);
        fadeIn.setFillAfter(true);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent(LaunchActivity.this, MainActivity.class);
                startActivity(intent);
            }
        },3000);
    }
}