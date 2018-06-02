package com.example.maciej_krasowski.lab1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.maciej_krasowski.lab1.R;
import com.example.maciej_krasowski.lab1.adapter.InteractiveArrayAdapter;
import com.example.maciej_krasowski.lab1.model.Grade;

import java.util.ArrayList;
import java.util.List;

public class GradePickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grade_pick_act);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String gradeNumber = extras.getString(getString(R.string.gradeKey));
            int numbers = Integer.parseInt(gradeNumber);
            final List<Grade> grades = new ArrayList<>();
            for(int i = 1; i < numbers; i++){
                grades.add(new Grade("ocena " + i));
            }
            InteractiveArrayAdapter interactiveArrayAdapter = new InteractiveArrayAdapter(this, grades);
            ListView gradesList = findViewById(R.id.gradeListView);
            gradesList.setAdapter(interactiveArrayAdapter);
            Button submitButton = findViewById(R.id.submit_2);
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int sum = 0;
                    for (Grade grade : grades) {
                        sum += grade.getValue();
                    }
                    double average = sum / grades.size();
                    Bundle bundle = new Bundle();
                    bundle.putDouble("srednia", average);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        }
    }
}
