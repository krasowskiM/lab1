package com.example.maciej_krasowski.lab1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Context.POWER_SERVICE;
import static com.example.maciej_krasowski.lab1.ActivityLab1.isInCorrectRange;


/**
 * Created by student on 26.05.18.
 */

public class SimpleTextWatcher implements TextWatcher {
    private final String textFieldName;
    private final Context context;

    SimpleTextWatcher(String textFieldName, Context context) {
        this.textFieldName = textFieldName;
        this.context = context;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (charSequence.length() == 0) {
            Toast toast = Toast.makeText(context,
                    "Pole " + textFieldName + " nie moze byc puste",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {
        EditText name = ((AppCompatActivity) context).findViewById(R.id.editText);
        EditText surname = ((AppCompatActivity) context).findViewById(R.id.editText2);
        EditText grade = ((AppCompatActivity) context).findViewById(R.id.editText3);
        Button submitButton = ((AppCompatActivity) context).findViewById(R.id.submit_1);

        String nameValue = name.getText().toString();
        String surnameValue = surname.getText().toString();
        String gradeValue = grade.getText().toString();
        if (!nameValue.isEmpty() && !surnameValue.isEmpty() && !gradeValue.isEmpty()) {
            int integerGrade = Integer.parseInt(gradeValue);
            if (isInCorrectRange(integerGrade)) {
                submitButton.setVisibility(View.VISIBLE);
            } else {
                submitButton.setVisibility(View.INVISIBLE);
            }
        } else {
            submitButton.setVisibility(View.INVISIBLE);
        }
    }
}
