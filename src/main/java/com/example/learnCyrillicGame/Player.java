package com.example.learnCyrillicGame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Player {

     private int x;
     private int y;
     private String text;

     private Boolean isMoving = false;

    public Boolean getMoving() {
        return isMoving;
    }

    public void setMoving(Boolean moving) {
        isMoving = moving;
    }

    Image imageSprite;
        public Player(int x, int y, String text) {
            this.x = x;
            this.y = y;
            this.text = text;

             imageSprite = new Image(getClass().getResource("sprite.png").toExternalForm());

        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
            checkBorders();
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
            checkBorders();
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }




    public void render(GraphicsContext gc,int direction, int animationFrame){



        gc.setFill(Color.BLACK);
        gc.setGlobalAlpha(0.4);

        gc.fillOval(this.x+10, this.y+40, 80, 80);
        gc.setGlobalAlpha(1);
        gc.drawImage(imageSprite, 460.25*animationFrame,610*direction,460.25,600,this.x,this.y,100,100);


        }


        public void checkBorders(){
            if(this.x < 0){
                this.x = 0;
            }
            if(this.x > 500){
                this.x =500;
            }
            if(this.y < 0){
                this.y = 0;
            }
            if(this.y > 600){
                this.y = 600;
            }
        }






    }



