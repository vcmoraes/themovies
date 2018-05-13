package br.com.victormoraes.themovie.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import br.com.victormoraes.themovie.R;
import br.com.victormoraes.themovie.model.Movie;

public class MovieViewHolder extends ViewHolderBind<Movie> {

    private ImageView ivMovie;

    public MovieViewHolder(RecyclerView parent) {
        super(parent, R.layout.item_movie);
        ivMovie = itemView.findViewById(R.id.iv_movie);
    }

    @Override
    public void onBindViewHolder(final Movie movie, final int position) {
        Picasso.with(itemView.getContext())
                .load(movie.getPoster())
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(ivMovie, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {
                        Picasso.with(itemView.getContext())
                                .load(movie.getPoster())
                                .into(ivMovie);
                    }
                });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(movie);
            }
        });
    }
}
