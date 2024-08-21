package com.example.learnCyrillicGame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game {

    private int points = 0;
    private int currentLetter = 0;

    private Rectangle rectangle1 = new Rectangle(10, 150, 100, 100);
    private Rectangle rectangle2 = new Rectangle(10, 300, 100, 100);
    private Rectangle rectangle3 = new Rectangle(10, 450, 100, 100);

    private List<Integer> answers = new ArrayList<Integer>(){{

        add(0);
        add(1);
        add(2);

    }};

    List<String> cyrillicAlphabet = new ArrayList<String>(){{
        add("А а");
        add("Б б");
        add("В в");
        add("Г г");
        add("Ґ ґ");
        add("Д д");
        add("Е е");
        add("Є є");
        add("Ж ж");
        add("З з");
        add("И и");
        add("І і");
        add("Ї ї");
        add("Й й");
        add("К к");
        add("Л л");
        add("М м");
        add("Н н");
        add("О о");
        add("П п");
        add("Р р");
        add("С с");
        add("Т т");
        add("У у");
        add("Ф ф");
        add("Х х");
        add("Ц ц");
        add("Ч ч");
        add("Ш ш");
        add("Щ щ");
        add("Ь ь");
        add("Ю ю");
        add("Я я");
        add("'");
    }};



    List<String> cyrillicAnswer = new ArrayList<String>(){{

        add("a // father, large ");
        add("b // bad, big, bed ");
        add("v // water, while ");
        add("h // neighbourhood, hello ");
        add( "g // egg, gold ");
        add( "d // dog, doing ");
        add(  "e // bed ");
        add( "ye, ie // yellow, yes, yet ");
        add( "zh // pleasure, vision ");
        add( "z // zoo ");
        add( "y // mitt ");
        add( "i // meet ");
        add("yi, i // yeast ");
        add("y, i // boy, toy ");
        add("k // cat, king ");
        add("l // like ");
        add("m // my ");
        add("n // never ");
        add("o // long, more ");
        add("p // people ");
        add("r // rolled r, Italian terra ");
        add("s // sea, so ");
        add("t // star, top ");
        add("u // boot ");
        add("f // fight ");
        add("kh // ugh ");
        add("ts // sits ");
        add("ch // chat, check ");
        add("sh // shoes ");
        add("shch // fresh cherries ");
        add("ʹ // silent, palatalizes a consonant ");
        add("yu, iu // use ");
        add("ya, ia // yard ");
        add("ʺ // silent, prevents palatalization ");


    }};

    public void render(GraphicsContext gc){

        gc.setFill(Color.WHITE);
        gc.setFont(Font.font ("Verdana", 100));
        gc.fillText(cyrillicAlphabet.get(currentLetter), 220, 100);

        gc.setFont(Font.font ("Verdana", 30));
        gc.fillText("points : "+points, 20, 50);
        gc.fillText("points : "+points, 400, 50);


        // 3 question box

        gc.setFill(Color.BEIGE);
        gc.setFont(Font.font ("Verdana", 20));

        gc.fillRect(10, 150, 100, 100);
        gc.fillText("<-- "+cyrillicAnswer.get(answers.get(0)), 120, 200);

        gc.fillRect(10, 300, 100, 100);
        gc.fillText("<-- "+cyrillicAnswer.get(answers.get(1)), 120, 350);

        gc.fillRect(10, 450, 100, 100);
        gc.fillText("<-- "+cyrillicAnswer.get(answers.get(2)), 120, 500);



    }


    public void newCurrentLetter(){
        currentLetter = (int)(Math.random() * cyrillicAlphabet.size());

        answers.set(0,currentLetter);
        answers.set(1,(int)(Math.random() * cyrillicAlphabet.size()));
        answers.set(2,(int)(Math.random() * cyrillicAlphabet.size()));

        Collections.shuffle(answers);
    }


    public void checkCollisionRect(Player player){

        if(collisionBetweenRectangles(player, 10, 150, 100, 100)){
            if(answers.get(0) == currentLetter){
                points++;
                newCurrentLetter();
                player.setX(500);
                player.setY(500);
            }
            else{
                points = 0;
                player.setX(500);
                player.setY(500);
            }
        }
        if(collisionBetweenRectangles(player, 10, 300, 100, 100)){
            if(answers.get(1) == currentLetter){
                points++;
                newCurrentLetter();
                player.setX(500);
                player.setY(500);
            }
            else{
                points = 0;
                player.setX(500);
                player.setY(500);
            }
        }
        if(collisionBetweenRectangles(player, 10, 450, 100, 100)){
            if(answers.get(2) == currentLetter){
                points++;
                newCurrentLetter();
                player.setX(500);
                player.setY(500);
            }
            else{
                points = 0;
                player.setX(500);
                player.setY(500);
            }
        }

    }


    private boolean collisionBetweenRectangles(Player player, int x, int y, int width, int height){
        return player.getX() < x + width && player.getX() + 100 > x && player.getY() < y + height && player.getY() + 100 > y;
    }



}
