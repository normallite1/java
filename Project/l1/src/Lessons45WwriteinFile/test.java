package Lessons45WwriteinFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class test {
    public static void main(String[] args) {
        File file = new File("testFile");
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.println("111");
            pw.println("111");
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
}