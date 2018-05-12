package br.com.victormoraes.themovie.fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EBean;
import org.greenrobot.eventbus.EventBus;

@EBean
public abstract class BaseFragment extends Fragment {

    private boolean init;

    public abstract void initFragment();

    private ProgressDialog progressDialog;

    public void showLoading(@NonNull String men) {
        if (progressDialog == null && getActivity() != null) {
            progressDialog = ProgressDialog.show(getActivity(), "", men);
        }
    }

    public void hiddenLoading() {
        if (progressDialog != null && getActivity() != null && progressDialog.isShowing() && !getActivity().isFinishing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    @AfterViews
    public void init() {
        if (getUserVisibleHint() && !init) {
            init = true;
            initF();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && !init) {
            initF();
        }
    }

    private void initF() {
        try {
            initFragment();
            init = true;
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }

    public void post(Object event) {
        EventBus.getDefault().post(event);
    }

    public static Fragment instantiateWithArgs(final Context context, final Fragment f) {
        final Fragment fragment = instantiate(context, f.getClass().getName());
        fragment.setArguments(f.getArguments());
        return fragment;
    }

    public void showDialogMessage(String men) {
        showDialogMessage(null, men, null);
    }

    public void showDialogMessage(String men, DialogInterface.OnClickListener onClickListener) {
        showDialogMessage(null, men, onClickListener);
    }

    public void showDialogMessage(String title, String men) {
        showDialogMessage(title, men, null);
    }

    public void showDialogMessage(String title, String men, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setTitle(title)
                .setMessage(men)
                .setPositiveButton(android.R.string.ok, onClickListener)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setCancelable(false)
                .show();
    }
}
