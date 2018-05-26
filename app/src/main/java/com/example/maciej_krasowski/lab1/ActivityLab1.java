package com.example.maciej_krasowski.lab1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        button.setVisibility(View.INVISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    private void addTextChangeListeners() {
        final EditText nameText = findViewById(R.id.editText);
        final Toast validationMessage = Toast.makeText(ActivityLab1.this, "Wprowadz wartosc z przedzialu pomiedzy 5 a 15", Toast.LENGTH_SHORT);
        nameText
                .addTextChangedListener(new SimpleTextWatcher(nameText.getHint().toString(), ActivityLab1.this));
        EditText surnameText = findViewById(R.id.editText2);
        surnameText
                .addTextChangedListener(new SimpleTextWatcher(surnameText.getHint().toString(), ActivityLab1.this));
        final EditText gradeText = findViewById(R.id.editText3);
        gradeText
                .addTextChangedListener(new SimpleTextWatcher(gradeText.getHint().toString(), ActivityLab1.this));
        gradeText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                final String gradeValue = gradeText.getText().toString();
                if (!gradeValue.isEmpty()) {
                    int integerValue = Integer.parseInt(gradeValue);
                    if (isInCorrectRange(integerValue)) {
                        validationMessage.show();
                    }
                } else {
                    validationMessage.show();
                }
            }
        });

    }

    static boolean isInCorrectRange(int integerValue) {
        return integerValue <= 5 || integerValue >= 15;
    }
}
