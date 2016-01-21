package com.softdesign.school;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.softdesign.school.utils.Lg;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Lg.set_isEnabled(true);
        Lg.e("Lg:", "onCreateEvent");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Lg.e("Lg:", "onStartEvent");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Lg.e("Lg:", "onResumeEvent");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Lg.e("Lg:", "onPauseEvent");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Lg.e("Lg:", "onStopEvent");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Lg.e("Lg:", "onRestartEvent");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Lg.e("Lg:", "onDestroyEvent");
    }
}
