package com.example.harryschmach.musicplayerndab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongPlaying extends AppCompatActivity {

    public ArrayList<Integer> resourceIDs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_playing);

        Intent i = getIntent();

        resourceIDs = i.getIntegerArrayListExtra(
                "resources"
        );

        /**
         * Structure and order of the song resources bundle
         * songResources.add(song.getSongTitle());
         * songResources.add(song.getSongArtist());
         * songResources.add(song.getGenreArt());
         * songResources.add(song.getAudioResourceId());
         * songResources.add(song.getSongDetails());
        */

        final Song thisSong = new Song(
                resourceIDs.get(0), //Song title
                resourceIDs.get(1), // Artist
                resourceIDs.get(2), // Genre Icon
                resourceIDs.get(3), // Theoretical Audio
                resourceIDs.get(4), // Song Details
                resourceIDs.get(5) //Genre Art
        );

        TextView songTitleTV = findViewById(R.id.song_playing_title_tv);
        songTitleTV.setText(thisSong.getSongTitle());
        songTitleTV.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the details text view is tapped.
            @Override
            public void onClick(View view) {

                Intent detailsIntent = new Intent(SongPlaying.this, DetailsActivity.class);
                detailsIntent.putExtra("song_details", thisSong.getSongDetails());
                // Start the new activity
                startActivity(detailsIntent);
            }
        });
        TextView songArtistTV = findViewById(R.id.song_playing_artist_tv);
        songArtistTV.setText(thisSong.getSongArtist());

        ImageView genreIV = findViewById(R.id.song_playing_genre_iv);
        genreIV.setImageResource(thisSong.getGenreArt());

        TextView detailsButton = findViewById(R.id.details_clicky_tv);
        detailsButton.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the details text view is tapped.
            @Override
            public void onClick(View view) {

                Intent detailsIntent = new Intent(SongPlaying.this, DetailsActivity.class);
                detailsIntent.putExtra("song_details", thisSong.getSongDetails());
                // Start the new activity
                startActivity(detailsIntent);
            }
        });
    }
}
