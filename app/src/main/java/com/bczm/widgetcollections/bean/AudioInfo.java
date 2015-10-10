package com.bczm.widgetcollections.bean;

import java.util.List;

/**
 * @author：Jorge on 2015/10/10 11:49
 */
public class AudioInfo {
    public  String  r;
    public  String version_max;
    public  String is_show_quick_start;
    public List< AudioDetail> song;

    @Override
    public String toString() {
        return "AudioInfo{" +
                "r='" + r + '\'' +
                ", version_max='" + version_max + '\'' +
                ", is_show_quick_start='" + is_show_quick_start + '\'' +
                ", song=" + song.get(0).toString() +
                '}';
    }
}

//{
//        "r": 0,
//        "version_max": 100,
//        "is_show_quick_start": 0,
//        "song": [
//        {
//        "status": 0,
//        "picture": "http://img3.douban.com/lpic/s3149211.jpg",
//        "alert_msg": "",
//        "albumtitle": "就i Karen莫文蔚精选",
//        "singers": [
//        {
//        "related_site_id": 0,
//        "is_site_artist": false,
//        "id": "8260",
//        "name": "莫文蔚"
//        }
//        ],
//        "file_ext": "mp3",
//        "like": 0,
//        "album": "/subject/3255651/",
//        "ver": 0,
//        "ssid": "dd74",
//        "title": "i Karen情歌组曲 他不爱我＋阴天＋爱＋如果没有你＋单人房双人床＋广岛之恋",
//        "url": "http://mr7.doubanio.com/b8554d184164b9f5b0c405e135791995/0/fm/song/p291813_128k.mp3",
//        "artist": "莫文蔚",
//        "subtype": "",
//        "length": 508,
//        "sid": "291813",
//        "aid": "3255651",
//        "sha256": "fe8751abd952b58814e91ff0be4d94858d68d1fa343d38c7194f965d4704774c",
//        "kbps": "128"
//        }
//        ]
//        }

class AudioDetail{
    public String  status;
    public String  picture;
    public String  alert_msg;
    public String  albumtitle;
    public String  file_ext;
    public String  like;
    public String  album;
    public String  ver;
    public String  ssid;
    public String  title;
    public String  url;
    public String  artist;
    public String  subtype;
    public String  length;
    public String  sid;
    public String  aid;
    public String  sha256;
    public String  kbps;

    @Override
    public String toString() {
        return "AudioDetail{" +
                "status='" + status + '\'' +
                ", picture='" + picture + '\'' +
                ", alert_msg='" + alert_msg + '\'' +
                ", albumtitle='" + albumtitle + '\'' +
                ", file_ext='" + file_ext + '\'' +
                ", like='" + like + '\'' +
                ", album='" + album + '\'' +
                ", ver='" + ver + '\'' +
                ", ssid='" + ssid + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", artist='" + artist + '\'' +
                ", subtype='" + subtype + '\'' +
                ", length='" + length + '\'' +
                ", sid='" + sid + '\'' +
                ", aid='" + aid + '\'' +
                ", sha256='" + sha256 + '\'' +
                ", kbps='" + kbps + '\'' +
                '}';
    }
}