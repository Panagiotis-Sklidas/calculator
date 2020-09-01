/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Panagiotis Sklidas
 */
public class MessageBox {
    public static void show(String message, String title)
{
    Stage stage = new Stage();
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.setTitle(title);
    stage.setMinWidth(250);
    Label lbl = new Label();
    lbl.setText(message);
    lbl.setId("eM");
    Button btnOKay = new Button();
    btnOKay.setText("OK");
    btnOKay.setId("okBtn");
    btnOKay.setDefaultButton(true);
    btnOKay.setOnAction(e -> stage.close()); 
    VBox pane = new VBox(20);
    pane.setPadding(new Insets(25, 25, 25, 25));
    pane.setBackground(new Background(new BackgroundFill(Color.web("#f5f5f5"), CornerRadii.EMPTY, Insets.EMPTY)));
    pane.getChildren().addAll(lbl, btnOKay);
    pane.setAlignment(Pos.CENTER);
    Scene scene = new Scene(pane);
    stage.setScene(scene);
    stage.showAndWait();
    }
}
