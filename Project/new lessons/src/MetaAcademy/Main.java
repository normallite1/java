package MetaAcademy;

public class Main {
    public static void main(String[] args) {

//        System.out.println(EmsAndEns.isEqually("mmmMMMnnNN"));
//        System.out.println(EmsAndEns.isEqually(""));
//        System.out.println(EmsAndEns.isEqually(null));
        String input = "aaaeehhhh";
        char [] strings = input.toCharArray();
        StringBuilder a = new StringBuilder();
        String b = "";
        for (char c : strings) {
            if (c == 'a' | c == 'e' | c == 'i' | c == 'o' | c=='u' ){
                a.append(c);
            }
        }
        a = b;
        return b;
    }
}
