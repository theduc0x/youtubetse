package com.example.youtubeapi;

public class PlayVideoList {
    private String url;
    private String titleVideo;

    public PlayVideoList(String titleVideo, String url) {
        this.titleVideo = titleVideo;
        this.url = url;

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
