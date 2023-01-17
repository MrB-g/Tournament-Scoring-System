package systempackage;

import java.util.ArrayList;

public class teamCollector {
    private ArrayList<team> teams = new ArrayList<team>();

    // Additional Methods
    public int getTotalTeams() {
        return teams.size();
    }

    public void deleteTeam(String deleteTeamName) {
        for (int index = 0; index < teams.size(); index++) {
            if(teams.get(index).getTeamName().toLowerCase() == deleteTeamName.toLowerCase()){
                teams.remove(index);
                break;
            }
        }
    }

    public ArrayList<String> getWinnerForEachEvent(int totalEvents) {
        ArrayList<String> winners = new ArrayList<String>();
        int eventId = 0;
        int winningPoint = 0;
        int times = 0;
        String winner = "";
        for (team eachTeam : teams) {
            for (points eachTeamPoints : eachTeam.getPointsForEachEvent()) {
                if (eventId == eachTeamPoints.getEventId()) {
                    if (winningPoint < eachTeamPoints.getPoints()) {
                        winningPoint = eachTeamPoints.getPoints();
                        winner = eachTeam.getTeamName();
                    }
                    break;
                }
            }
            times += 1;
            if (times == totalEvents) {
                winners.add(winner);
                eventId += 1;
                winningPoint = 0;
                times = 0;
                winner = "";
            }
        }
        return winners;
    }
    
    public String getWinnerForAllEvents() {
        String winner = "";
        int winningPoint = 0;
        for (team eachTeam : teams) {
            if (winningPoint < eachTeam.getTotalPoints()) {
                winningPoint = eachTeam.getTotalPoints();
                winner = eachTeam.getTeamName();
            }
        }
        return winner;
    }
    
    // Getter
    public ArrayList<team> getTeams() {
        return teams;
    }

    // Setter 
    public void addTeam(team newTeam) {
        teams.add(newTeam);
    }
}
