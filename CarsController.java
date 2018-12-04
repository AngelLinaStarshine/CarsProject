/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car;

//import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author 
 */
public class CarsController implements Initializable {

    List<Car> cars = new ArrayList(); 
    
    @FXML
    private TextField txtModel;

    @FXML
    private TextField txtYear;

    @FXML
    private Slider sldPower;

    @FXML
    private ColorPicker clrPicker;

    @FXML
    private Button btnCreate;
    
    @FXML
    private RadioButton rdFerarri;

    @FXML
    private RadioButton rdMustang;
                        
    @FXML
    private RadioButton rdDodge;
     
    @FXML
    private Label lblErrorMessage;
    
    @FXML
    private Label lblCars;
    
    @FXML
    private Label lblHP;
    
    @FXML
    private ImageView imgCar;
    
    @FXML
    private void handleButtonAction(MouseEvent event) {
        
        lblErrorMessage.setText("");
        
        try{
            String model="";
            
            if (rdFerarri.isSelected())
                model="Ferarri";
            else if(rdMustang.isSelected())
                model="Mustang";
            else if(rdDodge.isSelected())
                model="Dodge";
            
            model +=" " +  txtModel.getText();
            
            int year= Integer.parseInt (txtYear.getText());

            Color color = clrPicker.getValue();
                    
            Car car = new Car(color, model, year, Integer.parseInt( lblHP.getText()));
            
            cars.add(car);
            
            lblCars.setText(lblCars.getText()+"\n" + car.toString());

            
        }
        catch(NumberFormatException e){
            lblErrorMessage.setText("Wrong years format:"+ e.getMessage());       
        }
        catch(Exception e)
        {
        lblErrorMessage.setText(e.getMessage());
        }
    }

    @FXML
    private void handleSliderAction(MouseEvent event) {
        System.out.println("Event is trigerred +" + event.getClass().toString());
        lblHP.setText(String.valueOf((int) (sldPower.getValue()/10)*10));
    }
    
        @FXML
    private void handleRadioButton(MouseEvent event) {
        //All Files	C:\Users\BesoAngel\Documents\NetBeansProjects\CarsProjecct\src\car\ferarri.jpg
        try{
        Image imageFerarri = new Image(new FileInputStream("src\\car\\ferarri.jpg")); 
        Image imageMustang = new Image(new FileInputStream("src\\car\\mustang.jpg")); 
        Image imageDodge = new Image(new FileInputStream("src\\car\\dodge.jpg")); 
        
        if (rdFerarri.isSelected())
            imgCar.setImage(imageFerarri);
        else if(rdMustang.isSelected())
            imgCar.setImage(imageMustang);
        else if(rdDodge.isSelected())
            imgCar.setImage(imageDodge);
        }catch(Exception e){
         lblErrorMessage.setText(e.getMessage());       
        }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
