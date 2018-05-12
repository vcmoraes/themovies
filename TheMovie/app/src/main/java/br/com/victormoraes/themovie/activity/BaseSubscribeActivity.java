package br.com.victormoraes.themovie.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;

import org.androidannotations.annotations.EBean;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import br.com.victormoraes.core.exceptions.NetworkingProblems;
import br.com.victormoraes.themovie.R;

@EBean
public class BaseSubscribeActivity extends BaseActivity {

    private DialogInterface.OnClickListener onPositiveButton;
    private DialogInterface.OnClickListener onNegativeButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNetworkingProblems(NetworkingProblems networkingProblems) {
        hiddenLoading();
        if (onNegativeButton == null && onPositiveButton == null) {
            showDialogMessage(getResources().getString(R.string.internet_error));
        } else if (onNegativeButton == null) {
            showDialogMessage(getResources().getString(R.string.internet_error), onPositiveButton);
        } else {
            showDialogMessage(getResources().getString(R.string.internet_error), onPositiveButton, onNegativeButton);
        }
    }

    public void setInternetCallback(@Nullable DialogInterface.OnClickListener onPositiveButton, @Nullable DialogInterface.OnClickListener onNegativeButton) {
        this.onPositiveButton = onPositiveButton;
        this.onNegativeButton = onNegativeButton;
    }
}
