package com.example.logesh.ny.Json;

import android.util.Log;

import com.example.logesh.ny.Pojo.NewsItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static com.example.logesh.ny.Services.Keys.NewsTag.KEY_MULTIMEDIA;
import static com.example.logesh.ny.Services.Keys.NewsTag.KEY_MULTIMEDIA_URL;
import static com.example.logesh.ny.Services.Keys.NewsTag.KEY_RESULTS;
import static com.example.logesh.ny.Services.Keys.NewsTag.KEY_SECTION;
import static com.example.logesh.ny.Services.Keys.NewsTag.KEY_TITLE;
import static com.example.logesh.ny.Services.Keys.NewsTag.KEY_URL;

/**
 * Created by logesh on 03-01-2016.
 */
public class Parser {

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static ArrayList<NewsItem> parseJSONResponse(JSONObject response) {
        ArrayList<NewsItem> arrayList = new ArrayList<>();
        int c = 0;
        if (response != null && response.length() > 0) {
            try {
                if (response.has(KEY_RESULTS)) {
                    JSONArray results = response.getJSONArray(KEY_RESULTS);
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < results.length(); i++) {

                        String title = "NA";
                        String section = "NA";
                        String imgURL = "";
                        String contentURL = "NA";

                        JSONObject resultOBj = results.getJSONObject(i);
                        title = resultOBj.getString(KEY_TITLE);
                        Log.d("Title",title);

                        section = resultOBj.getString(KEY_SECTION);
                        contentURL = resultOBj.getString(KEY_URL);
                        Log.d("section",section);
                        Log.d("content",contentURL);


                        if (resultOBj.has(KEY_MULTIMEDIA) ) {
                            if(resultOBj.get(KEY_MULTIMEDIA) instanceof JSONArray){
                                JSONArray mulArray = resultOBj.getJSONArray(KEY_MULTIMEDIA);
                                JSONObject mulObj = mulArray.getJSONObject(1);
                                if (mulObj.getString(KEY_MULTIMEDIA_URL) != "") {
                                    imgURL = mulObj.getString(KEY_MULTIMEDIA_URL);
                                    Log.d("img",imgURL);
                                }
                            }


                        }


                        NewsItem item = new NewsItem(imgURL, title, section, contentURL , System.currentTimeMillis());

                        arrayList.add(item);
                    }
//                    Toast.makeText(MyApplication.getContext(), builder.toString(), Toast.LENGTH_LONG).show();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return arrayList;


    }
}
