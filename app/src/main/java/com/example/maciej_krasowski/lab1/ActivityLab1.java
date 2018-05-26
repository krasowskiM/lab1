package com.example.maciej_krasowski.lab1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityLab1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);
        handleButton();
        addTextChangeListeners();
    }

    private void handleButton() {
        Button button = findViewById(R.id.submit_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    private void addTextChangeListeners() {
        final EditText nameText = findViewById(R.id.editText);
        nameText
                .addTextChangedListener(new SimpleTextWatcher(nameText.getHint().toString(), ActivityLab1.this));
        EditText surnameText = findViewById(R.id.editText2);
        surnameText
                .addTextChangedListener(new SimpleTextWatcher(surnameText.getHint().toString(), ActivityLab1.this));
        EditText gradeText = findViewById(R.id.editText3);
        surnameText
                .addTextChangedListener(new SimpleTextWatcher(gradeText.getHint().toString(), ActivityLab1.this));
    }
}
