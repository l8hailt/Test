package com.example.test.bottomnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.test.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationActivity extends AppCompatActivity {

    private BottomNavigationView bnvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        bnvMain = findViewById(R.id.bnvMain);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.flFragmentContainer, HomeFragment.getInstance(), "HOME")
                .commit();

    }
}