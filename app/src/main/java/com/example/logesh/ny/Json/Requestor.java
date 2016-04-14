package com.example.logesh.ny.Json;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.example.logesh.ny.Pojo.NewsItem;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by logesh on 03-01-2016.
 */
public class Requestor {

    static ArrayList<NewsItem>list =null;
    public static JSONObject sendRequest(RequestQueue requestQueue, String news_url){
        JSONObject responseObj = null;
        ArrayList<NewsItem> listNews;
        RequestFuture<JSONObject> future = RequestFuture.newFuture();
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, news_url, (String) null,future, future);
        requestQueue.add(jsonRequest);

        try {
            responseObj = future.get(50000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
       return responseObj;
    }
}
