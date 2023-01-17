package systempackage;

import java.util.ArrayList;

public class individual {
    private int individualId;
    private String individualName;
    private ArrayList<points> pointsForEachEvent;

    // Additional Methods
    public int getTotalPoints() {
        int totalPoints = 0;
        for (points point : pointsForEachEvent) {
            totalPoints += point.getPoints();
        }
        return totalPoints;
    }

    // Constructor
    public individual(int individualId_i, String individualName_i) {
        individualId = individualId_i;
        individualName = individualName_i;
    }

    // Getter
    public int getIndividualId() {
        return individualId;
    }

    public String getIndividualName() {
        return individualName;
    }

    public ArrayList<points> getPointsForEachEvent() {
        return pointsForEachEvent;
    }
    
    // Setter
    public void setIndividualId(int newIndividualId) {
        individualId = newIndividualId;
    }

    public void setIndividualName(String newIndividualName) {
        individualName = newIndividualName;
    }
    
    public void addPointsForEachEvent(points newPoint) {
        pointsForEachEvent.add(newPoint);
    }
}
