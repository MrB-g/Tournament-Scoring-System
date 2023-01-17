package systempackage;

public class points {
    private int points;
    private int eventId;
    
    // Constructor
    public points(int points_i, int eventId_i) {
        points = points_i;
        eventId = eventId_i;
    }

    // Getter 
    public int getPoints() {
        return points;
    }

    public int getEventId() {
        return eventId;
    }

    // Setter
    public void setPoints(int newPoints) {
        points = newPoints;
    }

    public void setEventId(int newEventId) {
        eventId = newEventId;
    }
}
