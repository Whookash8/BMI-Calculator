package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.TextFlow;

public class Controller {
    Double height;
    Double weight;
    Double BMI;

    @FXML
    private Button calculateButton;
    @FXML
    private TextField heightField;
    @FXML
    private TextField weightField;
    @FXML
    private TextField bmiField;
    @FXML
    private Tooltip bmiTip;

    public Controller(){

    }

    @FXML
    void initialize(){
        calculateButton.addEventHandler(ActionEvent.ACTION, buttonPressedEvent);
        bmiTip.setText("Niebieski - niedowaga \nZielony - prawidłowa waga \nŻółty - lekka nadwaga\nPomarańczowy - nadwaga\nCzerwony - otyłość");


    }

    @FXML
    public EventHandler<ActionEvent> buttonPressedEvent = event -> {

        height = Double.parseDouble(heightField.getText());
        weight = Double.parseDouble(weightField.getText());

        BMI = weight / (height * height/10000);
        String bmiFormatted = String.format("%.2f", BMI);
        System.out.println(bmiFormatted);

        bmiField.setText(bmiFormatted.toString());
        String color;

        if(BMI<19){
            color = "Aquamarine";
        }
        else if(BMI < 25){
            color = "GreenYellow";
        }
        else if(BMI < 30){
            color = "yellow";
        }
        else if(BMI < 40){
            color = "orange";
        }
        else{
            color = "red";
        }

        bmiField.setStyle("-fx-background-color: " + color + ";");
    };
}
