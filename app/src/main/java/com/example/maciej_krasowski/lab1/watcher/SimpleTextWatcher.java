package com.example.maciej_krasowski.lab1.watcher;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.maciej_krasowski.lab1.R;

public class SimpleTextWatcher implements TextWatcher {
    private final String textFieldName;
    private final Context context;

    public SimpleTextWatcher(String textFieldName, Context context) {
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
                    String.format(context.getString(R.string.validationToastMessage), textFieldName),
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
            submitButton.setVisibility(View.VISIBLE);
        } else {
            submitButton.setVisibility(View.INVISIBLE);
        }
    }
}
