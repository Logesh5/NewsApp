package com.example.logesh.ny.task;

import android.os.AsyncTask;

import com.android.volley.RequestQueue;
import com.example.logesh.ny.Listeners.SportsLoadedListener;
import com.example.logesh.ny.Pojo.NewsItem;
import com.example.logesh.ny.Singleton.VolleySingleton;
import com.example.logesh.ny.Utils.NewsUtil;

import java.util.ArrayList;

/**
 * Created by logesh on 12-04-2016.
 */
public class TaskLoadSports extends AsyncTask<Void,Void,ArrayList<NewsItem>> {

    private SportsLoadedListener myComponent;
    private VolleySingleton volleySingleton;
    private RequestQueue requestQueue;


    public TaskLoadSports(SportsLoadedListener myComponent){
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
        ArrayList<NewsItem>sports = NewsUtil.loadSports(requestQueue);
        return sports;
    }

    @Override
    protected void onPostExecute(ArrayList<NewsItem> sports) {
        if(myComponent!=null){
            myComponent.onSportsLoad(sports);
        }
    }
}
