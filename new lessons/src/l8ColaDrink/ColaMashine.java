package l8ColaDrink;

import java.util.ArrayDeque;

public class ColaMashine {

    private ArrayDeque<DoubleCola> colaConteiner = new ArrayDeque<>();
    private int colaMashinesize;
    private ArrayDeque<Human> humanArrayDeque = new ArrayDeque<>();

    public ColaMashine(int colaMashinesize){
        this.colaMashinesize=colaMashinesize;
    }
    public void putCola(DoubleCola cola){
        if(colaConteiner.size()<colaMashinesize){
            colaConteiner.add(cola);
        } else {
            System.out.println("Conteiner is full");
        }
    }
    public void addedHumanToQoeue (Human human){
        humanArrayDeque.addLast(human);
    }
    public void gevHumanTheFirstInQueue(){
        if(colaConteiner.size()>0){
            Human firstHumanInQueue = humanArrayDeque.poll();
            Human cloneHuman = firstHumanInQueue.drinkCola(colaConteiner.poll());
            humanArrayDeque.addLast(firstHumanInQueue);
            humanArrayDeque.addLast(firstHumanInQueue.clone());
        }
    }
    public void showHuman(){
        for (Human human : humanArrayDeque){
            System.out.println(human +" ");
        }
    }
}
