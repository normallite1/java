package ua.testSpring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MusicPlayer {

    List<Music> musicList;

    public MusicPlayer(List<Music> musicList){
      this.musicList = musicList;
    }

    public String playMusic(){
        Random random = new Random();
        int i = 3;
        return "Playing: " +musicList.get(random.nextInt(i)).getSound();
    }

}
