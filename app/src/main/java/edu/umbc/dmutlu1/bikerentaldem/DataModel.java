package edu.umbc.dmutlu1.bikerentaldem;

public class DataModel {

    private String name;
    private int id_;
    private int image;

    public DataModel(String name, int id_, int image) {
        this.name = name;
        this.image=image;
        this.id_ = id_;

    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public int getId() {
        return id_;
    }
}