package example.com.try_itunessearch.combination;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import example.com.try_itunessearch.R;
import example.com.try_itunessearch.Song;

public class ItunesSearchActivity extends AppCompatActivity {

    Context mCtx;
    RequestQueue reqQueue;
    RecyclerView rvSongs;
    RecyclerView.LayoutManager rvLayoutManager;
    RecyclerView.Adapter songAdapter;

    ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itunes_search);

        mCtx = this;

        reqQueue = Volley.newRequestQueue(mCtx);

        rvSongs = findViewById(R.id.rvSongs);
        rvLayoutManager = new LinearLayoutManager(mCtx);
        rvSongs.setLayoutManager(rvLayoutManager);

        songs = new ArrayList<>();

        JsonObjectRequest iTunesSearchReq = new JsonObjectRequest(
                Request.Method.GET,
                "https://itunes.apple.com/search?term=onerepublic",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray allItems = response.getJSONArray("results");

                            for(int i=0;i<allItems.length();i++){

                                JSONObject certainItem = (JSONObject) allItems.get(i);

                                String certainTitle = "";
                                try {certainTitle=certainItem.getString("trackName");}catch (Exception e){}

                                String certainAlbum = "";
                                try {certainAlbum=certainItem.getString("collectionName");}catch (Exception e){}

                                String certainArtist = "";
                                try {certainArtist=certainItem.getString("artistName");}catch (Exception e){}

                                String certainAlbumArtURL = "";
                                try {certainAlbumArtURL=certainItem.getString("artworkUrl100");}catch(Exception e){}

                                Song song = new Song(certainTitle,certainAlbum,certainArtist,certainAlbumArtURL);
                                songs.add(song);
                            }

                            songAdapter = new AdvancedSongAdapter(mCtx,songs);
                            rvSongs.setAdapter(songAdapter);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        reqQueue.add(iTunesSearchReq);

    }
}
