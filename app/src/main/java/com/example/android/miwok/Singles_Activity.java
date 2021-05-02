package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import android.media.MediaPlayer;
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
import android.content.Context;
import android.media.AudioManager;

public class Singles_Activity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener mCompleted = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

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

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Happiness", "01/08/2014", R.mipmap.happiness, R.raw.happiness));
        words.add(new Word("Be Natural", "13/10/2014", R.mipmap.benatural, R.raw.benatural));
        words.add(new Word("Ice Cream Cake", "17/03/2015", R.mipmap.icecreamcake, R.raw.icc));
        words.add(new Word("Dumb Dumb", "09/09/2015", R.mipmap.thered, R.raw.dumbdumb));
        words.add(new Word("One Of These Nights", "17/03/2016", R.mipmap.oneofthesenights, R.raw.oftn));
        words.add(new Word("Russian Roulette", "07/09/2016", R.mipmap.russianroulette, R.raw.rr));
        words.add(new Word("Rookie", "01/02/2017", R.mipmap.rookie, R.raw.rookie));
        words.add(new Word("Would U", "31/03/2017", R.mipmap.wouldu, R.raw.wouldu));
        words.add(new Word("Red Flavour", "09/07/2017", R.mipmap.redsummer, R.raw.redflavour));
        words.add(new Word("Rebirth", "18/08/2017", R.mipmap.rebirth, R.raw.rebirth));
        words.add(new Word("Peek-A-Boo", "17/11/2017", R.mipmap.perfectvelvet, R.raw.peekaboo));
        words.add(new Word("Bad Boy", "29/01/2018", R.mipmap.logo, R.raw.badboy));
        words.add(new Word("Power Up", "06/08/2018", R.mipmap.powerup, R.raw.powerup));
        words.add(new Word("Really Bad Boy", "30/11/2018", R.mipmap.rbb, R.raw.rbb));
        words.add(new Word("Zimzalabim", "19/06/2019", R.mipmap.day1, R.raw.zzz));
        words.add(new Word("Umpah Umpah", "20/08/2019", R.mipmap.day2, R.raw.umpah));
        words.add(new Word("Psycho", "23/12/2019", R.mipmap.finale, R.raw.psycho));
//        LinearLayout rootView = (LinearLayout)findViewById(R.id.hana);

//        int i;
//
//        for (i=0; i<words.size(); i++) {
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(i));
//            rootView.addView(wordView);
//        }

        WutAdapter adapter = new WutAdapter(this, words, R. color.category_singles);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);

                onStop();

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(Singles_Activity.this, word.getAudioResource());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompleted);
                }
                }
        });
    }

    @Override
    protected  void onStop(){
        super.onStop();
        releaseMediaPlayer();
    }
    
    private void releaseMediaPlayer(){
        if (mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}

