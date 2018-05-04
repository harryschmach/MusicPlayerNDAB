package com.example.harryschmach.musicplayerndab;

// Images gathered from Pexels.com

// Icon attributions:
// rock on by nauraicon from the Noun Project
// Mustache by Dinosoft Labs from the Noun Project
// Electronic Music by Jason D. Rowley from the Noun Project

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a list of songs
        final ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song(R.string.song_one_title, R.string.song_one_artist, R.drawable.indieicon,
                0, R.string.song_one_details, R.drawable.indiegenrepic));

        songs.add(new Song(R.string.song_two_title, R.string.song_two_artist, R.drawable.indieicon,
                0, R.string.song_two_details, R.drawable.indiegenrepic));

        songs.add(new Song(R.string.song_three_title, R.string.song_three_artist, R.drawable.edmicon,
                0, R.string.song_three_details, R.drawable.edmgenrepic));

        songs.add(new Song(R.string.song_four_title, R.string.song_four_artist, R.drawable.edmicon,
                0, R.string.song_four_details, R.drawable.edmgenrepic));

        songs.add(new Song(R.string.song_five_title, R.string.song_five_artist, R.drawable.rockicon,
                0, R.string.song_five_details, R.drawable.rockgenrepic));

        // Create an {@link SongAdapter}, whose data source is a list of {@link Song}s. The
        // adapter knows how to create list items for each item in the list.
        SongAdapter adapter = new SongAdapter(this, songs, R.color.colorAccent);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = findViewById(R.id.list);

        // Make the {@link ListView} use the {@link SongAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Song} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Song} object at the given position the user clicked on
                // This Song instance will be passed to the "Now playing" screen.
                Song song = songs.get(position);
                playSongActivity(song);
            }
        });
    }

    public void playSongActivity(Song song){
        Intent i = new Intent(this, SongPlaying.class);
        ArrayList<Integer> songResources = new ArrayList<>();
        songResources.add(song.getSongTitle());
        songResources.add(song.getSongArtist());
        songResources.add(song.getGenreIcon());
        songResources.add(song.getAudioResourceId());
        songResources.add(song.getSongDetails());
        songResources.add(song.getGenreArt());
        i.putIntegerArrayListExtra("resources", songResources);
        startActivity(i);
    }
}
