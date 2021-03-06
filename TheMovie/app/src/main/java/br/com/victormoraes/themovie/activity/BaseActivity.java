package br.com.victormoraes.themovie.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import org.androidannotations.annotations.EBean;
import org.greenrobot.eventbus.EventBus;

import br.com.victormoraes.themovie.R;

@EBean
public class BaseActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;

    public void post(Object event) {
        EventBus.getDefault().post(event);
    }

    public void showDialogMessage(String men) {
        showDialogMessage(null, men, null, null);
    }

    public void showDialogMessage(String men, DialogInterface.OnClickListener positiveButtonListerner) {
        showDialogMessage(null, men, positiveButtonListerner, null);
    }

    public void showDialogMessage(String men, DialogInterface.OnClickListener positiveButtonListerner, DialogInterface.OnClickListener negativeButtonListerner) {
        showDialogMessage(null, men, positiveButtonListerner, negativeButtonListerner);
    }

    public void showDialogMessage(String title, String men) {
        showDialogMessage(title, men, null, null);
    }

    public void showDialogMessage(String title, String men, DialogInterface.OnClickListener positiveButtonListerner, DialogInterface.OnClickListener negativeButtonListerner) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(men)
                .setPositiveButton(android.R.string.ok, positiveButtonListerner)
                .setIcon(android.R.drawable.ic_dialog_alert);
        builder.setCancelable(false);
        if (negativeButtonListerner != null) {
            builder.setNegativeButton(android.R.string.no, negativeButtonListerner);
        }
        builder.show();
    }

    public void showLoading(@NonNull String men) {
        if (progressDialog == null) {
            progressDialog = ProgressDialog.show(this, "", men);
        }
    }

    public void hiddenLoading() {
        if (progressDialog != null && progressDialog.isShowing() && !isFinishing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
            window.setNavigationBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }
    }
}

