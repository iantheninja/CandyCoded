package com.ianmunene.candycoded;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
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
        TextView tvName = findViewById(R.id.tv_name);
        tvName.setText(candyName);

        if (intent != null && intent.hasExtra("candy_price"))
            candyPrice = intent.getStringExtra("candy_price");
        TextView tvPrice = findViewById(R.id.tv_price);
        tvPrice.setText(candyPrice);

        if (intent != null && intent.hasExtra("candy_image"))
            candyImage = intent.getStringExtra("candy_image");
        ImageView ivImage = findViewById(R.id.iv_candy);
        //Picasso.with(this).load(candyImage).into(ivImage);

        if (intent != null && intent.hasExtra("candy_description"))
            candyDesc = intent.getStringExtra("candy_description");
        TextView tvDescription = findViewById(R.id.tv_desc);
        tvDescription.setText(candyDesc);
    }
}
