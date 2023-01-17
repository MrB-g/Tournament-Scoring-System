package systempackage;

import java.util.ArrayList;

public class team {
    private int teamId;
    private String teamName;
    private ArrayList<points> pointsForEachEvent = new ArrayList<points>();

    // Additional Methods
    public int getTotalPoints() {
        int totalPoints = 0;
        for (points point : pointsForEachEvent) {
            totalPoints += point.getPoints();
        }
        return totalPoints;
    }
    
    // Constructor
    public team(int teamId_i, String teamName_i) {
        teamId = teamId_i;
        teamName = teamName_i;
    }

    // Getter 
    public int getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public ArrayList<points> getPointsForEachEvent() {
        return pointsForEachEvent;
    }

    // Setter
    public void setTeamId(int newTeamId) {
        teamId = newTeamId;
    }

    public void setTeamName(String newTeamName) {
        teamName = newTeamName;
    }

    public void addPointsForEachEvent(points newPoint) {
        pointsForEachEvent.add(newPoint);
    }
}
