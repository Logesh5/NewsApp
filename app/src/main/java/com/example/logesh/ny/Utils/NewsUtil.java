package com.example.logesh.ny.Utils;

import com.android.volley.RequestQueue;
import com.example.logesh.ny.Json.Requestor;
import com.example.logesh.ny.Pojo.NewsItem;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by logesh on 03-01-2016.
 */
public class NewsUtil {

    public static final String news_url = "http://api.nytimes.com/svc/topstories/v1/world.json?api-key=YOUR_KEY";
    public static final String sports_url = "http://api.nytimes.com/svc/topstories/v1/sports.json?api-key=YOUR_KEY";
    public static final String food_url = "http://api.nytimes.com/svc/topstories/v1/dining.json?api-key=YOUR_KEY";
    public static final String travel_url = "http://api.nytimes.com/svc/topstories/v1/travel.json?api-key=YOUR_KEY";
    public static final String fashion_url = "http://api.nytimes.com/svc/topstories/v1/fashion.json?api-key=YOUR_KEY";


    public static ArrayList<NewsItem> loadNews(RequestQueue requestQueue){
        JSONObject response = Requestor.sendRequest(requestQueue, news_url);
        ArrayList<NewsItem> listNews = com.example.logesh.ny.Json.Parser.parseJSONResponse(response);
        return listNews;
    }

    public static ArrayList<NewsItem> loadSports(RequestQueue requestQueue){
        JSONObject responseSports = Requestor.sendRequest(requestQueue, sports_url);
        ArrayList<NewsItem> listSports = com.example.logesh.ny.Json.Parser.parseJSONResponse(responseSports);
        return listSports;
    }


    public static ArrayList<NewsItem> loadFood(RequestQueue requestQueue) {
        JSONObject responseFood = Requestor.sendRequest(requestQueue, food_url);
        ArrayList<NewsItem> listFood = com.example.logesh.ny.Json.Parser.parseJSONResponse(responseFood);
        return listFood;
    }

    public static ArrayList<NewsItem> loadTravel(RequestQueue requestQueue) {
        JSONObject responseFood = Requestor.sendRequest(requestQueue, travel_url);
        ArrayList<NewsItem> listTravel = com.example.logesh.ny.Json.Parser.parseJSONResponse(responseFood);
        return listTravel;
    }

    public static ArrayList<NewsItem> loadFashion(RequestQueue requestQueue) {
        JSONObject responseFood = Requestor.sendRequest(requestQueue, fashion_url);
        ArrayList<NewsItem> listFashion = com.example.logesh.ny.Json.Parser.parseJSONResponse(responseFood);
        return listFashion;
    }

}