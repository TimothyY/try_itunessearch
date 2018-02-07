package example.com.try_itunessearch.basic_recyclerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import example.com.try_itunessearch.R;
import example.com.try_itunessearch.Song;

public class BasicRecyclerViewActivity extends AppCompatActivity {

    Context mCtx;
    RecyclerView rvSongs;
    RecyclerView.LayoutManager rvLayoutManager;
    RecyclerView.Adapter songAdapter;

    ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_recycler_view);

        rvSongs = findViewById(R.id.rvSongs);
        rvLayoutManager = new LinearLayoutManager(mCtx);
        rvSongs.setLayoutManager(rvLayoutManager);

        songs = new ArrayList<>();

        //add dummy data
        Song song01 = new Song("title01","album01","artist01","albumArt01");
        songs.add(song01);
        Song song02 = new Song("title02","album02","artist02","albumArt02");
        songs.add(song02);
        songs.add(new Song("title03","album03","artist03","albumArt03"));


        songAdapter = new BasicSongAdapter(mCtx,songs);
        rvSongs.setAdapter(songAdapter);
    }
}
