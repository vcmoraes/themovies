package br.com.victormoraes.themovie.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import br.com.victormoraes.themovie.fragment.TabFragment;

public class PagerAdapterFragment extends FragmentStatePagerAdapter {

    private List<? extends Fragment> fragments;

    public PagerAdapterFragment(FragmentManager fm, List<? extends Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Fragment fragment = fragments.get(position);
        if (fragment instanceof TabFragment) {
            return ((TabFragment) fragment).getTitle();
        }
        return super.getPageTitle(position);
    }
}
