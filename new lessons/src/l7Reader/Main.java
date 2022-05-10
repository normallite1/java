package l7Reader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Map<Character, Long> mapa = null;
        try {
            mapa = Files.lines(Paths.get("C:/Users/Таня/Desktop/java/new lessons/src/l7Reader/text"))
            .map(n-> n.toUpperCase())
                    .flatMapToInt(n -> n.chars())
                    .filter(n-> n>='A' && n<='Z')
                    .mapToObj((n) -> (Character.valueOf((char) n)))
                    .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        } catch (IOException e){
            System.out.println(e);
        }
        for (Character key : mapa.keySet()) {
            System.out.println(key + " - " + mapa.get(key));
        }

    }
}
