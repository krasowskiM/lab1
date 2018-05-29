package com.example.maciej_krasowski.lab1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.maciej_krasowski.lab1.R;
import com.example.maciej_krasowski.lab1.watcher.SimpleTextWatcher;

public class ActivityLab1 extends AppCompatActivity {
    public static final int GRADE_PICK = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);
        handleButton();
        addListeners();
    }

    private boolean isInCorrectRange(int integerValue) {
        return integerValue <= 5 || integerValue >= 15;
    }

    private void handleButton() {
        Button button = findViewById(R.id.submit_1);
        button.setVisibility(View.INVISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText gradeControl = findViewById(R.id.editText3);
                String gradeNumber = gradeControl.getText().toString();
                if (!gradeNumber.isEmpty()) {
                    Intent submitIntent = new Intent(ActivityLab1.this, GradePickActivity.class);
                    submitIntent.putExtra(getString(R.string.gradeKey), gradeNumber);
                    startActivityForResult(submitIntent, GRADE_PICK);
                }
            }
        });
    }

    private void addListeners() {
        final EditText nameText = findViewById(R.id.editText);
        EditText surnameText = findViewById(R.id.editText2);
        final EditText gradeText = findViewById(R.id.editText3);
        final Toast validationMessage = Toast.makeText(ActivityLab1.this, R.string.gradeValueInfo, Toast.LENGTH_SHORT);
        nameText
                .addTextChangedListener(new SimpleTextWatcher(nameText.getHint().toString(), ActivityLab1.this));
        surnameText
                .addTextChangedListener(new SimpleTextWatcher(surnameText.getHint().toString(), ActivityLab1.this));
        gradeText
                .addTextChangedListener(new SimpleTextWatcher(gradeText.getHint().toString(), ActivityLab1.this));
        gradeText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                final String gradeValue = gradeText.getText().toString();
                if (!gradeValue.isEmpty()) {
                    int integerValue = Integer.parseInt(gradeValue);
                    if (!isInCorrectRange(integerValue)) {
                        validationMessage.show();
                    }
                } else {
                    validationMessage.show();
                }
            }
        });
    }
}
