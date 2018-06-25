package bbcag.ch.dime.model;

import java.util.ArrayList;

public class Editor {
    private String name;
    private double temperature;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return getName()+": "+getTemperature()+" °C";
    }
}
