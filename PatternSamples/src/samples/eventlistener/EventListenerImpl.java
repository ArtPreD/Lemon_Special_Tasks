package samples.eventlistener;


public class EventListenerImpl implements EventListener {

    public void createListeners(){
        EventSource source = new EventSource();
        EventListenerImpl eventListener1 = new EventListenerImpl();
        source.addListener(eventListener1);
        EventListenerImpl eventListener2 = new EventListenerImpl();
        source.addListener(eventListener2);
        EventListenerImpl eventListener3 = new EventListenerImpl();
        source.addListener(eventListener3);
        EventListenerImpl eventListener4 = new EventListenerImpl();
        source.addListener(eventListener4);
        EventListenerImpl eventListener5 = new EventListenerImpl();
        source.addListener(eventListener5);
    }

    public void handle() {
        System.out.println("Hello!!!");
    }
}
