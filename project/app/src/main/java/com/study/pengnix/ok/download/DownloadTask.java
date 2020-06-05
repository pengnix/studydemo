package com.study.pengnix.ok.download;


import java.io.File;

public class DownloadTask {
    /*文件url*/
    private String url;
    /*文件名*/
    private String filename;
    /*目录*/
    private String directory;
    /*下载进度*/
    private int progress;


    DownloadTask(String url){
        this.url = url;
    }
    DownloadTask(String url, String directory){
        this.url = url;
        this.directory = directory;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getFilePath(){
        return getDirectory() + File.separator + getFilename();
    }
}
