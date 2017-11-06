package edu.umbc.dmutlu1.bikerentaldem;

public class Bike
{

    private final String name;
    private final int image;

    public Bike(String name, int image) {
        this.name = name;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}