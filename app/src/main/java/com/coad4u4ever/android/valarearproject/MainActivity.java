package com.coad4u4ever.android.valarearproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton imgInstant;
    String instant_state = "pause";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Valar Ear");
        toolbar.setTitleTextColor(0xFFFFFFFF);

        imgInstant = (ImageButton) findViewById(R.id.img_instant);
        imgInstant.setContentDescription("music is not playing now");
        imgInstant.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_instant:
                switch (instant_state) {
                    case "playing":
                        instant_state = "pause";
                        imgInstant.setContentDescription("music is not playing now");
                        imgInstant.setImageDrawable(getResources().getDrawable(R.drawable.img_play));
                        break;
                    case "pause": // case "pause" means the music is not playing and we need to change it to play.
                        instant_state = "playing";
                        imgInstant.setContentDescription("music is playing now");
                        imgInstant.setImageDrawable(getResources().getDrawable(R.drawable.img_pause));
                        break;
                }
                break;

        }
    }
}
