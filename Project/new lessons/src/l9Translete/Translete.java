package l9Translete;

import java.io.*;
import java.util.*;

public class Translete {
   private Map<String,String> vocabulary = new HashMap<>();

   public  Translete(){
       addwords();
   }
   public void addwords (){
       vocabulary.put("table","стол");
       vocabulary.put("put","положить");
       vocabulary.put("sell","продать");
       vocabulary.put("you","ты");
       vocabulary.put("lol","смех");
       vocabulary.put("lox","лох");
       vocabulary.put("last","последний");
       vocabulary.put("summer","лето");
   }

    public Map<String, String> getVocabulary() {
        return vocabulary;
    }
    public void intractiveAddWords(){
       System.out.println("Write English");
       Scanner scanner1 = new Scanner(System.in);
       String s1 = scanner1.nextLine();
       System.out.println("Write Russian translete");
        Scanner scanner2 = new Scanner(System.in);
       String s2 = scanner2.nextLine();
       vocabulary.put(s1,s2);
       scanner1.close();
       scanner2.close();
    }
    public void transleteText(File file, File file2){
        try {
            FileReader file1 = new FileReader(file);
            BufferedReader input = new BufferedReader(file1);
            String string = input.readLine();
            ArrayList<String> list = new ArrayList<>(List.of(string.split(" ")));
            Set<Map.Entry<String, String>> hms =vocabulary.entrySet();
            String s1 = "";
            for(Map.Entry<String, String> hmse :hms) {
                for (String s : list) {
                    if (s.equals(hmse.getKey())) {
                        s1 = hmse.getValue();
                        System.out.println(s1);
                    }
                    }
                }
            PrintWriter a = new PrintWriter(file2);
            a.println(s1);
            a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
