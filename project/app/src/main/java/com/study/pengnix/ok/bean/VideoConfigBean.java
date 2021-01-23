package com.study.pengnix.ok.bean;

public class VideoConfigBean {
    private String video;
    private String homeFlag;


    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getHomeFlag() {
        return homeFlag;
    }

    public void setHomeFlag(String homeFlag) {
        this.homeFlag = homeFlag;
    }

    @Override
    public String toString() {
        return "VideoConfigBean{" +
                "video='" + video + '\'' +
                ", homeFlag='" + homeFlag + '\'' +
                '}';
    }
}
