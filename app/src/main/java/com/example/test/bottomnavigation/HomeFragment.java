package com.example.test.bottomnavigation;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.test.R;

public class HomeFragment extends BaseFragment {

    public static HomeFragment getInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    private TextView tvHome;

    @Override
    public int getCurrentFragment() {
        return 0;
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void findView(View view) {
        tvHome = view.findViewById(R.id.tvHome);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvHome.setText("HOME");
    }


}
