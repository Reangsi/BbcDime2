package bbcag.ch.dime.model;

import java.util.ArrayList;
import java.util.List;

public class Gallery {
    private int id;
    private String name;
    private List<Editor> imageList;
    private String image;
    private String date;

    public Gallery(int id, String name, String date, String image) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.image = image;
    }

    public Gallery(){
        imageList = new ArrayList<>();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String kanton) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String ort) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public List<Editor> getBecken() {
        return imageList;
    }

    public String toString() {
        return String.format("%s %s (%s)", date, name, image);
    }


}

