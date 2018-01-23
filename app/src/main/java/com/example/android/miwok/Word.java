package com.example.android.miwok;

/**
 * Created by nimje on 7/13/2016.
 */
public class Word {

    /* Default translation for the word */
    private int mDefaultTranslation;

    /* Mivok translation for the word */
    private int mMivokTranslation;

    /* Image Resource ID for the image of the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    public static final int NO_IMAGE_PROVIDED = -1;

    /* Sound resource ID for the audio file of the associated word */
    private int mAudioResourceId;

    /* Constructor for the word class
    * Constructor for the word class
    * @param defaultTranslation passes default translation of the word
    * @param mivokTranslation passes mivok translation of the word
    */

    public Word(int defaultTranslation, int mivokTranslation, int audioId) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMivokTranslation = mivokTranslation;
        this.mAudioResourceId = audioId;
    }

    /* Constructor for the word class
     * @param defaultTranslation passes default translation of the word
     * @param mivokTranslation passes mivok translation of the word
     * @param imageResourceId passes resource id of the image*/
    public Word(int defaultTranslation, int mivokTranslation, int imageResourceId,
                int audioId) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMivokTranslation = mivokTranslation;
        this.mImageResourceId = imageResourceId;
        this.mAudioResourceId = audioId;
    }


    /* Get the Image for the list Item
    * @return image of the list item */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /* get Default Translation
    * @return default translation. here it is english */

    public int getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /* get mivok Translation
     * @return return the mivok translation for the word */

    public int getMivokTranslation() {
        return mMivokTranslation;
    }


    /* Returns whether there is any image for this word*/
    public boolean hasImage() {

        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /* Returns the audio Id of the associated audio file */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }


    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMivokTranslation='" + mMivokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }
}
