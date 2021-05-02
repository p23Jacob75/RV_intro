package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WutAdapter extends ArrayAdapter<Word> {

    private int mColorID;

    public WutAdapter(Activity context, ArrayList<Word> words, int colorID){

        super(context, 0, words);
        mColorID = colorID;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_singles, parent, false);
        }

        Word currentWord = getItem(position);

        TextView englishTextView = (TextView) listItemView.findViewById(R.id.etextview);
        englishTextView.setText(currentWord.getDefaultTrans());

        TextView koreanTextView = (TextView) listItemView.findViewById(R.id.ktextview);
        koreanTextView.setText(currentWord.getKoreanTrans());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.picture);
        imageView.setImageResource(currentWord.getImage());

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorID);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
