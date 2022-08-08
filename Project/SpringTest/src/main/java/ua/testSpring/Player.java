package ua.testSpring;

import org.springframework.beans.factory.annotation.Autowired;

public enum Player {
    CLASSICAL(ClassicalMusic.getClassicalMusic()), ROCK(RockMusic.getClassicalMusic());

    private Music music;

    Player(Music music){
        this.music = music;
    }
    public Music getMusic(){
        return music;
    }
}
