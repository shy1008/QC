package com.example.myapplication;

//import com.google.firebase.firestore.ServerTimestamp;
//
//import java.util.Date;


public class Board {

    private String id;
    private String title;
//    private @ServerTimestamp
//    Date timestamp;
    private String contents;
    private String name;


    public Board(String id, String title, String contents)  {

    }

    public Board(String id, String title, String contents, String name) {
        this.id = id;
        this.title = title;

        this.contents = contents;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public Date getTimeStamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(String ttimestamp) {
//        this.timestamp= timestamp;
//    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
//                ", timestamp='" + timestamp + '\'' +
                ", contents='" + contents + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
