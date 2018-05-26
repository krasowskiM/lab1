package com.example.maciej_krasowski.lab1;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;


/**
 * Created by student on 26.05.18.
 */

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
        int idGradeNum = R.string.liczba_ocen;
        String gradeText = context.getString(idGradeNum);
        if (charSequence.length() == 0) {
            Toast toast =
                    Toast.makeText(context,
                            "Field " + textFieldName + " cannot be empty",
                            Toast.LENGTH_SHORT);
            toast.show();
        }
        if(gradeText.equals(textFieldName)){
            String value = charSequence.toString();

        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
