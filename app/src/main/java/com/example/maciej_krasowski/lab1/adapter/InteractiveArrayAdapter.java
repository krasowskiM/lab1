package com.example.maciej_krasowski.lab1.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.maciej_krasowski.lab1.R;
import com.example.maciej_krasowski.lab1.model.Grade;

import java.util.List;


public class InteractiveArrayAdapter extends ArrayAdapter<Grade> {
    private List<Grade> grades;
    private Activity context;

    public InteractiveArrayAdapter(@NonNull Activity context, List<Grade> grades) {
        super(context, R.layout.grade_pick_act, grades);
        this.context = context;
        this.grades = grades;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View childView;
        final Grade grade = grades.get(position);
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            childView = inflater.inflate(R.layout.grade_pick_act, null);
            final RadioGroup gradeButtonGroup = childView.findViewById(R.id.buttonGroup);
            final View finalChildView = childView;
            gradeButtonGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RadioGroup groupWithTag = finalChildView.findViewWithTag(grade);
                    int checkedRadioButtonId = groupWithTag.getCheckedRadioButtonId();
                    RadioButton checkedButton = groupWithTag.findViewById(checkedRadioButtonId);
                    CharSequence checkedButtonText = checkedButton.getText();
                    int checkedValue = Integer.parseInt(String.valueOf(checkedButtonText));
                    grade.setValue(checkedValue);
                }
            });
            gradeButtonGroup.setTag(grade);
        } else {
            childView = convertView;
            RadioGroup gradeButtonGroup = childView.findViewById(R.id.buttonGroup);
            gradeButtonGroup.setTag(grade);
        }

        TextView label = childView.findViewById(R.id.groupLabel);
        label.setText(grade.getName());
        RadioGroup gradeGroup = childView.findViewById(R.id.buttonGroup);
        RadioButton gradeButton = gradeGroup.findViewWithTag(grade);
        gradeGroup.check(gradeButton.getId());

        return childView;
    }
}
