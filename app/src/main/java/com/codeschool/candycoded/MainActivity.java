package com.codeschool.candycoded;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    private Candy[] candies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = this.findViewById(R.id.text_view_title);
        textView.setText(R.string.products_title);

        final ArrayList<String> candy_list = new ArrayList<>();

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.list_item_candy,
                R.id.text_view_candy,
                candy_list
        );

        ListView listView = this.findViewById(R.id.list_view_candy);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
                detailIntent.putExtra("candy_name", candies[i].name);
                detailIntent.putExtra("candy_image", candies[i].image);
                detailIntent.putExtra("candy_price", candies[i].price);
                detailIntent.putExtra("candy_description", candies[i].description);
                startActivity(detailIntent);

            }
        });

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://vast-brushlands-23089.herokuapp.com/main/api",
                new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Log.e("AsyncHttpClient", "response = " + responseString);
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        Log.d("AsyncHttpClient", "response = " + responseString);
                        Gson gson = new GsonBuilder().create();
                        candies = gson.fromJson(responseString, Candy[].class);
                        adapter.clear(); // clears anything that's inside the adapter
                        for (Candy candy : candies) {
                            adapter.add(candy.name); // things are added to
                        }
                    }
                });
    }
}
