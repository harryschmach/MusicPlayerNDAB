package com.example.harryschmach.musicplayerndab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Retrieve the intent carrying the resource integer pointing to the song details
        Intent detailsFromIntent = getIntent();
        Integer details = detailsFromIntent.getIntExtra("song_details", 0);
        TextView detailsTV = findViewById(R.id.details_tv_in_details_activity);
        // Set the textView to the details
        detailsTV.setText(details);
    }
}
