package com.example.learnCyrillicGame;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;



public class MainFrame extends Application {


    final int height = 600;
    final int width = 700;

    Scene scene;
    Player player;
    Game game  ;
    private Timeline mainLoopTimer;
    private boolean wIsPressed = false;
    private boolean aIsPressed = false;
    private boolean sIsPressed = false;
    private boolean dIsPressed = false;
    private boolean boost = false;

    private int speed = 1;

    private int animationFrame = 0;

    int direction = 0;





    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws UnsupportedAudioFileException, LineUnavailableException, IOException {



         game = new Game();
         player = new Player(450, 300);
         direction = 2;







        stage.setTitle( "THE cyrillic game !!!!! (win the louisAward 2024)");
         StackPane pane = new StackPane();
         Canvas canvas = new Canvas(height, width);
         canvas.setFocusTraversable(true);
         GraphicsContext gc = canvas.getGraphicsContext2D();



        mainLoopTimer = new Timeline(new KeyFrame(Duration.millis(1000.0/40), e -> mainLoop(gc)));
        mainLoopTimer.setCycleCount(Animation.INDEFINITE);
        mainLoopTimer.play();


        Timeline loopPlayerAnimation = new Timeline(new KeyFrame(Duration.millis(1000.0/5), e -> loopAnimation()));
        loopPlayerAnimation.setCycleCount(Animation.INDEFINITE);
        loopPlayerAnimation.play();





        pane.getChildren().add(canvas);

        scene = new Scene(pane, height, width);
        scene.setOnKeyPressed(e -> setOnKeyPressed(e));
        scene.setOnKeyReleased(e -> setOnKeyReleased(e));

        stage.setScene(scene);
        stage.show();

    }


    private void loopAnimation() {
        if (aIsPressed || dIsPressed || wIsPressed || sIsPressed) {

        animationFrame++;

        if (animationFrame > 3) {
            animationFrame = 0;
        }
        }else {
            animationFrame = 1;
            if(direction == 2) {
                animationFrame = 0;
            }
        }
    }


private int breakTime = 0;
    private void mainLoop(GraphicsContext gc) {




        if(game.isAnimationOn()) {



            if(breakTime == 0) {
                game.answerAnimation(gc);
                breakTime++;
            }
            else if(breakTime >= 15) {
                breakTime = 0;
                game.setAnimationOff();

            }
            else if(breakTime >= 1) {
                breakTime++;
            }





        }
        else     movePlayer(gc);



    }



    public void movePlayer(GraphicsContext gc) {



        gc.clearRect(0, 0, 200, 200);
        Image image = new Image(getClass().getResource("TXGrass.png").toExternalForm(), 200, 200, false, false);



        // ainimation
        int axeX = 0;
        int axey = 0;
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                gc.drawImage(image,100, 0,100,100, axeX, axey, 100, 100);
                axeX += 100;
            }
            axey += 100;
            axeX = 0;}


        // move player
        if(boost) {
            speed = 8;
        } else {
            speed = 4;
        }

        if(aIsPressed) {
            player.setX(player.getX() - speed);
            player.setMoving(true);
            direction = 2;

        }
        if(dIsPressed) {
            player.setX(player.getX() + speed);
            player.setMoving(true);

            direction = 1;

        }
        if(wIsPressed) {
            player.setY(player.getY() - speed);

            direction = 3;


        }
        if(sIsPressed) {
            player.setY(player.getY() + speed);
            player.setMoving(true);

            direction = 0;


        }

        game.render(gc);

        player.render(gc,direction,animationFrame);

        game.checkCollisionRect(player);


    }
    public void setOnKeyPressed(KeyEvent e) {


        if(e.getCode()== KeyCode.A) {
            System.out.println("L");
            aIsPressed = true;
            player.setMoving(true);


        }
        if (e.getCode()== KeyCode.D) {
            dIsPressed = true;
            System.out.println("R");
            player.setMoving(true);

        }
        if (e.getCode()== KeyCode.W) {
            wIsPressed = true;
            System.out.println("W");
            player.setMoving(true);

        }
        if (e.getCode()== KeyCode.S) {
            sIsPressed = true;
            System.out.println("S");
            player.setMoving(true);

        }
        if(e.getCode()== KeyCode.M) {
            boost = true;

        }



    }

    public void setOnKeyReleased(KeyEvent e) {


        if(e.getCode()== KeyCode.A) {
            aIsPressed = false;
        }
        if (e.getCode()== KeyCode.D) {
            dIsPressed = false;
        }
        if (e.getCode()== KeyCode.W) {
            wIsPressed = false;
        }
        if (e.getCode()== KeyCode.S) {
            sIsPressed = false;
        }
        if(e.getCode()== KeyCode.M) {
            boost = false;
        }

    }


}
