package l8ColaDrink;

public class Human implements Cloneable {
    @Override
    public String toString() {
        return  surname;
    }

    private String surname;

    public Human (String surname){
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Human clone() {
        try {
            return (Human) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    public Human drinkCola (DoubleCola cola) {
        cola=null;
        return this.clone();
    }
}
