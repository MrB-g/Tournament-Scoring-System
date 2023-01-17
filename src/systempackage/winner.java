package systempackage;

public class winner {
    private int eventId;
    private int winnerId;

    // Constructor
    public winner(int eventId_i, int winnerId_i) {
        eventId = eventId_i;
        winnerId = winnerId_i;
    }
    
    // Getter 
    public int getWinnerId() {
        return winnerId;
    }

    public int getEventId() {
        return eventId;
    }

    // Setter
    public void setWinnerId(int newWinnerId) {
        winnerId = newWinnerId;
    }
    
    public void setEventId(int newEventId) {
        eventId = newEventId;
    }
}