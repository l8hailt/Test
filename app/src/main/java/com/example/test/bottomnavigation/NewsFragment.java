package com.example.test.bottomnavigation;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.test.R;

public class NewsFragment extends BaseFragment {

    public static NewsFragment getInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    private TextView tvNews;

    @Override
    public int getCurrentFragment() {
        return 1;
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public void findView(View view) {
        tvNews = view.findViewById(R.id.tvNews);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvNews.setText("NEWS");
    }


}
