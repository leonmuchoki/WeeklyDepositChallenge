package com.example.weekchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewDepositActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.weekchallenge.REPLY";

    private EditText mEditAmountView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_deposit);

        mEditAmountView = findViewById(R.id.edit_amount);
        mEditAmountView.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "50000000")});

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditAmountView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    Double deposit_amount = Double.parseDouble(mEditAmountView.getText().toString());
                    replyIntent.putExtra(EXTRA_REPLY, deposit_amount);

                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
