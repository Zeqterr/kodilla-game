package com.kodilla.model;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;

import javax.swing.plaf.basic.BasicCheckBoxMenuItemUI;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class InfoLabel extends Label {
    public final static String FONT_PATH = "src/main/java/com/kodilla/model/resources/kenvector_future.ttf";
    public final static String BACKGROUND_IMAGE = "C:\\Users\\bazyl\\IdeaProjects\\kodilla_game1\\src\\main\\java\\com\\kodilla\\model\\resources\\yellow_small_panel.png";
    public InfoLabel(String text){

        setPrefWidth(380);
        setPrefHeight(49);
        setPadding(new Insets(0,10,0,10));
        setText(text);
        setWrapText(true);
        setLabelFont();
        BackgroundImage backgroundImage = new BackgroundImage(new Image(BACKGROUND_IMAGE, 380, 49, false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        setBackground(new Background(backgroundImage));
    }
    private void setLabelFont(){

        try{
        setFont(Font.loadFont(new FileInputStream(new File(FONT_PATH)), 21));
    } catch (FileNotFoundException e) {
            setFont(Font.font("Verdana", 23));
        }
    }
}
