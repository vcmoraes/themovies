package br.com.victormoraes.themovie.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;

public class ListPagination<MODEL> {

    private ArrayList<MODEL> list;
    private boolean hasMoreItens;

    @NonNull
    public ArrayList<MODEL> getList() {
        if (list == null) {
            list = new ArrayList<>();
        }
        return list;
    }

    public void setList(ArrayList<MODEL> list) {
        this.list = list;
    }

    public boolean isHasMoreItens() {
        return hasMoreItens;
    }

    public void setHasMoreItens(boolean hasMoreItens) {
        this.hasMoreItens = hasMoreItens;
    }
}
