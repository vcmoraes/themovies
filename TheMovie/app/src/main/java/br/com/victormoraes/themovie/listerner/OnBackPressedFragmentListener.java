package br.com.victormoraes.themovie.listerner;

import java.util.HashSet;
import java.util.Set;

import br.com.victormoraes.themovie.interfaces.OnBackPressedFragment;

public class OnBackPressedFragmentListener {

    private static OnBackPressedFragmentListener instance;
    private Set<OnBackPressedFragment> listeners;

    private OnBackPressedFragmentListener() {
        this.listeners = new HashSet<>();
    }

    public static OnBackPressedFragmentListener getInstance() {
        if (instance == null) {
            instance = new OnBackPressedFragmentListener();
        }
        return instance;
    }

    public void clearAllListerners() {
        if (listeners != null) {
            listeners.clear();
        }
    }

    public void addOnBackPressedListener(OnBackPressedFragment onBackPressedFragment) {
        this.listeners.add(onBackPressedFragment);
    }

    public void removeOnBackPressedListener(OnBackPressedFragment onBackPressedFragment) {
        this.listeners.remove(onBackPressedFragment);
    }

    public boolean dispatchOnBackPressed() {
        try {
            OnBackPressedFragment[] array = listeners.toArray(new OnBackPressedFragment[listeners.size()]);
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i].onBackPressed()) {
                    return true;
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return false;
    }
}
