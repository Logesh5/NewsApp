package com.example.logesh.ny.task;

import android.os.AsyncTask;

import com.android.volley.RequestQueue;
import com.example.logesh.ny.Listeners.FoodLoadedListener;
import com.example.logesh.ny.Pojo.NewsItem;
import com.example.logesh.ny.Singleton.VolleySingleton;
import com.example.logesh.ny.Utils.NewsUtil;

import java.util.ArrayList;

/**
 * Created by logesh on 12-04-2016.
 */
public class TaskLoadFood extends AsyncTask<Void,Void,ArrayList<NewsItem>> {

    private FoodLoadedListener myComponent;
    private VolleySingleton volleySingleton;
    private RequestQueue requestQueue;


    public TaskLoadFood(FoodLoadedListener myComponent){
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
        ArrayList<NewsItem>food = NewsUtil.loadFood(requestQueue);
        return food;
    }

    @Override
    protected void onPostExecute(ArrayList<NewsItem> food) {
        if(myComponent!=null){
            myComponent.onFoodLoad(food);
        }
    }
}
