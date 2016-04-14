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

import com.example.logesh.ny.Adapters.AdapterSports;
import com.example.logesh.ny.Listeners.ItemTouchListener;
import com.example.logesh.ny.Listeners.NewsLoadedListener;
import com.example.logesh.ny.Listeners.SportsLoadedListener;
import com.example.logesh.ny.Pojo.NewsItem;
import com.example.logesh.ny.R;
import com.example.logesh.ny.task.TaskLoadSports;

import java.util.ArrayList;

/**
 * Created by logesh on 12-04-2016.
 */
public class Fragment_Sports extends Fragment implements SportsLoadedListener,ItemTouchListener{

    RecyclerView rvSports;
    ArrayList<NewsItem> list = new ArrayList<>();
    AdapterSports adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.layout_sports,container,false);
        rvSports = (RecyclerView) v.findViewById(R.id.recyclerViewSports);
        rvSports.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new AdapterSports(getContext(),this);
        rvSports.setAdapter(adapter);

        new TaskLoadSports(this).execute();
        Toast.makeText(getActivity(), "Loading Sports", Toast.LENGTH_SHORT).show();
        adapter.setArrayList(list);

        return v;
    }

    @Override
    public void onItemTouch(int position) {
        Toast.makeText(getActivity(), "Sports "+position, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onSportsLoad(ArrayList<NewsItem> sportsList) {
        this.list = sportsList;
        adapter.setArrayList(sportsList);
    }
}
