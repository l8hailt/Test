package com.example.test.layoutmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.R;

import java.util.ArrayList;
import java.util.List;

public class TestLMActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_lm);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView recyclerView2 = findViewById(R.id.recyclerView2);

        final List<String> title = new ArrayList<>();
        int size = 50;
        for (int i = 0; i < size; i++) {
            title.add("Hello" + i);
        }
        GalleryLayoutManager layoutManager1 = new GalleryLayoutManager(GalleryLayoutManager.HORIZONTAL);
        layoutManager1.attach(recyclerView, 0);
        layoutManager1.setItemTransformer(new ScaleTransformer());
        DemoAdapter demoAdapter1 = new DemoAdapter(title) {
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//                mMainTvRecycleInfo1.append("Create VH type:+" + viewType + "\n");
                Log.e("TAG", "onCreateViewHolder: " + viewType);
                return super.onCreateViewHolder(parent, viewType);
            }
        };
        demoAdapter1.setOnItemClickListener(new DemoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                recyclerView.smoothScrollToPosition(position);
            }
        });
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL);
//        mMainRecycle1.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(demoAdapter1);

        final GalleryLayoutManager layoutManager2 = new GalleryLayoutManager(GalleryLayoutManager.VERTICAL);
        layoutManager2.attach(recyclerView2, 20);
        layoutManager2.setCallbackInFling(true);
        layoutManager2.setOnItemSelectedListener(new GalleryLayoutManager.OnItemSelectedListener() {
            @Override
            public void onItemSelected(RecyclerView recyclerView, View item, int position) {
//                mMainTvRecycleInfo2.setText("selected:" + position + "\n");
                Log.e("TAG", "onItemSelected: " + position);
            }
        });
        DemoAdapter demoAdapter2 = new DemoAdapter(title, DemoAdapter.VIEW_TYPE_TEXT);
        demoAdapter2.setOnItemClickListener(new DemoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                recyclerView2.smoothScrollToPosition(position);
            }
        });
        recyclerView2.setAdapter(demoAdapter2);

    }
}