package com.example.android.miwok;

public class Word {

    private String mDefaultTrans;
    private String mKoreanTrans;
    private int mImage;
    private int mAudioResource;

    public Word (String DefaultTrans, String KoreanTrans, int imageID){
        mDefaultTrans = DefaultTrans;
        mKoreanTrans = KoreanTrans;
        mImage = imageID;
//        mAudioResource = AudioRes;
    }

    public Word (String DefaultTrans, String KoreanTrans, int imageID, int AudioRes){
        mDefaultTrans = DefaultTrans;
        mKoreanTrans = KoreanTrans;
        mImage = imageID;
        mAudioResource = AudioRes;
    }

    public String getDefaultTrans(){
        return mDefaultTrans;
    }

    public String getKoreanTrans(){
        return mKoreanTrans;
    }

    public int getImage(){
        return mImage;
    }

    public int getAudioResource(){
        return mAudioResource;
    }

}
