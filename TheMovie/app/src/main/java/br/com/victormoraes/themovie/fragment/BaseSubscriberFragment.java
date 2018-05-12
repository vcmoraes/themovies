package br.com.victormoraes.themovie.fragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import br.com.victormoraes.core.exceptions.NetworkingProblems;

public abstract class BaseSubscriberFragment extends BaseFragment {

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNetworkingProblems(NetworkingProblems networkingProblems) {
        hiddenLoading();
    }
}
