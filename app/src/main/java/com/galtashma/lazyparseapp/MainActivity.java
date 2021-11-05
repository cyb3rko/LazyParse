package com.galtashma.lazyparseapp;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.galtashma.lazyparse.LazyList;
import com.galtashma.lazyparse.ScrollInfiniteAdapter;
import com.galtashma.lazyparse.ScrollInfiniteListener;
import com.parse.ParseQuery;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseQuery<WordLazy> query = new ParseQuery<WordLazy>(WordLazy.class);
        query.orderByAscending("value");
        LazyList<WordLazy> list = new LazyList<>(query);

        WordListInfiniteAdapter adapter = new WordListInfiniteAdapter(this, list);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnScrollListener(new ScrollInfiniteListener(adapter));

        adapter.setOnClickListener(new ScrollInfiniteAdapter.OnClickListener<WordLazy>() {
            @Override
            public void onClick(WordLazy object) {
                Toast.makeText(getApplicationContext(), "Clicked " + object.getObjectId() + " " + object.getWord(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
