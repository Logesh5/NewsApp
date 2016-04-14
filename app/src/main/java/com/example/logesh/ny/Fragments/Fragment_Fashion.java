package com.example.logesh.ny.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.logesh.ny.Adapters.AdapterTravel;
import com.example.logesh.ny.Listeners.FashionLoadListener;
import com.example.logesh.ny.Listeners.ItemTouchListener;
import com.example.logesh.ny.Pojo.NewsItem;
import com.example.logesh.ny.R;
import com.example.logesh.ny.task.TaskLoadFashion;
import com.example.logesh.ny.task.TaskLoadTravel;

import java.util.ArrayList;

/**
 * Created by logesh on 13-04-2016.
 */
public class Fragment_Fashion extends Fragment implements ItemTouchListener,FashionLoadListener {
    RecyclerView rvFashion;
    ArrayList<NewsItem> list = new ArrayList<>();
    AdapterTravel adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.layout_fashion,container,false);

        rvFashion = (RecyclerView) v.findViewById(R.id.recyclerViewFashion);
        rvFashion.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new AdapterTravel(getContext(), this);
        rvFashion.setAdapter(adapter);

        new TaskLoadFashion(this).execute();
        Toast.makeText(getActivity(), "Loading Food", Toast.LENGTH_SHORT).show();
        adapter.setArrayList(list);
        return v;
    }

    @Override
    public void onFashionLoad(ArrayList<NewsItem> fashionList) {
        this.list = fashionList;
        adapter.setArrayList(fashionList);
    }

    @Override
    public void onItemTouch(int position) {
        Toast.makeText(getActivity(), "fashion "+ position, Toast.LENGTH_SHORT).show();
    }
}
