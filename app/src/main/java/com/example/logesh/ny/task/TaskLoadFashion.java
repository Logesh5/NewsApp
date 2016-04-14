package com.example.logesh.ny.task;

import android.os.AsyncTask;

import com.android.volley.RequestQueue;
import com.example.logesh.ny.Listeners.FashionLoadListener;
import com.example.logesh.ny.Pojo.NewsItem;
import com.example.logesh.ny.Singleton.VolleySingleton;
import com.example.logesh.ny.Utils.NewsUtil;

import java.util.ArrayList;

/**
 * Created by logesh on 14-04-2016.
 */
public class TaskLoadFashion extends AsyncTask<Void,Void,ArrayList<NewsItem>> {

    private FashionLoadListener myComponent;
    private VolleySingleton volleySingleton;
    private RequestQueue requestQueue;


    public TaskLoadFashion(FashionLoadListener myComponent){
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
        ArrayList<NewsItem>sports = NewsUtil.loadFashion(requestQueue);
        return sports;
    }

    @Override
    protected void onPostExecute(ArrayList<NewsItem> fashion) {
        if(myComponent!=null){
            myComponent.onFashionLoad(fashion);
        }
    }
}
