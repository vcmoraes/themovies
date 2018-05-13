package br.com.victormoraes.themovie.fragment;

import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

import br.com.victormoraes.themovie.R;
import br.com.victormoraes.themovie.adapter.RecyclerViewAdapter;
import br.com.victormoraes.themovie.contract.MoviesContract;
import br.com.victormoraes.themovie.model.Genre;
import br.com.victormoraes.themovie.model.ListPagination;
import br.com.victormoraes.themovie.model.Movie;
import br.com.victormoraes.themovie.presenter.MoviesPresenter;
import br.com.victormoraes.themovie.viewholder.MovieViewHolder;

@EFragment(R.layout.fragment_movies)
public class MoviesFragmet extends TabFragment implements MoviesContract.MoviesView {

    @FragmentArg
    Genre genre;

    @Bean
    MoviesPresenter presenter;

    @ViewById
    SwipeRefreshLayout swipeRefresh;

    @ViewById
    RecyclerView rvMovies;

    private ArrayList<Movie> movies = new ArrayList<>();
    private RecyclerViewAdapter<Movie> moviesAdapter = new RecyclerViewAdapter<>(MovieViewHolder.class, movies);
    private GridLayoutManager gridLayoutManager;

    private int page = 0;
    private boolean hasMoreItens = true;
    private boolean hasRequest = false;

    @Override
    public void initFragment() {
        presenter.setView(this);
        initViews();
        getMovies();
    }

    private void initViews() {
        gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rvMovies.setLayoutManager(gridLayoutManager);
        rvMovies.setAdapter(moviesAdapter);
        rvMovies.addOnScrollListener(onScrollListener);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (page == 0) {
                    getMovies();
                } else {
                    swipeRefresh.setRefreshing(false);
                }
            }
        });
    }

    private void getMovies() {
        if (!hasRequest) {
            hasRequest = true;
            if (page == 0) {
                swipeRefresh.setRefreshing(true);
            }
            presenter.getMovies(genre.getId(), page + 1);
        }
    }

    @Override
    public void onSucessMovies(@NonNull ListPagination<Movie> list) {
        hasMoreItens = !list.getList().isEmpty() && list.isHasMoreItens();
        movies.addAll(list.getList());
        moviesAdapter.notifyDataSetChanged();
        swipeRefresh.setRefreshing(false);
        page++;
        hasRequest = false;
    }

    @Override
    public void onErrorMovies() {
        swipeRefresh.setRefreshing(false);
        hasRequest = false;
    }

    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int visibleItemCount = gridLayoutManager.getChildCount();
            int totalItemCount = gridLayoutManager.getItemCount();
            int firstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
            if (hasMoreItens && !hasRequest && (visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                    && firstVisibleItemPosition >= 0
                    && totalItemCount >= movies.size() / 2) {
                getMovies();
            }
        }
    };
}
