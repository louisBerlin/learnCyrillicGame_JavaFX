package com.example.learnCyrillicGame;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class Audio {


    Clip clip;

    Clip clipLose;

    // current status of clip
    String status;

    AudioInputStream audioInputStream;

    AudioInputStream audioInputStreamLose;
    public String filePath = "src/main/resources/win2.wav";

    // constructor to initialize streams and clip
    public Audio() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        // create AudioInputStream object
        audioInputStream =
                AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        // create clip reference
        clip = AudioSystem.getClip();
        // open audioInputStream to the clip
        clip.open(audioInputStream);
       // clip.loop(Clip.LOOP_CONTINUOUSLY);

        audioInputStreamLose =
                AudioSystem.getAudioInputStream(new File("src/main/resources/lose.wav").getAbsoluteFile());
        // create clip reference
        clipLose = AudioSystem.getClip();
        // open audioInputStream to the clip
        clipLose.open(audioInputStreamLose);
    }


    public void play()
    {
        //start the clip
        clip.setFramePosition(0);
        clip.start();

        status = "play";
    }

    public void playLose()
    {
        //start the clip
        clipLose.setFramePosition(0);
        clipLose.drain();

        clipLose.start();

        status = "play";
    }
}
