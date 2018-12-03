package car;


import javafx.scene.paint.Color;

import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BesoAngel
 */

public class Car {
    
    

 //call variables 


    private Color color;

    private String model;

    private int yearOfManufacture;

    private int horsePower;

    public Color getColor() {
        return color;
    }
//catch errors, wrong input
    //set method
    public void setColor(Color color) {
        if (color == null)
            throw new IllegalArgumentException("Color can't be null");
        this.color = color;
    }
//get method
    public String getModel() {
        return model;
    }
//catch errors, wrong input
    //set method
    public void setModel(String model) {
        if (model == null)
            throw new IllegalArgumentException("Model can't be null");
        if (model.trim().length() == 0)
            throw new IllegalArgumentException("Model can't be empty");
        this.model = model.trim();
    }
//get method
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }
//catch wrong input,
    //set method
    public void setYearOfManufacture(int yearOfManufacture) {
        //set up specific range to controll correct 
        if (yearOfManufacture <= 1930)
            throw new IllegalArgumentException("The car is too old");
        else if (yearOfManufacture > LocalDate.now().getYear())
            throw new IllegalArgumentException("The year of manufacture can't be in a future");

        this.yearOfManufacture = yearOfManufacture;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {

        if (horsePower <= 0)
            throw new IllegalArgumentException("the horse power value is too low");
        else if (horsePower >= 1000)
            throw new IllegalArgumentException("the horse power value is too high");

        this.horsePower = horsePower;
    }

    public Car(Color color, String model, int yearOfManufacture, int horsePower) {
        setColor(color);
        setModel(model);
        setYearOfManufacture(yearOfManufacture);
        setHorsePower(horsePower);
    }

    @Override
    public String toString() {
        return getModel() + ", manufactured in " + getYearOfManufacture() + ", " + getHorsePower() + " hp";
    }
}



