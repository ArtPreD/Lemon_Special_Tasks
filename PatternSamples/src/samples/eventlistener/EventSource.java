package samples.eventlistener;

import java.util.LinkedList;
import java.util.List;

public class EventSource {
    private static List<EventListener> listeners = new LinkedList<>();

    public void addListener(EventListener listener){
        listeners.add(listener);
    }

    public void removeListener(EventListener listener){
        listeners.remove(listener);
    }

    public static void fireEvent(){
        listeners.forEach(EventListener::handle);
    }

    public static void main(String[] args) {
        new EventListenerImpl().createListeners();
        fireEvent();
    }
}
