package bbcag.ch.dime.model;

public class Gallery {
    private int id;
    private String name;
    private byte[] image;
    private String date;

    public Gallery(int id, String name, String date, byte[] image) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.image = image;
    }

    public Gallery() {

    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public String toString() {
        return String.format("%s %s (%d)", date, name, image);
    }


}

