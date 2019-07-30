package com.minos.bean;

/**
 * Created by admini
 * on 2019/7/12
 */
public class VideoInfo {   //瑙嗛淇℃伅绫�

    private long id;    //鍞竴鏍囪瘑
    private long duration;   //瑙嗛鏃堕暱
    private long size;    //瑙嗛鏂囦欢澶у皬
    private String url;   //瑙嗛鏂囦欢鐨剈rl
    private String artist;   //鑹烘湳瀹跺悕绉�
    private String title;    //瑙嗛鍚嶇О
    private int hot;    //瑙嗛鐑害
    private String time;   //瑙嗛涓婁氦鏃堕棿
    private String preview;   //瑙嗛棰勮鍥�

    public VideoInfo() {
    }

    public VideoInfo(long id, long duration, long size, String url, String artist, String title, int hot, String time, String preview) {
        this.id = id;
        this.duration = duration;
        this.size = size;
        this.url = url;
        this.artist = artist;
        this.title = title;
        this.hot = hot;
        this.time = time;
        this.preview = preview;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }
}
