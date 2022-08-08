public class lessons19 {
    public static void main(String[] args) {
        Humans human1 = new Humans();
        human1.setName("Poma");
        human1.setAge(18);
        human1.getInfo();
    }
}
class Humans {
    String name;
    int age;

    public void setName(String userName){
        name = userName;
    }
    public void setAge(int userAge){
        age = userAge;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void getInfo(){
    System.out.println(name+","+age);
    }
}