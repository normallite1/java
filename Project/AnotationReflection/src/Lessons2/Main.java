package Lessons2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        TextConteiner textConteiner = new TextConteiner("Lox");
        Class<?> cls = TextConteiner.class;
        if(cls.isAnnotationPresent(SaveTo.class)) {
            SaveTo saveTo = cls.getAnnotation(SaveTo.class);
            File file = new File(saveTo.path());
            try {
                Field field = cls.getDeclaredField("text");
                String string = (String) field.get(textConteiner);
                FileWriter writer = new FileWriter(file);
                writer.write(string);
                writer.close();
            } catch (NoSuchFieldException | IllegalAccessException | IOException e) {
                throw new RuntimeException(e);
            }
        }




    }
}
