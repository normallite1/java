package l9Translete;
import java.io.File;


public class Main {
    public static void main(String[] args) {
        File file = new File("C:/Users/Таня/Desktop/java/new lessons/src/l9Translete/English");
        File file2 = new File("C:/Users/Таня/Desktop/java/new lessons/src/l9Translete/Ukraine");

        Translete translete = new Translete();
        translete.addwords();
        // translete.intractiveAddWords();
        translete.getVocabulary().forEach((k,v) -> System.out.println("English: "+k+" Translate:"+v));
        translete.transleteText(file,file2);
    }
}
