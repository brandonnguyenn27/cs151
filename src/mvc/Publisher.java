package mvc;

import tools.Subscriber;

import java.util.*;
public class Publisher {
    private List<tools.Subscriber> subscribers = new LinkedList<tools.Subscriber>();

    public void subscribe(tools.Subscriber s) {
        subscribers.add(s);
    }

    public void unsubscribe(tools.Subscriber s) {
        subscribers.remove(s);
    }

    public void notifySubscribers() {
        for (Subscriber s : subscribers) {
            s.update();
        }
    }


}
