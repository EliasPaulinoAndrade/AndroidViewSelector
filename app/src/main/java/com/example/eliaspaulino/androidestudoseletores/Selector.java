package com.example.eliaspaulino.androidestudoseletores;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elias Paulino on 02/11/2017.
 */

public class Selector {
    private List<View> views;

    public Selector() {
        this.views = new ArrayList<>();
    }
    public Selector findFarByClass(ViewGroup parent, Class<? extends View> type){
        View view;
        for(int ct = 0; ct < parent.getChildCount(); ct++){
            view = parent.getChildAt(ct);
            if(type.isInstance(view)){
                views.add(view);
            }
            if(view instanceof ViewGroup){
                findFarByClass((ViewGroup) view, type);
            }
        }
        return this;
    }
    public Selector findFarByClass(Class<? extends View> type){
        Selector selector = new Selector();
        for(View view : views){
            if (view instanceof ViewGroup){
                selector.findFarByClass((ViewGroup) view, type);
            }
        }
        return selector;
    }
    public Selector findNearByClass(ViewGroup parent, Class<? extends View> type){
        View view;
        for(int ct = 0; ct < parent.getChildCount(); ct++){
            view = parent.getChildAt(ct);
            if(type.isInstance(view)){
                views.add(view);
            }
        }
        return this;
    }
    public Selector findNearByClass(Class<? extends View> type){
        Selector selector = new Selector();
        for(View view : views){
            if (view instanceof ViewGroup){
                selector.findNearByClass((ViewGroup) view, type);
            }
        }
        return selector;
    }
    public List<View> getViews() {
        return views;
    }

    public void setViews(List<View> views) {
        this.views = views;
    }
}
