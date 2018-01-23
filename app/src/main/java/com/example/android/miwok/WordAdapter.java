package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nimje on 7/14/2016.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    /* Resource ID for the background color for this list of words */
    private int mColorResourceId;

    /**
     * Create a new {@link WordAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param words is the list of {@link Word}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }


    /* Provides a view for an AdapterView
    *
    * @param position the AdapterView that is requesting a position
    * @param convertView recycledView to populate
    * @param parent parent ViewGroup that is used for inflation */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,
                    false);
        }

        // get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the mivok TextView in the list_item.xml layout with ID List_item_mivok_textview
        TextView mivokTextView = (TextView)
                listItemView.findViewById(R.id.list_item_mivok_textview);

        // Get the mivok name from current Word object and set this text to mivokTextView
        mivokTextView.setText(currentWord.getMivokTranslation());

        //find the default TextView in the list_item.xml layout with the ID
        // List_item_default_textview
        TextView defaultTextView = (TextView)
                listItemView.findViewById(R.id.list_item_default_textview);

        //get the default name from current Word object and set this text on the default TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the imageView in the list_item.xml layout with the ID List_item_image
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.list_item_image);

        if (currentWord.hasImage()) {
            // Get the image from the current Word object and set this to the imageView
            imageView.setImageResource(currentWord.getImageResourceId());

            // make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the imageView
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);

        // Find the color that the resource UD maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout so that it can be shown in listview
        return listItemView;
    }
}
