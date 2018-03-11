package com.codeschool.candycoded;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = DetailActivity.this.getIntent();
        String candyName = "";
        String candyImage = "";
        String candyPrice = "";
        String candyDesc = "";

        if (intent != null && intent.hasExtra("candy_name"))
            candyName = intent.getStringExtra("candy_name");

        if (intent != null && intent.hasExtra("candy_price"))
            candyPrice = intent.getStringExtra("candy_name");

        if (intent != null && intent.hasExtra("candy_image"))
            candyImage = intent.getStringExtra("candy_image");

        if (intent != null && intent.hasExtra("candy_price"))
            candyPrice = intent.getStringExtra("candy_name");

        TextView textView = findViewById(R.id.tv_candy_detail);
        textView.setText(candyName);

        Log.d("DetailActivity", "Intent data: " + candyImage
                + ", " + candyPrice + ", " + candyDesc);
    }
}
