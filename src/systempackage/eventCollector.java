package systempackage;

import java.util.ArrayList;

public class eventCollector {
    private ArrayList<event> events = new ArrayList<event>();
    private ArrayList<winner> winnerForEachEvent = new ArrayList<winner>();
    private winner winnerForAllEvent;

    // Additional Methods
    public int getTotalEvents() {
        return events.size();
    }
    
    // Getter 
    public ArrayList<event> getEvents() {
        return events;
    }

    public ArrayList<winner> getWinnerForEachEvent() {
        return winnerForEachEvent;
    }

    public winner getWinnerForAllEvent() {
        return winnerForAllEvent;
    }

    // Setter 
    public void addNewEvent(event newEvent) {
        events.add(newEvent);
    }
}
