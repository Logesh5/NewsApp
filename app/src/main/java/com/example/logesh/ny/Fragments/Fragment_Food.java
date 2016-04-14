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

import com.example.logesh.ny.Adapters.AdapterFood;
import com.example.logesh.ny.Adapters.AdapterSports;
import com.example.logesh.ny.Listeners.FoodLoadedListener;
import com.example.logesh.ny.Listeners.ItemTouchListener;
import com.example.logesh.ny.Pojo.NewsItem;
import com.example.logesh.ny.R;
import com.example.logesh.ny.task.TaskLoadFood;
import com.example.logesh.ny.task.TaskLoadSports;

import java.util.ArrayList;

/**
 * Created by logesh on 12-04-2016.
 */
public class Fragment_Food extends Fragment implements ItemTouchListener,FoodLoadedListener {

   RecyclerView rvFood;
    ArrayList<NewsItem> list = new ArrayList<>();
    AdapterFood adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_sports,container,false);
        rvFood = (RecyclerView) v.findViewById(R.id.recyclerViewSports);
        rvFood.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new AdapterFood(getContext(),this);
        rvFood.setAdapter(adapter);

        new TaskLoadFood(this).execute();
        Toast.makeText(getActivity(), "Loading Food", Toast.LENGTH_SHORT).show();
        adapter.setArrayList(list);

        return v;
    }

    @Override
    public void onFoodLoad(ArrayList<NewsItem> foodList) {
        this.list = foodList;
        adapter.setArrayList(foodList);
    }

    @Override
    public void onItemTouch(int position) {
        Toast.makeText(getActivity(), "Food "+position, Toast.LENGTH_SHORT).show();
    }
}
