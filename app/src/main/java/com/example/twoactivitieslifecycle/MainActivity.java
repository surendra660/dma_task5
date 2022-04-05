package com.example.twoactivitieslifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.view_count);
        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt("count");
            mShowCount.setText("" + mCount);
        }

    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        EditText text = findViewById(R.id.EditText);
        CharSequence data = text.getText();
        outState.putCharSequence("data", data);
        outState.putInt("count", mCount);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        CharSequence data = savedInstanceState.getCharSequence("data");
        EditText text = findViewById(R.id.EditText);
        text.setText(data);
    }
}