package systempackage;

import java.util.ArrayList;

public class teamCollector {
    private ArrayList<team> teams = new ArrayList<team>();

    // Additional Methods
    public int getTotalTeams() {
        return teams.size();
    }

    public boolean deleteTeam(String deleteTeamName) {
        boolean foundIndex = false;
        int deleteIndex = 0;
        for (int index = 0; index < this.getTeams().size(); index++) {
            if (this.getTeams().get(index).getTeamName().toLowerCase().equals(deleteTeamName)) {
                deleteIndex = index;
                foundIndex = true;
            }
        }
        if (foundIndex) {
            this.getTeams().remove(deleteIndex);
        }
        return foundIndex;
    }

    public int getWinnerForSpecificEvent(int eventId) {
        int winningPoint = 0;
        int winnerId = 0;
        for (team eachTeam : teams) {
            for (points eachTeamPoints : eachTeam.getPointsForEachEvent()) {
                if (eventId == eachTeamPoints.getEventId()) {
                    if (winningPoint <= eachTeamPoints.getPoints()) {
                        winningPoint = eachTeamPoints.getPoints();
                        winnerId = eachTeam.getTeamId();
                    }
                    break;
                }
            }
        }
        return winnerId;
    }
    
    public String getWinnerForAllEvents() {
        String finalWinner = "";
        int winningPoint = 0;
        for (team eachTeam : teams) {
            if (winningPoint < eachTeam.getTotalPoints()) {
                winningPoint = eachTeam.getTotalPoints();
                finalWinner = eachTeam.getTeamName();
            }
        }
        return finalWinner;
    }

    public String getTeamNameById(int teamId) {
        String teamName = "";
        for (team eachTeam : teams) {
            if (eachTeam.getTeamId() == teamId) {
                teamName = eachTeam.getTeamName();
                break;
            }
        }
        return teamName;
    }
    
    // Getter
    public ArrayList<team> getTeams() {
        return teams;
    }

    // Setter 
    public void addNewTeam(team newTeam) {
        teams.add(newTeam);
    }
}
