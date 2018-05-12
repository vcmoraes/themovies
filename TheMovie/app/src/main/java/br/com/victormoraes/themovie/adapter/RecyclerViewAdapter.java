package br.com.victormoraes.themovie.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import br.com.victormoraes.themovie.viewholder.ViewHolderBind;

public class RecyclerViewAdapter<M> extends RecyclerView.Adapter<ViewHolderBind<M>> {

    private final ArrayList<M> list;
    private final Class<?> type;

    public RecyclerViewAdapter(@NonNull Class<? extends ViewHolderBind<M>> type, @NonNull ArrayList<M> list) {
        this.type = type;
        this.list = list;
    }

    @Override
    public ViewHolderBind<M> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return create(parent);
    }

    @Override
    public void onBindViewHolder(ViewHolderBind<M> holder, int position) {
        holder.onBindViewHolder(list.get(position), position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private ViewHolderBind<M> create(ViewGroup viewGroup) {
        try {
            ViewHolderBind<M> viewHolder = (ViewHolderBind<M>) type.getDeclaredConstructor(viewGroup.getClass()).newInstance(viewGroup);
            return viewHolder;
        } catch (Exception ignore) {
            ignore.printStackTrace();
            return null;
        }
    }
}
