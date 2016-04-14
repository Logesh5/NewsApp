package com.example.logesh.ny.Adapters;

import android.content.Context;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.example.logesh.ny.Listeners.ItemTouchListener;
import com.example.logesh.ny.Pojo.NewsItem;
import com.example.logesh.ny.R;
import com.example.logesh.ny.Singleton.VolleySingleton;
import com.example.logesh.ny.Utils.AnimationUtil;

import java.util.ArrayList;

import io.realm.RealmResults;

/**
 * Created by logesh on 07-04-2016.
 */
public class AdapterTopStories extends RecyclerView.Adapter<AdapterTopStories.MyTopStoriesHolder> {

    private Context mContext;
    LayoutInflater inflater;
    private ArrayList<NewsItem> newsList= new ArrayList<>();
    private VolleySingleton singleton;
    private ImageLoader imgloader;
    private ItemTouchListener itemTouchListener;

    public AdapterTopStories(Context context,ItemTouchListener itemTouchListener) {
        this.mContext = context;
        inflater = LayoutInflater.from(mContext);
        singleton = VolleySingleton.getInstance();
        imgloader = singleton.getImageLoader();
        this.itemTouchListener = itemTouchListener;
    }

    public void setArrayList(ArrayList<NewsItem>list){
        this.newsList = list;
        notifyItemRangeChanged(0,list.size());
    }

    @Override
    public MyTopStoriesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_top_layout,parent,false);
        MyTopStoriesHolder holder = new MyTopStoriesHolder(v,itemTouchListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyTopStoriesHolder holder, int position) {
        AnimationUtil.animate(holder);

        NewsItem item = newsList.get(position);
        holder.tvHeader.setText(item.getHeading());
        holder.tvSection.setText(item.getSection());
        String imgURL = item.getImgURL();

        if(imgURL != null && imgURL.length()>2){
            imgloader.get(imgURL, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    Log.d("logsi", "inside image setter");
                    holder.ivPic.setImageBitmap(response.getBitmap());
                }

                @Override
                public void onErrorResponse(VolleyError error) {
                    holder.ivPic.setImageDrawable(mContext.getResources().getDrawable(R.drawable.left_arrow));
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class MyTopStoriesHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ivPic;
        TextView tvHeader;
        TextView tvSection;
        ItemTouchListener itemListener;

        public MyTopStoriesHolder(View itemView,ItemTouchListener itemListener) {
            super(itemView);
            ivPic = (ImageView) itemView.findViewById(R.id.ivPic);
            tvHeader = (TextView) itemView.findViewById(R.id.tvHeading);
            tvSection = (TextView) itemView.findViewById(R.id.tvSection);
            this.itemListener = itemListener;
            tvHeader.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            itemListener.onItemTouch(getAdapterPosition());
        }
    }
}
