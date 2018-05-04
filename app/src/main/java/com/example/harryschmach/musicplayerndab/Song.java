package com.example.harryschmach.musicplayerndab;

public class Song {

    /** String resource ID for the song title */
    private int mSongTitle;

    /** String resource ID for the song Artist */
    private int mSongArtist;

    /** Theoretical Audio resource ID for the song */
    private int mAudioResourceId;

    /** Image resource ID for the genre icon of the song */
    private int mGenreIcon;

    /** Image resource ID for the genre picture of the song */
    private int mGenreArt;

    /** String resource ID for the details about the song song */
    private int mSongDetails;

    /**
     * Create a new Song object.
     *
     * @param songTitle is the string resource ID for the song title
     * @param songArtist is the string resource Id for the song artist
     * @param genreIcon is the drawable resource ID for the image associated with the word
     * @param songAudio is the resource ID for the audio file associated with this word
     * @param songDetails is the resource ID for the songs details
     * @param genreArt is the image to be used in song playing activity
     */
    public Song(int songTitle, int songArtist, int genreIcon,
                int songAudio, int songDetails, int genreArt) {
        mSongTitle = songTitle;
        mSongArtist = songArtist;
        mGenreIcon = genreIcon;
        mAudioResourceId = songAudio;
        mSongDetails = songDetails;
        mGenreArt = genreArt;
    }

    /**
     * Get the string resource ID for the song title.
     */
    public int getSongTitle() {
        return mSongTitle;
    }

    /**
     * Get the string resource ID for the song Artist.
     */
    public int getSongArtist() {
        return mSongArtist;
    }

    /**
     * Return the image resource ID of the word. An Icon of the music genre.
     */
    public int getGenreIcon() {
        return mGenreIcon;
    }

    public int getGenreArt(){
        return mGenreArt;
    }

    /**
     * Return the audio resource ID of the song.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }

    /**
     * Return the song details.
     */
    public int getSongDetails(){
        return mSongDetails;
    }
}
