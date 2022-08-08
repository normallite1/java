package l8ColaDrink;

public class ColaDeqe {
    public static void main(String[] args) {
        ColaMashine colaMashine = new ColaMashine(20);
        for (int i = 0; i<20; i++ ) {
            colaMashine.putCola(new DoubleCola());
        }
        colaMashine.addedHumanToQoeue(new Human("Sheldon"));
        colaMashine.addedHumanToQoeue(new Human("Cutropali"));
        colaMashine.addedHumanToQoeue(new Human("Peny"));
        colaMashine.addedHumanToQoeue(new Human("Volovech"));
        colaMashine.showHuman();
        colaMashine.gevHumanTheFirstInQueue();
        colaMashine.gevHumanTheFirstInQueue();
        colaMashine.showHuman();

    }
}
