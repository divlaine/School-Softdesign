package com.softdesign.school;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.softdesign.school.utils.Lg;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String VISIBLE_KEY = "visible";
    public static final String TOOLBAR_COLOR = "0x3F51B5";
    public static final String STATUSBAR_COLOR = "0x000000";

    private static int mHeaderColor = -1;
    private static int mStatusBarColor = -1;

    private CheckBox mCheckBox;
    private EditText mEditText1;
    private EditText mEditText2;
    private Button mButtonBlue;
    private Button mButtonRed;
    private Button mButtonGreen;
    private Toolbar mToolbar;

    /** Листенер create-события*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lg.set_isEnabled(true);
        Lg.e(this.getLocalClassName(), "onCreateEvent");

        mHeaderColor = getResources().getColor(R.color.colorPrimary);
        mStatusBarColor = getResources().getColor(R.color.colorPrimaryDark);

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
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setupToolbar();
    }

    /** настройка тулбара*/
    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Home task 2");
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
        }
        setColors();
    }

    /** настройка клика на меню ("бутерброд")*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Toast.makeText(MainActivity.this, "OptionsClickEvent", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    /** обработчик кликов на чекбокс и кнопки*/
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
            case R.id.button_red:
                mHeaderColor = getResources().getColor(R.color.red);
                mStatusBarColor = getResources().getColor(R.color.red_dark);
                setColors();
                break;
            case R.id.button_green:
                mHeaderColor = getResources().getColor(R.color.green);
                mStatusBarColor = getResources().getColor(R.color.green_dark);
                setColors();
                break;
            case R.id.button_blue:
                mHeaderColor = getResources().getColor(R.color.blue);
                mStatusBarColor = getResources().getColor(R.color.blue_dark);
                setColors();
                break;
        }
    }

    /** Задание цветов*/
    private void setColors() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(mHeaderColor));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            if (window != null) {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(mStatusBarColor);
            }
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

    /** Обработка перед переворотом экрана*/
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Lg.e(this.getLocalClassName(), "onSaveInstanceStateEvent");
        outState.putBoolean(VISIBLE_KEY, mEditText2.getVisibility() == View.VISIBLE);
        outState.putInt(TOOLBAR_COLOR, mHeaderColor);
        outState.putInt(STATUSBAR_COLOR, mStatusBarColor);
    }

    /** Восстановление значений после переворота экрана*/
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Lg.e(this.getLocalClassName(), "onRestoreInstanceState");
        mEditText2.setVisibility(savedInstanceState.getBoolean(VISIBLE_KEY) ? View.VISIBLE : View.INVISIBLE);
        ActionBar actionBar = getSupportActionBar();
        mHeaderColor = savedInstanceState.getInt(TOOLBAR_COLOR);
        mStatusBarColor = savedInstanceState.getInt(STATUSBAR_COLOR);
        setColors();
    }
}
