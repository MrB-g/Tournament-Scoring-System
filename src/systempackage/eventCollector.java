package systempackage;

import java.util.ArrayList;

public class eventCollector {
    private ArrayList<event> events = new ArrayList<event>();
    private ArrayList<winner> winnerForEachEvent;
    private String winnerForAllEvent;

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

    public String getWinnerForAllEvent() {
        return winnerForAllEvent;
    }

    // Setter 
    public void addNewEvent(event newEvent) {
        events.add(newEvent);
    }

    public void addWinnerForEachEvent(winner newWinner) {
        winnerForEachEvent.add(newWinner);
    }

    public void addWinnerForAllEvent(String finalWinner) {
        winnerForAllEvent = finalWinner;
    }
}
