package com.softdesign.school;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.softdesign.school.utils.Lg;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String VISIBLE_KEY = "visible";

    private CheckBox mCheckBox;
    private EditText mEditText1;
    private EditText mEditText2;
    private Button mButtonBlue;
    private Button mButtonRed;
    private Button mButtonGreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Домашняя заготовка 2");

        Lg.set_isEnabled(true);
        Lg.e(this.getLocalClassName(), "onCreateEvent");

        mCheckBox = (CheckBox) findViewById(R.id.checkBox);
        mCheckBox.setOnClickListener(this);
        mEditText1 = (EditText) findViewById(R.id.input_first);
        mEditText2 = (EditText) findViewById(R.id.input_second);
        mButtonBlue = (Button) findViewById(R.id.button_blue);
        mButtonBlue.setOnClickListener(this);
        mButtonRed = (Button) findViewById(R.id.button_red);
        mButtonRed.setOnClickListener(this);
        mButtonGreen = (Button) findViewById(R.id.button_green);
        mButtonGreen.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.checkBox:
                if (mCheckBox.isChecked()) {
                    Toast.makeText(MainActivity.this, "Аз есьм гость", Toast.LENGTH_SHORT).show();
                    mEditText2.setVisibility(View.INVISIBLE);
                } else {
                    mEditText2.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.button_blue:
                break;
            case R.id.button_red:
                break;
            case R.id.button_green:
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Lg.e(this.getLocalClassName(), "onStartEvent");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Lg.e(this.getLocalClassName(), "onResumeEvent");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Lg.e(this.getLocalClassName(), "onPauseEvent");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Lg.e(this.getLocalClassName(), "onStopEvent");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Lg.e(this.getLocalClassName(), "onRestartEvent");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Lg.e(this.getLocalClassName(), "onDestroyEvent");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Lg.e(this.getLocalClassName(), "onSaveInstanceStateEvent");
        outState.putBoolean(VISIBLE_KEY, mEditText2.getVisibility() == View.VISIBLE);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Lg.e(this.getLocalClassName(), "onRestoreInstanceState");
        mEditText2.setVisibility(savedInstanceState.getBoolean(VISIBLE_KEY) ? View.VISIBLE : View.INVISIBLE);
    }
}
