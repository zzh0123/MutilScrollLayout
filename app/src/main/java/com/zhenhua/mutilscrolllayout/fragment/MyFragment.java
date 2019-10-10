package com.zhenhua.mutilscrolllayout.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zhenhua.mutilscrolllayout.R;
import com.zhenhua.mutilscrolllayout.adapter.MyAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {

    private ArrayList<String> itemList = new ArrayList<>();

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        initData();
        View rootView = inflater.inflate(R.layout.fragment_my, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        MyAdapter adapter = new MyAdapter(getActivity(), itemList);
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    private void initData() {
        for (int i = 0; i < 100; i++) {
            itemList.add("第" + i + "条");
        }
    }

}
