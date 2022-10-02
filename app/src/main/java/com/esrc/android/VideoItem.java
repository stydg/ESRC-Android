package com.esrc.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class VideoItem {
    String keyword;
    String title;
    int Id;

    public VideoItem(String keyword, String title, int Id) {
        this.keyword = keyword;
        this.title = title;
        this.Id = Id;
    }

    public String getkeyword() {
        return keyword;
    }
    public void setkeyword(String keyword) {
        this.keyword = keyword;
    }

    public String gettitle() {
        return title;
    }
    public void settitle(String title) {
        this.title = title;
    }

    public int getId() {
        return Id;
    }
    public void setId(int Id) {
        this.Id = Id;
    }
}
