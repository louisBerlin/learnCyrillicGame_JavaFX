package com.example.learnCyrillicGame;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.*;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button button;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;


    private boolean wIsPressed = false;
    private boolean aIsPressed = false;
    private boolean sIsPressed = false;
    private boolean dIsPressed = false;
    private boolean boost = false;

    private int speed = 1;

    private int points = 0;
    private int currentLetter = 0;

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

        add("a // father, large // абетка (alphabet)");
        add("b // bad, big, bed // бабуся (grandmother)");
        add("v // water, while // віл (ox)");
        add("h // neighbourhood, hello // говорити (to talk)");
        add( "g // egg, gold // ґуля (lump)");
        add( "d // dog, doing // десь (somewhere)");
        add(  "e // bed // церква (church)");
        add( "ye, ie // yellow, yes, yet // моє (my)");
        add( "zh // pleasure, vision // авжеж (of course)");
        add( "z // zoo // забавка (toy)");
        add( "y // mitt // писати (to write)");
        add( "i // meet // ніч (night)");
        add("yi, i // yeast // країна (country)");
        add("y, i // boy, toy // цей (this)");
        add("k // cat, king // канал (channel)");
        add("l // like // лити (to pour)");
        add("m // my // місто (city)");
        add("n // never // вагітна (pregnant)");
        add("o // long, more // вподобайка (like)");
        add("p // people // пес (dog)");
        add("r // rolled r, Italian terra // родина (family)");
        add("s // sea, so // серпень (August)");
        add("t // star, top // додаток (app)");
        add("u // boot // дідусь (grandfather)");
        add("f // fight // фото (photo)");
        add("kh // ugh // хворий (sick)");
        add("ts // sits // цукор (sugar)");
        add("ch // chat, check // рукавичка (glove)");
        add("sh // shoes // шафа (wardrobe)");
        add("shch // fresh cherries // борщ (Borscht)");
        add("ʹ // silent, palatalizes a consonant // кінь (horse)");
        add("yu, iu // use // ключ (key)");
        add("ya, ia // yard // я (I)");
        add("ʺ // silent, prevents palatalization // м'ясо (meat)");


    }};


    Map<String,Integer> cyrillicAlphabetMap = new HashMap<String, Integer>(){{
        put("А а",1);
        put("Б б",2);
        put("В в",3);
        put("Г г",4);
        put("Ґ ґ",5);
        put("Д д",6);
        put("Е е",7);
        put("Є є",8);
        put("Ж ж",9);
        put("З з",10);
        put("И и",11);
        put("І і",12);
        put("Ї ї",13);
        put("Й й",14);
        put("К к",15);
        put("Л л",16);
        put("М м",17);
        put("Н н",18);
        put("О о",19);
        put("П п",20);
        put("Р р",21);
        put("С с",22);
        put("Т т",23);
        put("У у",24);
        put("Ф ф",25);
        put("Х х",26);
        put("Ц ц",27);
        put("Ч ч",28);
        put("Ш ш",29);
        put("Щ щ",30);
        put("Ь ь",31);
        put("Ю ю",32);
        put("Я я",33);
        put("'",34);
    }};





    Map<String, Integer> cyrillicAnswerMap = new HashMap<String, Integer>(){{
        put("a // father, large // абетка (alphabet)",1);
        put("b // bad, big, bed // бабуся (grandmother)",2);
        put("v // water, while // віл (ox)",3);
        put("h // neighbourhood, hello // говорити (to talk)",4);
        put( "g // egg, gold // ґуля (lump)",5);
        put( "d // dog, doing // десь (somewhere)",6);
        put(  "e // bed // церква (church)",7);
        put( "ye, ie // yellow, yes, yet // моє (my)",8);
        put( "zh // pleasure, vision // авжеж (of course)",9);
        put( "z // zoo // забавка (toy)",10);
        put( "y // mitt // писати (to write)",11);
        put( "i // meet // ніч (night)",12);
        put("yi, i // yeast // країна (country)",13);
        put("y, i // boy, toy // цей (this)",14);
        put("k // cat, king // канал (channel)",15);
        put("l // like // лити (to pour)",16);
        put("m // my // місто (city)",17);
        put("n // never // вагітна (pregnant)",18);
        put("o // long, more // вподобайка (like)",19);
        put("p // people // пес (dog)",20);
        put("r // rolled r, Italian terra // родина (family)",21);
        put("s // sea, so // серпень (August)",22);
        put("t // star, top // додаток (app)",23);
        put("u // boot // дідусь (grandfather)",24);
        put("f // fight // фото (photo)",25);
        put("kh // ugh // хворий (sick)",26);
        put("ts // sits // цукор (sugar)",27);
        put("ch // chat, check // рукавичка (glove)",28);
        put("sh // shoes // шафа (wardrobe)",29);
        put("shch // fresh cherries // борщ (Borscht)",30);
        put("ʹ // silent, palatalizes a consonant // кінь (horse)",31);
        put("yu, iu // use // ключ (key)",32);
        put("ya, ia // yard // я (I)",33);
        put("ʺ // silent, prevents palatalization // м'ясо (meat)",34);




    }};



    @FXML
    protected void onHelloButtonClick() {
        //welcomeText.setText(cyrillicAlphabet.get(cyrillicAlphabet.get(new Random().nextInt(cyrillicAlphabet.size()))) );
    }
    @FXML
    protected void onHelloButtonClick2() {



    }








    AnimationTimer collisionTimer = new AnimationTimer() {
        @Override
        public void handle(long l) {

            moveButton();
            checkCollision();
        }


    };

    public void moveButton() {

        if(boost) {
            speed = 4;
        } else {
            speed = 1;
        }

        if(aIsPressed) {
            button.setTranslateX(button.getTranslateX() - speed);
        }
        if(dIsPressed) {
            button.setTranslateX(button.getTranslateX() + speed);
        }
        if(wIsPressed) {
            button.setTranslateY(button.getTranslateY() - speed);
        }
        if(sIsPressed) {
            button.setTranslateY(button.getTranslateY() + speed);
        }

    }


    public void checkCollision () {
        if (button.getBoundsInParent().intersects(button2.getBoundsInParent())) {


            points++;


            initialiseGame();

            welcomeText.setText("Points: " + points);



        }
        else if ( button.getBoundsInParent().intersects(button3.getBoundsInParent())|| button.getBoundsInParent().intersects(button4.getBoundsInParent())) {


            points = 0;

            initialiseGame();

            welcomeText.setText("Points: " + points);


        }
    }





   // @Override
    public void initialize() {

        collisionTimer.start();
        initialiseGame();
    }

    private void initialiseGame() {

        currentLetter =  new Random().nextInt(cyrillicAlphabet.size());


        button.setText(cyrillicAlphabet.get(currentLetter));

        button2.setText(cyrillicAnswer.get(currentLetter));
        button3.setText(cyrillicAnswer.get(new Random().nextInt(cyrillicAlphabet.size())));
        button4.setText(cyrillicAnswer.get(new Random().nextInt(cyrillicAlphabet.size())));



        button2.setTranslateX(new Random().nextInt(300+1)  );
        button2.setTranslateY(new Random().nextInt(300+1) );


        button3.setTranslateX(new Random().nextInt(300+1)  );
        button3.setTranslateY(new Random().nextInt(300+1) );


        button4.setTranslateX(new Random().nextInt(300+1)  );
        button4.setTranslateY(new Random().nextInt(300+1) );

    }

    public void setOnKeyPressed(KeyEvent e) {





            if(e.getCode()== KeyCode.A) {
                aIsPressed = true;
                System.out.println("L");

            }
            if (e.getCode()== KeyCode.D) {
                dIsPressed = true;
                System.out.println("R");

            }
            if (e.getCode()== KeyCode.W) {
                wIsPressed = true;
                System.out.println("W");

            }
            if (e.getCode()== KeyCode.S) {
                sIsPressed = true;
                System.out.println("S");

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
