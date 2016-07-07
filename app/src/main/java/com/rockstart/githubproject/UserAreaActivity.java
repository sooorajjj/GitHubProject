package com.rockstart.githubproject;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.rockstart.githubproject.R;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Klok Innovations");
        getSupportActionBar().setSubtitle("Billing");
        getSupportActionBar().setLogo(R.drawable.collection_report);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        Button bChangeStock = (Button) findViewById(R.id.bSettings);
        bChangeStock.setVisibility(View.GONE);

        Button bMasters = (Button) findViewById(R.id.bMasters);
        bMasters.setVisibility(View.GONE);
    }
}