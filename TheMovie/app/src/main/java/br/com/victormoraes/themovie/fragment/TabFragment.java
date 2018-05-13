package br.com.victormoraes.themovie.fragment;

import android.support.annotation.NonNull;

import org.androidannotations.annotations.EBean;

import br.com.victormoraes.themovie.util.StringUtil;

@EBean
public abstract class TabFragment extends BaseSubscriberFragment {

    private String title;

    @NonNull
    public String getTitle() {
        return StringUtil.fixString(title);
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
