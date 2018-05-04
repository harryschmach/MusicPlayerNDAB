package com.example.harryschmach.musicplayerndab;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song>  {

    private int mColorResourceId;

    /**
     * Create a new {@link SongAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param songs is the list of {@link Song}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public SongAdapter(Context context, ArrayList<Song> songs, int colorResourceId) {
        super(context, 0, songs);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the Song object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the list_item.xml holding the artist name.
        TextView artistTextView = listItemView.findViewById(R.id.artist_name);
        // Get the artist name and set the textview to it.
        assert currentSong != null;
        artistTextView.setText(currentSong.getSongArtist());

        // Find the TextView in the list_item.xml holding the song title.
        TextView songTitleTextView = listItemView.findViewById(R.id.song_title);
        // set the textview to the song title
        songTitleTextView.setText(currentSong.getSongTitle());

        // Find the ImageView that holds the genre art
        ImageView imageView = listItemView.findViewById(R.id.list_item_image);
        // Get the genre art
        imageView.setImageResource(currentSong.getGenreIcon());
        // set the genre art to classify the song
        imageView.setVisibility(View.VISIBLE);

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.list_linear_layout_bgcolor);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
