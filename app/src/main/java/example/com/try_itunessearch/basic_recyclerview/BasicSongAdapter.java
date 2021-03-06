package example.com.try_itunessearch.basic_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import example.com.try_itunessearch.R;
import example.com.try_itunessearch.Song;

/**
 * Created by User on 2/7/2018.
 */

class BasicSongAdapter extends RecyclerView.Adapter {

    Context mCtx;
    ArrayList<Song> songs;

    public BasicSongAdapter(Context mCtx, ArrayList<Song> songs) {
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
        Song song = (Song)songs.get(position);
        ((SongViewHolder)holder).tvTitle.setText(song.title);
        ((SongViewHolder)holder).tvAlbum.setText(song.album);
        ((SongViewHolder)holder).tvArtist.setText(song.artist);
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle,tvAlbum,tvArtist;

        public SongViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAlbum = itemView.findViewById(R.id.tvAlbum);
            tvArtist = itemView.findViewById(R.id.tvArtist);
        }

    }
}
