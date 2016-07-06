package com.rockstart.githubproject;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.rockstart.githubproject.R;

public class SettingsActivity extends AppCompatActivity {

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // ActionBar Customisations
        actionBar = getSupportActionBar();
            actionBar.setTitle("Klok Innovations");
            actionBar.setSubtitle("Settings");
            actionBar.setLogo(R.drawable.collection_report);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);

    }
}
