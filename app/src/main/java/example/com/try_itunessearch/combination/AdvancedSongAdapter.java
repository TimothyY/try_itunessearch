package example.com.try_itunessearch.combination;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import example.com.try_itunessearch.R;
import example.com.try_itunessearch.Song;

/**
 * Created by User on 2/7/2018.
 */

class AdvancedSongAdapter extends RecyclerView.Adapter {

    Context mCtx;
    ArrayList<Song> songs;

    public AdvancedSongAdapter(Context mCtx, ArrayList<Song> songs) {
        this.mCtx=mCtx;
        this.songs=songs;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_song,parent,false);
        return new SongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Song song = (Song)songs.get(position);


        ((SongViewHolder)holder).cvSong.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mCtx, song.title+" card is clicked", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        try{
            Picasso.with(mCtx).load(song.albumArtUrl).into(((SongViewHolder)holder).ivAlbumArt);
        }catch(Exception e){}

        ((SongViewHolder)holder).tvTitle.setText(song.title);
        ((SongViewHolder)holder).tvTitle.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mCtx, song.title+" title is clicked", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        ((SongViewHolder)holder).tvAlbum.setText(song.album);

        ((SongViewHolder)holder).tvArtist.setText(song.artist);

    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder{

        CardView cvSong;
        ImageView ivAlbumArt;
        TextView tvTitle,tvAlbum,tvArtist;

        public SongViewHolder(View itemView) {
            super(itemView);
            cvSong = itemView.findViewById(R.id.cvSong);
            ivAlbumArt = itemView.findViewById(R.id.ivAlbumArt);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAlbum = itemView.findViewById(R.id.tvAlbum);
            tvArtist = itemView.findViewById(R.id.tvArtist);
        }

    }
}
