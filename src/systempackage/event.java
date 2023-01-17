package systempackage;

public class event {
    private int eventId;
    private String eventName;

    // Constructor
    public event(int eventId_i, String eventName_i) {
        eventId = eventId_i;
        eventName = eventName_i;
    }

    // Getter
    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    // Setter
    public void setEventId(int newEventId) {
        eventId = newEventId;
    }

    public void setEventName(String newEventName) {
        eventName = newEventName;
    }
}

