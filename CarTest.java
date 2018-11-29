/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car;

import javafx.scene.paint.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BesoAngel
 */
public class CarTest {

    Car car;

    @Before
    public void setUp() throws Exception {

        car = new Car(new Color(1, 0, 0, 1), "Ferarri 488 GTB", 2015, 720);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getColor() {

        Color expResult = new Color(1, 0, 0, 1);

        assertEquals(expResult, car.getColor());
    }

    @Test
    public void setColorNull() {

        try {
            car.setColor(null);
            fail("the color cant be null");
        } catch (IllegalArgumentException e) {
            System.out.println("Trying to set color as null");
        }

    }

    @Test
    public void setColor() {

        Color color = new Color(1, 1, 1, 1);
        car.setColor(color);
        assertEquals(color, car.getColor());
    }

    @Test
    public void getModel() {

        String expResult = "Ferarri 488 GTB";

        assertEquals(expResult, car.getModel());
    }

    @Test
    public void setModelNull() {
        try {
            car.setModel(null);
            fail("the model cant be null");
        } catch (IllegalArgumentException e) {
            System.out.println("Trying to set null model");
        }

    }

    @Test
    public void setModelEmpty() {

        try {
            car.setModel("");
            fail("the model cant be empty");
        } catch (IllegalArgumentException e) {
            System.out.println("Trying to set empty model");
        }

    }

    @Test
    public void setModel() {

        String model = "Renault Duster";
        car.setModel(model);
        assertEquals(model, car.getModel());
    }

    @Test
    public void getYearOfManufacture() {

        int expResult = 2015;

        assertEquals(expResult, car.getYearOfManufacture());
    }

    @Test
    public void setYearOfManufacture() {

        int yearOfManufacture = 1997;

        car.setYearOfManufacture(yearOfManufacture);

        assertEquals(yearOfManufacture, car.getYearOfManufacture());

    }

    @Test
    public void setYearOfManufactureOld() {

        int yearOfManufacture = 1900;
        try {
            car.setYearOfManufacture(yearOfManufacture);
            fail("the model is too old");
        } catch (IllegalArgumentException e) {
            System.out.println("Trying to set old year of manufacture");
        }

    }

    @Test
    public void setYearOfManufactureFuture() {

        int yearOfManufacture = 2835;
        try {
            car.setYearOfManufacture(yearOfManufacture);
            fail("the year of manufacture is in future");
        } catch (IllegalArgumentException e) {
            System.out.println("Trying to set year of manufacture in future");
        }

    }

    @Test
    public void getHorsePower() {

        int expResult = 720;

        assertEquals(expResult, car.getHorsePower());
    }

    @Test
    public void setHorsePower() {

        int horsePower = 500;

        car.setHorsePower(horsePower);

        assertEquals(car.getHorsePower(), horsePower);
    }

    @Test
    public void setHorsePowerLow() {

        int horsePower = -10;

        try {
            car.setHorsePower(horsePower);
            fail("the horse power value is too low");
        } catch (IllegalArgumentException e) {
            System.out.println("the horse power value is too low");
        }

    }

    @Test
    public void setHorsePowerHigh() {

        int horsePower = 11000;

        try {
            car.setHorsePower(horsePower);
            fail("the horse power value is too high");
        } catch (IllegalArgumentException e) {
            System.out.println("the horse power value is too high");
        }

    }

    @Test
    public void toStringTest() {
        String expResult = "Ferarri 488 GTB, manufactured in 2015, 720 hp";
        assertEquals(expResult, car.toString());
    }
}