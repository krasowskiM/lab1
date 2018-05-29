package com.example.maciej_krasowski.lab1.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.maciej_krasowski.lab1.R;
import com.example.maciej_krasowski.lab1.model.Grade;

import java.util.List;


public class InteractiveArrayAdapter extends ArrayAdapter<Grade> {
    private List<Grade> grades;
    private Activity context;

    public InteractiveArrayAdapter(@NonNull Activity context, List<Grade> grades) {
        super(context, R.layout.activity_lab1, grades);
        this.context = context;
        this.grades = grades;
    }

//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        View childView = null;
//        if(convertView == null){
//
//        }
//    }
}
