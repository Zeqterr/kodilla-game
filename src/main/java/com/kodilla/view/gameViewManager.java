package com.kodilla.view;

import com.kodilla.model.CHARACTER;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class gameViewManager {
    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;
    private static final int GAME_WIDTH = 600;
    private static final int GAME_HEIGHT = 800;
    private Stage menuStage;
    private ImageView character;
    private boolean isLeftKeyPressed;
    private boolean isRightKeyPressed;
    private AnimationTimer gameTimer;


    public gameViewManager() {
        initializeStage();
        createKeysListeners();
    }

    private void createKeysListeners() {
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.LEFT) {
                    isLeftKeyPressed = true;
                } else if (event.getCode() == KeyCode.RIGHT) {
                    isRightKeyPressed = true;
                }
//                if (event.getCode() == KeyCode.SPACE) {
//                    isSpacePressed = true;
//                    isBulletFired = true;//}
            }
        });

        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.LEFT) {
                    isLeftKeyPressed = false;
                } else if (event.getCode() == KeyCode.RIGHT) {
                    isRightKeyPressed = false;
                }
//                if (event.getCode() == KeyCode.SPACE)
//                   isSpacePressed = false;
//                   isBulletFired = false;
//                }
            }
        });
    }

    private void initializeStage() {
        gamePane = new AnchorPane();
        gameScene = new Scene(gamePane, GAME_HEIGHT, GAME_WIDTH);
        gameStage = new Stage();
        gameStage.setScene(gameScene);
    }

    public void createNewGame(Stage menuStage, CHARACTER choosenCharacter) {
        this.menuStage = menuStage;
        this.menuStage.hide();
        createCharacter(choosenCharacter);
        createGameLoop();
        gameStage.show();
    }

    private void createCharacter(CHARACTER choosenCharacter) {
        character = new ImageView("resources/standl000chirno.png");
        //starting pos for char
        character.setLayoutX(GAME_WIDTH / 2);
        character.setLayoutY(GAME_HEIGHT - 90);
        gamePane.getChildren().add(character);
    }

    private void createGameLoop() {
        gameTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {

            }
        };
        gameTimer.start();
    }

    private void moveCharacter() {
        if (isLeftKeyPressed && !isRightKeyPressed) {
            if (character.getLayoutX() > -20) {
                character.setLayoutX(character.getLayoutX() - 3);
            }
        }
        if (isRightKeyPressed && !isLeftKeyPressed) {
            if (character.getLayoutX() < 522) {
                character.setLayoutX(character.getLayoutX() + 3);
            }
        }
    }
}