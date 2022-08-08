package Lessons36ReadtheFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingForFile {
    public static void main(String[] args) throws FileNotFoundException {
        String separator = File.separator;
        String put = "C:"+separator+"Users"+separator+"Таня"+separator+"Desktop"+separator+"test.txt";
        /* put = put.replace("\\", "/");*/
        File file = new File(put);

        Scanner scanner1 = new Scanner(file);
    String line = scanner1.nextLine();

    scanner1.close();
    }
}
