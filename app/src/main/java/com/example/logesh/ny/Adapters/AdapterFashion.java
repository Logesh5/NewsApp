package com.example.logesh.ny.Adapters;

import android.content.Context;
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

/**
 * Created by logesh on 14-04-2016.
 */
public class AdapterFashion extends RecyclerView.Adapter<AdapterFashion.MyFashionHolder> {

    ArrayList<NewsItem> list;
    ItemTouchListener itemTouchListener;
    Context mContext;
    LayoutInflater inflater;
    VolleySingleton singleton;
    ImageLoader imageLoader;

    public AdapterFashion(Context context, ItemTouchListener itemTouchListener) {
        this.mContext = context;
        this.itemTouchListener = itemTouchListener;
        inflater = LayoutInflater.from(context);
        this.singleton = VolleySingleton.getInstance();
        imageLoader = singleton.getImageLoader();
    }

    public void setArrayList(ArrayList<NewsItem> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public MyFashionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_top_layout, parent, false);
        MyFashionHolder holder = new MyFashionHolder(v, itemTouchListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyFashionHolder holder, int position) {
        AnimationUtil.animate(holder);

        NewsItem item = list.get(position);
        holder.tvHeader.setText(item.getHeading());
        holder.tvSection.setText(item.getSection());
        String imgURL = item.getImgURL();

        if (imgURL != null && imgURL.length()>2) {
            imageLoader.get(imgURL, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    Log.d("logsi", "inside image setter fashion");
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
        return list.size();
    }

    public static class MyFashionHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView ivPic;
        TextView tvHeader;
        TextView tvSection;
        ItemTouchListener itemListener;

        public MyFashionHolder(View itemView,ItemTouchListener itemListener) {
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
