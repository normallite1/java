package ua.testSpring;

import org.springframework.stereotype.Component;

import java.util.Random;


public class RockMusic implements Music{

    public RockMusic(){

    }
    public static RockMusic getClassicalMusic(){
        return new RockMusic();
    }
    public String getSound(){
        return "ACDC";
    }
}
