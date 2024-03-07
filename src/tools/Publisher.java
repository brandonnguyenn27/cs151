package tools;

import java.util.LinkedList;
import java.util.List;

public class Publisher {

    private List<Subscriber> observers = new LinkedList<Subscriber>();
    public void subscribe(Subscriber subscriber) {
        observers.add(subscriber);
    }
    public void unsubscribe(Subscriber subscriber){
        observers.remove(subscriber);
    }
    public void notifySubscribers(){
        for(Subscriber s : observers){
            s.update();
        }

    }
}
