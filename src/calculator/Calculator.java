/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Panagiotis Sklidas
 */

public class Calculator extends Application{

    TextField re;
    double x, y;
    Label num, histo;
    ScrollPane his;
    Scene scn2, scn;
    Stage stage;
    Button bCal;
    
    @Override
    public void start(Stage primaryStage){
        
        stage = primaryStage;
        
        Application.setUserAgentStylesheet(getClass().getResource("css.css").toExternalForm());
                
        /*Creating Grid*/
        GridPane gPane = new GridPane();
        gPane.setBackground(new Background(new BackgroundFill(Color.web("#f5f5f5"), CornerRadii.EMPTY, Insets.EMPTY)));
        gPane.setAlignment(Pos.CENTER);
        gPane.setHgap(10);
        gPane.setVgap(10);
        gPane.setPadding(new Insets(25, 25, 25, 25));
        
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(25);
        gPane.getColumnConstraints().add(column1);
        gPane.getColumnConstraints().add(column1);
        gPane.getColumnConstraints().add(column1);
        gPane.getColumnConstraints().add(column1);
        
        /*Creating the buttons*/
        
        Button btnEq = new Button("=");
        gPane.add(btnEq, 3, 6, 1, 2);
        btnEq.setPrefHeight(100);
        btnEq.setOnAction(e->equ());
        btnEq.setId("okBtn");
        Button btnC = new Button("C");
        btnC.setId("clear");
        gPane.add(btnC, 0, 3, 1, 1);
        btnC.setOnAction(e->clear());
        Button btnMod = new Button("%");
        gPane.add(btnMod, 1, 3, 1, 1);
        btnMod.setOnAction(e->mod());
        Button btnQ = new Button("/");
        gPane.add(btnQ, 2, 3, 1, 1);
        btnQ.setOnAction(e->division());
        Button btnMul = new Button("*");
        gPane.add(btnMul, 3, 3, 1, 1);
        btnMul.setOnAction(e->multiplication());
        Button btnMin = new Button("-");
        gPane.add(btnMin, 3, 4, 1, 1);
        btnMin.setOnAction(e->substrack());
        Button btnPlus = new Button("+");
        gPane.add(btnPlus, 3, 5, 1, 1);
        btnPlus.setOnAction(e->addition());
        Button btnDot = new Button(".");
        gPane.add(btnDot, 2, 7, 1, 1);
        btnDot.setOnAction(e->dote());
        
        /*Creating numerical buttons*/
        Button btn9 = new Button("9");
        gPane.add(btn9, 2, 4, 1, 1);
        btn9.setOnAction(e->btn9());
        Button btn8 = new Button("8");
        gPane.add(btn8, 1, 4, 1, 1);
        btn8.setOnAction(e->btn8());
        Button btn7 = new Button("7");
        gPane.add(btn7, 0, 4, 1, 1);
        btn7.setOnAction(e->btn7());
        Button btn6 = new Button("6");
        gPane.add(btn6, 2, 5, 1, 1);
        btn6.setOnAction(e->btn6());
        Button btn5 = new Button("5");
        gPane.add(btn5, 1, 5, 1, 1);
        btn5.setOnAction(e->btn5());
        Button btn4 = new Button("4");
        gPane.add(btn4, 0, 5, 1, 1);
        btn4.setOnAction(e->btn4());
        Button btn3 = new Button("3");
        gPane.add(btn3, 2, 6, 1, 1);
        btn3.setOnAction(e->btn3());
        Button btn2 = new Button("2");
        gPane.add(btn2, 1, 6, 1, 1);
        btn2.setOnAction(e->btn2());
        Button btn1 = new Button("1");
        gPane.add(btn1, 0, 6, 1, 1);
        btn1.setOnAction(e->btn1());
        Button btn0 = new Button("0");
        gPane.add(btn0, 1, 7, 1, 1);
        btn0.setOnAction(e->btn0());
        Button btnBS = new Button();
        gPane.add(btnBS, 0, 7, 1, 1);
        btnBS.setOnAction(e->backSpace());
        BackgroundImage bImage = new BackgroundImage( new Image( getClass().getResource("/icons/backspace.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background b = new Background(bImage);
        btnBS.setBackground(b);
        
        /*Creating textfield*/
        re = new TextField();
        gPane.add(re, 0, 2, 4, 1);
        
        /*Creating label*/
        num = new Label();
        gPane.add(num, 0, 1, 4, 1);
        
        /*History*/
        //Icon: made by https://www.flaticon.com/authors/pixelmeetup
        Button hist = new Button("");
        BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource("/icons/history.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        hist.setBackground(background);
        hist.setOnAction(e->history());
        gPane.setAlignment(Pos.CENTER_LEFT);
        gPane.add(hist, 3, 0, 4, 1);
        bCal = new Button("Back");
        bCal.setOnAction(e->bCalc());
        
        histo = new Label();
        histo.setId("history");
        
        his = new ScrollPane();
        his.setStyle("/calculatorapp/css.css");
        his.setContent(histo);
        
        GridPane gHist = new GridPane();
        gHist.setBackground(new Background(new BackgroundFill(Color.web("#f5f5f5"), CornerRadii.EMPTY, Insets.EMPTY)));
        gHist.setAlignment(Pos.CENTER);
        gHist.setHgap(10);
        gHist.setVgap(10);
        gHist.setPadding(new Insets(25, 25, 25, 25));
        gHist.add(his, 0, 0, 1, 1);
        gHist.add(bCal, 0, 1, 1, 1);
        
        /*Setting up stage*/
        BorderPane bPane = new BorderPane();
        bPane.setCenter(gPane);
        BorderPane bHist =new BorderPane();
        bHist.setCenter(gHist);
        scn = new Scene(bPane, 300, 375);
        scn2 = new Scene(bHist, 300, 375);
        Image img = new Image("/icons/calculator.png");
        primaryStage.getIcons().add(img);
        primaryStage.setScene(scn);
        primaryStage.setTitle("Calculator");
        primaryStage.setResizable(false);
        primaryStage.show();
        
        /*Key mapping*/
        scn.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->{
            switch(key.getCode()){
                case EQUALS:
                    if(key.isShiftDown()){
                        addition();
                    }
                    else{
                        equ();
                    }
                    break;
                case ENTER:
                    equ();
                    break;
                case ADD:
                    addition();
                    break;
                case MINUS:
                    substrack();
                    break;
                case SUBTRACT:
                    substrack();
                    break;
                case MULTIPLY:
                    multiplication();
                    break;
                case DIVIDE:
                    division();
                    break;
                case SLASH:
                    division();
                    break;
                case BACK_SPACE:
                    backSpace();
                    break;
                case DELETE:
                    clear();
                    break;
                case DECIMAL:
                    dote();
                    break;
                case H:
                    history();
                    break;
                case NUMPAD0:
                    btn0();
                    break;
                case NUMPAD1:
                    btn1();
                    break;
                case NUMPAD2:
                    btn2();
                    break;
                case NUMPAD3:
                    btn3();
                    break;
                case NUMPAD4:
                    btn4();
                    break;
                case NUMPAD5:
                    btn5();
                    break;
                case NUMPAD6:
                    btn6();
                    break;
                case NUMPAD7:
                    btn7();
                    break;
                case NUMPAD8:
                    btn8();
                    break;
                case NUMPAD9:
                    btn9();
                    break;
                case DIGIT0:
                    btn0();
                    break;
                case DIGIT1:
                    btn1();
                    break;
                case DIGIT2:
                    btn2();
                    break;
                case DIGIT3:
                    btn3();
                    break;
                case DIGIT4:
                    btn4();
                    break;
                case DIGIT5:
                    if(key.isShiftDown()){
                        mod();
                    }
                    else{
                        btn5();
                    }
                    break;
                case DIGIT6:
                    btn6();
                    break;
                case DIGIT7:
                    btn7();
                    break;
                case DIGIT8:
                    if(key.isShiftDown()){
                        multiplication();
                    }
                    else{
                        btn8();
                    }
                    break; 
                case DIGIT9:
                    btn9();
                    break;
                case ESCAPE:
                    primaryStage.close();
                    break;
                default:
                    System.out.println("The key has not been mapped yet");
            }
        });
    }
    
    /*Method that inserts a dote for decimals*/
    public void dote(){
        re.appendText(".");
    }
    
    /*Creates the backspace method*/
    public void backSpace(){
       String msg = "";
        if(!re.getText().isEmpty()){
            re.setText(re.getText().substring(0, re.getText().length() - 1));
        }
        else{
            msg += "There's not a digit to be deleted";
            MessageBox.show(msg, "Error");
        }
    }
    
    /*Create the method when the equals is pressed*/
    public void equ(){
        String msg = "";
        if(!re.getText().isEmpty() && !num.getText().isEmpty()){
            y = Double.valueOf(re.getText());
            String p = num.getText().substring(num.getText().length() - 1);
            switch (p) {
                case "+":
                    re.setText(String.valueOf(String.format("%.2f", x + y)));
                    num.setText("");
                    histo.setText(histo.getText() + "\n" + x + p + y + "=" + String.valueOf(String.format("%.2f", x + y)) + "\n");
                    break;
                case "-":
                    re.setText(String.valueOf(String.format("%.4f", x - y)));
                    num.setText("");
                    histo.setText(histo.getText() + "\n" + x + p + y + "=" + String.valueOf(String.format("%.2f", x - y)) + "\n");
                    break;
                case "*":
                    re.setText(String.valueOf(String.format("%.4f", x * y)));
                    num.setText("");
                    histo.setText(histo.getText() + "\n" + x + p + y + "=" + String.valueOf(String.format("%.2f", x * y)) + "\n");
                    break;
                case "/":
                    if(y == 0){
                        msg += "Can't divide by 0";
                        MessageBox.show(msg, "Error");
                    }
                    else{
                        re.setText(String.valueOf(String.format("%.2f", x / y)));
                        num.setText("");
                        histo.setText(histo.getText() + "\n" + x + p + y + "=" + String.valueOf(String.format("%.2f", x / y)) + "\n");
                    }   break;
                case "%":
                    re.setText(String.valueOf(String.format("%.4f", x % y)));
                    num.setText("");
                    histo.setText(histo.getText() + "\n" + x + "mod" + y + "=" + String.valueOf(String.format("%.2f", x % y)) + "\n");
                    break;
                default:
                    msg += "There's not such an operation symbol";
                    MessageBox.show(msg, "Error");
                    break;
            }
        }
        else{
            MessageBox.show("There is not arithmetic data to work with", "Error");
        }
    }
    
    /*Method that makes the History Scene visible*/
    public void history(){
        stage.setScene(scn2);
    }
    
    /*Method that returns to calculator*/
    public void bCalc(){
        stage.setScene(scn);
    }
    
    /*Method that clear (resets) the scene*/
    public void clear(){
        re.setText("");
        num.setText("");
    }
    
    /*Creating the mathematical operations*/
    public void mod(){
        re.appendText("%");
        num.setText(re.getText());
        re.setText("");
        x = Double.valueOf(num.getText().substring(0, num.getText().length() - 1));
    }
    
    public void division(){
        re.appendText("/");
        num.setText(re.getText());
        re.setText("");
        x = Double.valueOf(num.getText().substring(0, num.getText().length() - 1));
    }
    
    public void multiplication(){
        re.appendText("*");
        num.setText(re.getText());
        re.setText("");
        x = Double.valueOf(num.getText().substring(0, num.getText().length() - 1));
    }
    
    public void substrack(){
        re.appendText("-");
        num.setText(re.getText());
        re.setText("");
        x = Double.valueOf(num.getText().substring(0, num.getText().length() - 1));
    }
    
    public void addition(){
        re.appendText("+");
        num.setText(re.getText());
        re.setText("");
        x = Double.valueOf(num.getText().substring(0, num.getText().length() - 1));
    }
 
    /*Creating the numbers*/
    public void btn9(){
        re.appendText("9");
    }
    
    public void btn8(){
        re.appendText("8");
    }
    
    public void btn7(){
        re.appendText("7");
    }
    
    public void btn6(){
        re.appendText("6");
    }
    
    public void btn5(){
        re.appendText("5");
    }
    
    public void btn4(){
        re.appendText("4");
    }
    
    public void btn3(){
        re.appendText("3");
    }
    
    public void btn2(){
        re.appendText("2");
    }
    
    public void btn1(){
        re.appendText("1");
    }
    
    public void btn0(){
        re.appendText("0");
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
