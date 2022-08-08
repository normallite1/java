public class Lessons24 {
    public static void main(String[] args) {
        human s1  = new human("lox",40);
        System.out.println(s1);
    }
}
class human {
    private String name;
    private int age;

    public human(String userName, int userAge){
        name = userName;
        age = userAge;
    }
    public String toString() {
        return name+" "+age;
    }
}