package com.example.learnCyrillicGame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private int points = 0;
    private int currentLetter = 0;

    private boolean animationOn = false;
    private boolean goodAnswer = false;
    private int squareToAnimate = 0;


    Audio audio;



    private List<Integer> answers = new ArrayList<>(){{

        add(0);
        add(1);
        add(2);

    }};

    List<String> cyrillicAlphabet = new ArrayList<>() {{
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



    List<String> cyrillicAnswer = new ArrayList<>(){{

        add("-a- // a // father, large ");
        add("-bè- // b // bad, big, bed ");
        add("-vè- // v // water, while ");
        add("-hé- // h // neighbourhood, hello ");
        add( "-gé- // g // egg, gold ");
        add( "-dè- // d // dog, doing ");
        add(  "-è- // e // bed ");
        add( "-yea- // ye, ie // yellow, yes, yet ");
        add( " -j'ai- // zh // pleasure, vision ");
        add( "-zè // z // zoo ");
        add( "-y- // y // mitt ");
        add( "-i- // i // meet ");
        add("-ii or ye- // yi, i // yeast ");
        add("-ij-eu- // y, i // boy, toy ");
        add("-ka- // k // cat, king ");
        add("-l- l // like ");
        add("-m- // m // my ");
        add("-n- // n // never ");
        add("-o- // o // long, more ");
        add("-pè- // p // people ");
        add("-r- // r // rolled r, Italian terra ");
        add("-s- // s // sea, so ");
        add("-t- // t // star, top ");
        add("-ou- // u // boot ");
        add("-f- // f // fight ");
        add("-ha- // kh // ugh ");
        add("-tzè- // ts // sits ");
        add("-tchè- // ch // chat, check ");
        add("-sh- // sh // shoes ");
        add("-ch- shch // fresh cherries ");
        add("ʹ // silent, palatalizes a consonant ");
        add("-you- // yu, iu // use ");
        add("-ja- // ya, ia // yard ");
        add("ʺ // silent, prevents palatalization ");


    }};


    public Game() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
            audio = new Audio();
    }

    public void render(GraphicsContext gc){

        gc.setFill(Color.BISQUE);

        gc.fillRect(0, 0, 600, 120);

        gc.setFill(Color.BLACK);
        gc.setFont(Font.font ("Verdana", 100));
        gc.fillText(cyrillicAlphabet.get(currentLetter), 220, 100);

        gc.setFont(Font.font ("Verdana", 30));
        gc.fillText("points : "+points, 20, 50);
        gc.fillText("points : "+points, 400, 50);


        // 3 question box

        gc.setFill(Color.BEIGE);
        gc.setStroke(Color.ALICEBLUE);
        gc.setLineWidth(10);

        gc.setFont(Font.font ("Verdana", 30));

        gc.strokeRect(10, 150, 100, 100);
        gc.fillText("<-- "+cyrillicAnswer.get(answers.get(0)), 120, 200);

        gc.strokeRect(10, 300, 100, 100);
        gc.fillText("<-- "+cyrillicAnswer.get(answers.get(1)), 120, 350);

        gc.strokeRect(10, 450, 100, 100);
        gc.fillText("<-- "+cyrillicAnswer.get(answers.get(2)), 120, 500);






    }

    public boolean isAnimationOn() {
        return animationOn;
    }

    public void newCurrentLetter(){
        currentLetter = (int)(Math.random() * cyrillicAlphabet.size());

        answers.set(0,currentLetter);
        answers.set(1,(int)(Math.random() * cyrillicAlphabet.size()));
        answers.set(2,(int)(Math.random() * cyrillicAlphabet.size()));

        Collections.shuffle(answers);
    }


    public void checkCollisionRect(Player player) {

        if (collisionBetweenRectangles(player, 10, 150, 100, 100)) {

                answersReaction(answers.get(0) == currentLetter, player);
                squareToAnimate = 0;
                animationOn = true;
        }

        if (collisionBetweenRectangles(player, 10, 300, 100, 100)) {

                answersReaction(answers.get(1) == currentLetter, player);
            squareToAnimate = 1;
            animationOn = true;
        }

        if (collisionBetweenRectangles(player, 10, 450, 100, 100)) {

                answersReaction(answers.get(2) == currentLetter, player);
            squareToAnimate = 2;
            animationOn = true;
        }
    }



    public void answerAnimation(GraphicsContext gc){



        if(goodAnswer){

        gc.setLineWidth(10);


            audio.play();
            gc.setFill(Color.GREEN);
            gc.setStroke(Color.GREEN);
        }
        else {
            audio.playLose();
            gc.setFill(Color.RED);
            gc.setStroke(Color.RED);
        }

 if(squareToAnimate == 0){
            gc.strokeRect(10, 150, 100, 100);
        }
 else if(squareToAnimate == 1){
            gc.strokeRect(10, 300, 100, 100);
        }
 else if(squareToAnimate == 2){
            gc.strokeRect(10, 450, 100, 100);
        }


    }


    private boolean collisionBetweenRectangles(Player player, int x, int y, int width, int height){
        return player.getX() < x + width && player.getX() + 100 > x && player.getY() < y + height && player.getY() + 100 > y;
    }


    private void answersReaction(boolean isCorrect, Player player){
        if(isCorrect){

            goodAnswer = true;
            points++;
            newCurrentLetter();

        }
        else{
            goodAnswer = false;
            points = 0;
        }
        player.setX(450);
        player.setY(300);
    }

    public void setAnimationOff() {
        animationOn = false;
    }
}

