package com.example.logesh.ny.Pojo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by logesh on 08-04-2016.
 */
public class NewsItem  {

    private long added;
    private String imgURL;
    private String heading;
    private String section;
    private String contentURL;

    public NewsItem(){

    }

    public NewsItem(String imgURL,String heading,String section,String contentURL, long fetchTime){
        this.setAdded(fetchTime);
        this.setImgURL(imgURL);
        this.setHeading(heading);
        this.setSection(section);
        this.setContentURL(contentURL);
    }

    public long getAdded() {
        return added;
    }

    public void setAdded(long added) {
        this.added = added;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getContentURL() {
        return contentURL;
    }

    public void setContentURL(String contentURL) {
        this.contentURL = contentURL;
    }
}
