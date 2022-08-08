package ua.testSpring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



public class ClassicalMusic implements Music {

    public ClassicalMusic(){}

    public static ClassicalMusic getClassicalMusic(){
        return new ClassicalMusic();
    }

    public String getSound(){
        return  "Rammstein";
    }
}
