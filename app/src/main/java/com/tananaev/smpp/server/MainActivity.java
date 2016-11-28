package com.tananaev.smpp.server;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ServerService serverService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            serverService = new ServerService();
            serverService.start();
        } catch (Exception e) {
            Log.w(TAG, e);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        try {
            serverService.stop();
            serverService.close();
        } catch (Exception e) {
            Log.w(TAG, e);
        }
    }

}
