public class ClassesAndObjects {
    public static void main(String[] args) {
        Chel chel1 = new Chel();
        chel1.setName("Ив");
        chel1.setSmm(7);
        System.out.println("vuvodim "+chel1.getName());
        System.out.println("vuvodim "+chel1.getSmm());
        chel1.speak();
    }
}

class Chel {
    private String name;
    private int sm;

    public void setName(String name){
        if (name.isEmpty()){
            System.out.println("ne verno");
        } else {
        this.name = name;}
    }
    public String getName(){
        return name;
    }
    public void setSmm(int sm){
        if (sm<0){
            System.out.println("idi naxye");
        } else {
        this.sm = sm;}
    }
    public int getSmm(){
        return sm;
    }

    void setNameAndUsersm(String username, int usersm){
        name = username;
        sm = usersm;
    }

   public void speak() {
        for (int i = 0; i < 1; i++) {
            System.out.println("Я " + name + " и у меня " + sm + " сантиметров");
        }
    }
    void sayHello(){
        System.out.println("Hello");
    }
}
