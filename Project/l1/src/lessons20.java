public class lessons20 {
    public static void main(String[] args) {
        Humanss human1 = new Humanss("Bob",30);
        Humanss human2 = new Humanss("Lox",24);
        human1.field();
        human2.field();
        Humanss human3 = new Humanss("Lov", 39);
        human1.field();
        human3.field();
    }
}
class Humanss {
   private String name;
   private int age;

   public static int lox;

   public Humanss(String name, int age){
       this.name = name;
       this.age = age;
       lox++;
   }

    public void setName(String userName){
        name = userName;
    }
    public void setAge(int userAge){
        age = userAge;
    }
    public void field(){
        System.out.println(lox);
    }
}