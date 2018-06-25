package bbcag.ch.dime.model;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Gallery {
    private int id;
    private String name;
    private List<Editor> beckenList = new ArrayList<>();
    private String kanton;
    private String ort;

    public Gallery() {
    }

    public Gallery(int id, String name, String ort, String kanton) {
        this.id = id;
        this.name = name;
        this.ort = ort;
        this.kanton = kanton;
    }

    @Override
    public String toString() {
        return name + " " + ort + " (" + kanton + ")";
    }


    public void addBecken(Editor becken) {
        this.beckenList.add(becken);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getBeckenList() {
        return beckenList;
    }

    public void setBeckenList(ArrayList becken) {
        this.beckenList = becken;
    }

    public String getKanton() {
        return kanton;
    }

    public void setKanton(String kanton) {
        this.kanton = kanton;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
}

