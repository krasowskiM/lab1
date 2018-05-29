package com.example.maciej_krasowski.lab1.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.maciej_krasowski.lab1.R;

public class GradePickActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String gradeNumber = extras.getString(getString(R.string.gradeKey));

        }

    }
}
