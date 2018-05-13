package br.com.victormoraes.themovie.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import br.com.victormoraes.themovie.R;
import br.com.victormoraes.themovie.model.Movie;

@EActivity(R.layout.activity_movie_selected)
public class MovieSelectedActivity extends BaseActivity {

    @Extra
    Movie movie;

    @ViewById
    ImageView ivMovie;

    @ViewById
    TextView description;

    @AfterViews
    public void init() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(movie.getTitle().toUpperCase());
        }
        Picasso.with(this)
                .load(movie.getBackdropPath())
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(ivMovie, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {
                        Picasso.with(MovieSelectedActivity.this)
                                .load(movie.getBackdropPath())
                                .into(ivMovie);
                    }
                });
        description.setText(movie.getOverview());
    }
}
