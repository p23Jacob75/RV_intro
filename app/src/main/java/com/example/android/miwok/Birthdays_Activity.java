package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Birthdays_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //  String[] words = new String[10];   Array

//        words[0] = "one";
//        words[1] = "two";
//        words[2] = "three";
//        words[3] = "four";
//        words[4] = "five";
//        words[5] = "six";
//        words[6] = "seven";
//        words[7] = "eight";
//        words[8] = "nine";
//        words[9] = "ten";

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Irene", "29/03/1991", R.mipmap.irene));
        words.add(new Word("Seulgi", "10/02/1994", R.mipmap.seulgi));
        words.add(new Word("Wendy", "21/02/1994", R.mipmap.wendy));
        words.add(new Word("Joy", "03/09/1996", R.mipmap.joy));
        words.add(new Word("Yeri", "05/03/1999", R.mipmap.yeri));
//        LinearLayout rootView = (LinearLayout)findViewById(R.id.hana);

//        int i;
//
//        for (i=0; i<words.size(); i++) {
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(i));
//            rootView.addView(wordView);
//        }

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_birthdays);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}

