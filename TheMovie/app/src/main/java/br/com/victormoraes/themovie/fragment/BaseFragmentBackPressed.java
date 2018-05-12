package br.com.victormoraes.themovie.fragment;

import br.com.victormoraes.themovie.interfaces.OnBackPressedFragment;
import br.com.victormoraes.themovie.listerner.OnBackPressedFragmentListener;


public abstract class BaseFragmentBackPressed extends BaseFragment implements OnBackPressedFragment {

    @Override
    public void onResume() {
        super.onResume();
        OnBackPressedFragmentListener.getInstance().addOnBackPressedListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        OnBackPressedFragmentListener.getInstance().removeOnBackPressedListener(this);
    }
}
