package MetaAcademy;

public class EmsAndEns {
    public static boolean isEqually(String str) {
        // WRITE YOUR CODE BELOW THIS LINE
        int m =0;
        boolean bol = true;

        if(str== null){
            bol = false;
        }
        char [] ch = new char[0];
        if (str != null) {
            ch = str.toCharArray();
        }
        for (char c : ch) {
            if (c == 'm' | c == 'M' | c == 'n' | c == 'N') {
                m++;
            }
            if (m % 2 == 0) {
                bol = true;
            } else bol = false;
        }

        return bol;
        // WRITE YOUR CODE ABOVE THIS LINE
    }
}
