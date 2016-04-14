package com.example.logesh.ny.Listeners;


import com.example.logesh.ny.Pojo.NewsItem;

import java.util.ArrayList;

/**
 * Created by logesh on 03-01-2016.
 */
public interface NewsLoadedListener {

    public void onNewsLoaded(ArrayList<NewsItem> newsList);
}
