package com.example.logesh.ny.task;

import android.os.AsyncTask;

import com.android.volley.RequestQueue;
import com.example.logesh.ny.Listeners.NewsLoadedListener;
import com.example.logesh.ny.Utils.NewsUtil;
import com.example.logesh.ny.Singleton.VolleySingleton;
import com.example.logesh.ny.Pojo.NewsItem;

import java.util.ArrayList;

/**
 * Created by logesh on 03-01-2016.
 */
public class TaskLoadNews extends AsyncTask<Void,Void,ArrayList<NewsItem>> {

    private NewsLoadedListener myComponent;
    private VolleySingleton volleySingleton;
    private RequestQueue requestQueue;


    public TaskLoadNews(NewsLoadedListener myComponent){
        this.myComponent = myComponent;
        volleySingleton = VolleySingleton.getInstance();
        requestQueue  =volleySingleton.getRequestQueue();

    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected ArrayList<NewsItem> doInBackground(Void... params) {
        ArrayList<NewsItem>news = NewsUtil.loadNews(requestQueue);
        return news;
    }

    @Override
    protected void onPostExecute(ArrayList<NewsItem> news) {
        if(myComponent!=null){
            myComponent.onNewsLoaded(news);
        }
    }
}
