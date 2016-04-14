package com.example.logesh.ny.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.logesh.ny.Adapters.AdapterTopStories;
import com.example.logesh.ny.Listeners.ItemTouchListener;
import com.example.logesh.ny.Pojo.NewsItem;
import com.example.logesh.ny.R;
import com.example.logesh.ny.Listeners.NewsLoadedListener;
import com.example.logesh.ny.task.TaskLoadNews;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

/**
 * Created by logesh on 07-04-2016.
 */
public class Fragment_Top_Stories extends Fragment implements NewsLoadedListener, ItemTouchListener {

    RecyclerView rvTopStories;
    ArrayList<NewsItem> list = new ArrayList<>();
    AdapterTopStories adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_top_stories, container, false);
        rvTopStories = (RecyclerView) v.findViewById(R.id.recylcerViewTopStories);
        rvTopStories.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new AdapterTopStories(getContext(), this);
        rvTopStories.setAdapter(adapter);

//        SlideInLeftAnimator leftSlide = new SlideInLeftAnimator();
//        leftSlide.setAddDuration(1000);
//        rvTopStories.setItemAnimator(leftSlide);

        new TaskLoadNews(this).execute();
        adapter.setArrayList(list);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onNewsLoaded(ArrayList<NewsItem> news) {
        list = news;
        adapter.setArrayList(news);
    }


    @Override
    public void onItemTouch(int position) {

        Toast.makeText(getActivity(), "Loading", Toast.LENGTH_LONG).show();
        Bundle b = new Bundle();
        b.putString("url", list.get(position).getContentURL());

        Fragment newFragment = new Fragment_open();
        newFragment.setArguments(b);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(android.R.id.content, newFragment, "Open");
        transaction.addToBackStack(null);
        transaction.commit();


    }
}
