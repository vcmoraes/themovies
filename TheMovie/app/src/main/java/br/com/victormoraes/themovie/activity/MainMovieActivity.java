package br.com.victormoraes.themovie.activity;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import br.com.victormoraes.themovie.R;
import br.com.victormoraes.themovie.adapter.PagerAdapterFragment;
import br.com.victormoraes.themovie.contract.MainMovieContract;
import br.com.victormoraes.themovie.fragment.MoviesFragmet;
import br.com.victormoraes.themovie.fragment.MoviesFragmet_;
import br.com.victormoraes.themovie.fragment.TabFragment;
import br.com.victormoraes.themovie.model.Genre;
import br.com.victormoraes.themovie.model.Movie;
import br.com.victormoraes.themovie.presenter.MainMoviePresenter;

@EActivity(R.layout.activity_main_movie)
public class MainMovieActivity extends BaseSubscribeActivity implements MainMovieContract.MainMovieView {

    @Bean
    MainMoviePresenter mainMoviePresenter;

    @ViewById
    TabLayout tabLayout;

    @ViewById
    ViewPager viewPager;

    @AfterViews
    public void init() {
        mainMoviePresenter.setView(this);
        tabLayout.setupWithViewPager(viewPager);
        getGenres();
    }

    private void getGenres() {
        showLoading(getString(R.string.search));
        mainMoviePresenter.getGenresMovie();
    }

    @Override
    public void onSucessGenres(@NonNull ArrayList<Genre> list) {
        setupTabs(list);
        hiddenLoading();
    }

    @Override
    public void onErrorGenres() {
        hiddenLoading();
        showDialogMessage(getResources().getString(R.string.error_dialog_retry), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getGenres();
            }
        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainMovieActivity.this.finish();
            }
        });
    }

    private void setupTabs(@NonNull ArrayList<Genre> list) {
        List<TabFragment> listFragments = new ArrayList<>();
        for (Genre genre : list) {
            MoviesFragmet moviesFragmet = MoviesFragmet_.builder().genre(genre).build();
            moviesFragmet.setTitle(genre.getName());
            listFragments.add(moviesFragmet);
        }
        viewPager.setOffscreenPageLimit(listFragments.size());
        viewPager.setAdapter(new PagerAdapterFragment(getSupportFragmentManager(), listFragments));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMovieSelected(Movie movie) {
        MovieSelectedActivity_.intent(this).movie(movie).start();
    }
}
