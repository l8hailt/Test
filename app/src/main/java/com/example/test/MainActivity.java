package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestFragment fragment = TestFragment.getInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainLayout, fragment, "TestFragment")
                .commitAllowingStateLoss();
    }
}