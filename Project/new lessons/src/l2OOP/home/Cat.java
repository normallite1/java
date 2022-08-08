package l2OOP.home;

public class Cat {
    private String name;
    private int years;
   Cat (String name, int years){
        this.name=name;
        this.years=years;
  }
    public void setName (String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public int getYears() {
        return years;
    }
    public void setYears(int years) {
        this.years = years;
    }
    public void info(){
       System.out.println("Cat name "+name+","+"years ="+years);
    }
    public String reName (Cat a, String newName){
       a.name=newName;
       return name;
    }
}
