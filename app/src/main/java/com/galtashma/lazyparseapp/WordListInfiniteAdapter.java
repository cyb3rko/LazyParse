package com.galtashma.lazyparseapp;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;

import com.galtashma.lazyparse.LazyList;
import com.galtashma.lazyparse.LazyParseObjectHolder;
import com.galtashma.lazyparse.ScrollInfiniteAdapter;

/**
 * Created by gal on 2/15/18.
 */

public class WordListInfiniteAdapter extends ScrollInfiniteAdapter<WordLazy> {

    public WordListInfiniteAdapter(Context context, LazyList<WordLazy> list){
        super(context, list, android.R.layout.simple_list_item_1, 20);
    }

    @Override
    public View renderReadyLazyObject(WordLazy word, @NonNull View convertView, @NonNull ViewGroup parent) {
        final TextView tv = convertView.findViewById(android.R.id.text1);
        tv.setTextColor(Color.BLACK);
        tv.setText(word.getWord());
        return convertView;
    }

    @Override
    public View renderLoadingLazyObject(LazyParseObjectHolder<WordLazy> object, @NonNull View convertView, @NonNull ViewGroup parent) {
        final TextView tv = convertView.findViewById(android.R.id.text1);
        tv.setTextColor(Color.BLACK);
        tv.setText("Loading...");
        return convertView;
    }
}