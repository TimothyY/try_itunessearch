package example.com.try_itunessearch.basic_webservice;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import example.com.try_itunessearch.R;

public class BasicWebServiceActivity extends AppCompatActivity {

    Context mCtx;

    ImageView ivALbumArt;
    TextView tvTitle,tvAlbum,tvArtist;

    RequestQueue reqQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_web_service);

        mCtx = this;

        ivALbumArt = findViewById(R.id.ivAlbumArt);
        tvTitle = findViewById(R.id.tvTitle);
        tvAlbum = findViewById(R.id.tvAlbum);
        tvArtist = findViewById(R.id.tvArtist);

        reqQueue = Volley.newRequestQueue(mCtx);

        JsonObjectRequest iTunesSearchReq = new JsonObjectRequest(
                Request.Method.GET,
                "https://itunes.apple.com/search?term=onerepublic",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray allItems = response.getJSONArray("results");
                            JSONObject certainItem = (JSONObject) allItems.get(0);

                            String certainTitle = "";
                            try {certainTitle=certainItem.getString("trackName");}catch (Exception e){}
                            tvTitle.setText(certainTitle);

                            String certainAlbum = "";
                            try {certainAlbum=certainItem.getString("collectionName");}catch (Exception e){}
                            tvAlbum.setText(certainAlbum);

                            String certainArtist = "";
                            try {certainArtist=certainItem.getString("artistName");}catch (Exception e){}
                            tvArtist.setText(certainArtist);

                            String certainAlbumArtURL = "";
                            try {certainAlbumArtURL=certainItem.getString("artworkUrl100");}catch(Exception e){}
                            Picasso.with(mCtx).load(certainAlbumArtURL).into(ivALbumArt);

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
