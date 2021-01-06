package com.example.test.bottomnavigation;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    public BottomNavigationActivity activity;

    public abstract int getCurrentFragment();

    public abstract int layoutId();

    public abstract void findView(View view);

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (BottomNavigationActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(layoutId(), container, false);
        findView(v);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.e("TAG", "onViewCreated: " + getCurrentFragment());
    }
}
