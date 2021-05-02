package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Members_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();


        words.add(new Word("Irene", "배주현", R.mipmap.irene));
        words.add(new Word("Seulgi", "강슬기", R.mipmap.seulgi));
        words.add(new Word("Wendy", "손승완", R.mipmap.wendy));
        words.add(new Word("Joy", "박수영", R.mipmap.joy));
        words.add(new Word("Yeri", "김예림", R.mipmap.yeri));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_members);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}

