import systempackage.*;

public class app {
    public static void main(String[] args) {
        event testEvent = new event(1, "Chess");
        System.out.println(testEvent.getEventId());
        System.out.println(testEvent.getEventName());
    }
}
