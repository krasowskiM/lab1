package com.example.maciej_krasowski.lab1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maciej_krasowski.lab1.R;
import com.example.maciej_krasowski.lab1.watcher.SimpleTextWatcher;

import java.math.BigDecimal;

public class ActivityLab1 extends AppCompatActivity {
    public static final int GRADE_PICK = 1;
    private TextView textAverage;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);
        handleButton();
        addListeners();
        handleTextView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                double average = extras.getDouble("srednia");
                BigDecimal avg = BigDecimal.valueOf(average);
                final BigDecimal scaled = avg.setScale(2, BigDecimal.ROUND_HALF_UP);
                textAverage.setText(String.format(getString(R.string.average), scaled.toPlainString()));
                if(scaled.compareTo(BigDecimal.valueOf(3)) >= 0) {
                    submitButton.setText("Super :)");
                } else {
                    submitButton.setText("Tym razem Ci nie poszlo.");
                }
                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(scaled.compareTo(BigDecimal.valueOf(3)) >= 0) {
                            Toast.makeText(ActivityLab1.this, "Gratulacje! Otrzymujesz zaliczenie!", Toast.LENGTH_SHORT);
                        } else {
                            Toast.makeText(ActivityLab1.this, "Wysylam podanie o zaliczenie warunkowe.", Toast.LENGTH_SHORT);
                        }
                        finish();
                    }
                });
            }
        }
    }

    private void handleTextView() {
        textAverage = findViewById(R.id.textAverage);
        textAverage.setVisibility(View.INVISIBLE);
    }

    private void handleButton() {
        submitButton = findViewById(R.id.submit_1);
        submitButton.setVisibility(View.INVISIBLE);
        submitButton.setOnClickListener(new View.OnClickListener() {
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

    private boolean isInCorrectRange(int integerValue) {
        return integerValue <= 5 || integerValue >= 15;
    }
}
