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
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;


public class Main extends Application {



    private int height = 600;
    private int width = 700;

    Scene scene;

    Player player;
    Game game = new Game();
    private boolean wIsPressed = false;
    private boolean aIsPressed = false;
    private boolean sIsPressed = false;
    private boolean dIsPressed = false;
    private boolean boost = false;

    private int speed = 1;

    private int animationFrame = 0;

    int direction = 0;





  /* Transition trans = new Transition() {
        {
            setCycleDuration(Duration.millis(1000 / 60.0));
        }
        @Override
        public void interpolate(double frac)
        {
            if (frac != 1)
                return;
            //End of one cycle.

                animationFrame++;
                if (animationFrame > 3) {
                    animationFrame = 0;
                }
            }


    };

   */



   /* AnimationTimer animationFrameTimer = new AnimationTimer() {
        @Override
        public void handle(long l) {

            animationFrame++;
            if(animationFrame>3) {
                animationFrame = 0;
            }

        }


    };

    */


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) {



         player = new Player(450, 300, "Ф ф");
         direction = 2;

         stage.setTitle( animationFrame + "THE cyrillic game !!!!! (win the louisAward 2024)");
        StackPane pane = new StackPane();
        Canvas canvas = new Canvas(height, width);
        canvas.setFocusTraversable(true);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.strokeText("Hello, World!", 10, 10);
        gc.fillRect(player.getX(), player.getY(), player.getX()+10, player.getY()+10);

       /* AnimationTimer collisionTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {

                movePlayer(gc);

            }


        };

        */
      //  collisionTimer.start();


        Timeline loop = new Timeline(new KeyFrame(Duration.millis(1000.0/40), e -> update(gc)));
        loop.setCycleCount(Animation.INDEFINITE);
        loop.play();


        Timeline loopAnim = new Timeline(new KeyFrame(Duration.millis(1000.0/5), e -> loopAnimation()));
        loopAnim.setCycleCount(Animation.INDEFINITE);
        loopAnim.play();




        pane.getChildren().add(canvas);
        scene = new Scene(pane, height, width);

       // trans.play();

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



    private void update(GraphicsContext gc) {
        System.out.println(animationFrame);

        movePlayer(gc);
        if (!aIsPressed && !dIsPressed && !wIsPressed && !sIsPressed) {

            animationFrame = 1;
            if (direction == 2) {
                animationFrame = 0;
            }
        }

    }



    public void movePlayer(GraphicsContext gc) {


        //get a rendom nummer between 1 and 10
        int randomNum = 1 + (int)(Math.random() * 10);
        gc.clearRect(0, 0, 200, 200);
        Image image = new Image(getClass().getResource("TXGrass.png").toExternalForm(), 200, 200, false, false);

        //ImagePattern imagePattern = new ImagePattern(image,100,100,100,100,true);


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
        gc.drawImage(image, 100, 0,100,100,100,100,100,100);


        //gc.setFill(imagePattern);

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
