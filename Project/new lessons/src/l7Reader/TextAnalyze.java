package l7Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextAnalyze {
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;

    public TextAnalyze(File file){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            while ((text=reader.readLine())!=null){
                stringBuilder.append(reader.readLine());
            }
            text=stringBuilder.toString();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void charStatistic(){
        Map<Character, Integer> map = new HashMap<>(text.length());
        for (int i = 0; i<text.length(); i++){
            Character character = text.charAt(i);
            if(!Character.isLetter(character))continue;
            character = Character.toLowerCase(character);
            if(map.containsKey(character)){
                map.put(character, map.get(character)+1);
            }
            else map.put(character, 1);
        }
        List statList = new ArrayList(map.entrySet());

        Collections.sort(statList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });

        System.out.println(statList);
    }

}
