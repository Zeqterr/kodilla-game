package com.kodilla.view;

import com.kodilla.model.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
public class ViewManager {
    private static final int HEIGHT = 768;
    private static final int WIDTH = 1024;
    private final static int MENU_BUTTONS_START_X = 100;
    private final static int MENU_BUTTONS_START_Y = 150;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;
    private rpgameSubScene optionsSubScene;
    private rpgameSubScene helpSubScene;
    private rpgameSubScene scoreSubScene;
    private rpgameSubScene characterMenuScene;
    private rpgameSubScene sceneToHide;
    List<rpgameButton> menuButtons;
    List<CharacterPicker> charactersList;
    private CHARACTER choosenCharacter;
    public ViewManager() {
        menuButtons = new ArrayList<>();
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane,WIDTH,HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createButtons();
        createBackground();
        createLogo();
        createSubScenes();
    }
    private void showSubScene(rpgameSubScene subScene) {
        if (sceneToHide != null) {
            sceneToHide.moveSubScene();
        }
        subScene.moveSubScene();
        sceneToHide = subScene;
    }
    private void createSubScenes() {
        optionsSubScene = new rpgameSubScene();
        mainPane.getChildren().add(optionsSubScene);
        helpSubScene = new rpgameSubScene();
        mainPane.getChildren().add(helpSubScene);
        scoreSubScene = new rpgameSubScene();
        mainPane.getChildren().add(scoreSubScene);

        characterMenuSubScene();
    }
    private void characterMenuSubScene() {
        characterMenuScene = new rpgameSubScene();
        mainPane.getChildren().add(characterMenuScene);
        InfoLabel chooseCharacterLabel = new InfoLabel("CHOOSE YOUR CHARACTER");
        chooseCharacterLabel.setLayoutX(110);
        chooseCharacterLabel.setLayoutY(25);
        characterMenuScene.getPane().getChildren().add(chooseCharacterLabel);
//        characterMenuScene.getPane().getChildren().add(createCharactersToChoose());
        characterMenuScene.getPane().getChildren().add(createButtonToStart());
    }
    private HBox createCharactersToChoose(){
        HBox box = new HBox();
        box.setSpacing(20);
        charactersList = new ArrayList<>();
        for(CHARACTER character : CHARACTER.values()){
            CharacterPicker characterToPick = new CharacterPicker(character);
            charactersList.add(characterToPick);
            box.getChildren().add(characterToPick);
            characterToPick.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    for (CharacterPicker character : charactersList){
                        character.setIsCircleChoosen(false);
                    }
                    characterToPick.setIsCircleChoosen(true);
                    choosenCharacter = characterToPick.getCharacter();
                }
            });
        }
        box.setLayoutX(300 - (118 * 2));
        box.setLayoutY(100);
        return box;
    }
    private rpgameButton createButtonToStart(){
        rpgameButton startButton = new rpgameButton("START");
        startButton.setLayoutX(350);
        startButton.setLayoutY(300);
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                if(choosenCharacter != null){
//
//                }
                gameViewManager gameManager = new gameViewManager();
                gameManager.createNewGame(mainStage, choosenCharacter);
            }
        });
        return startButton;
    }
    public Stage getMainStage(){
        return mainStage;
    }
    private void addMenuButton(rpgameButton button){
        button.setLayoutX(MENU_BUTTONS_START_X);
        button.setLayoutY(MENU_BUTTONS_START_Y + menuButtons.size() * 100);
        menuButtons.add(button);
        mainPane.getChildren().add(button);
    }
    private void createButtons() {
        createStartButton();
        createScoresButton();
        createHelpButton();
        createOptionsButton();
        createExitButton();
    }
    private void createStartButton(){
        rpgameButton startButton = new rpgameButton("PLAY");
        addMenuButton(startButton);
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showSubScene(characterMenuScene);
            }
        });
    }
    private void createScoresButton(){
        rpgameButton scoresButton = new rpgameButton("Scores");
        addMenuButton(scoresButton);
        scoresButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showSubScene(scoreSubScene);
            }
        });
    }
    private void createHelpButton(){
        rpgameButton helpButton = new rpgameButton("HELP");
        addMenuButton(helpButton);
        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showSubScene(helpSubScene);
            }
        });
    }
    private void createOptionsButton(){
        rpgameButton optionsButton = new rpgameButton("OPTIONS");
        addMenuButton(optionsButton);
        optionsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showSubScene(optionsSubScene);
            }
        });
    }
    private void createExitButton() {
        rpgameButton exitButton = new rpgameButton("Exit");
        addMenuButton(exitButton);

        exitButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                Platform.exit();
            }
        });
    }
    private void createBackground() {
        Image backgroundImage = new Image("file:src/main/resources/stage1.png", 256, 256, false, true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(background));
    }
    private void createLogo(){
        ImageView logo = new ImageView("file:src/main/resources/resized.png");
        logo.setLayoutX(400);
        logo.setLayoutY(50);
        logo.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logo.setEffect(new DropShadow());
            }
        });
        logo.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                logo.setEffect(null);
            }
        });
        mainPane.getChildren().add(logo);
    }
}
