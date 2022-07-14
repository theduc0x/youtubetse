package com.example.youtubeapi;

public class PlayVideoList {
    private String url;
    private String titleVideo;

    public PlayVideoList(String url, String titleVideo) {
        this.url = url;
        this.titleVideo = titleVideo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitleVideo() {
        return titleVideo;
    }

    public void setTitleVideo(String titleVideo) {
        this.titleVideo = titleVideo;
    }
}
