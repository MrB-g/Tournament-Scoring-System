package systempackage;

import java.util.ArrayList;

public class individualCollector {
    private ArrayList<individual> individuals = new ArrayList<individual>();

    // Additional Methods
    public int getTotalIndividuals() {
        return individuals.size();
    }

    public void deleteIndividual(String deleteIndividualName) {
        for (int index = 0; index < individuals.size(); index++) {
            if (individuals.get(index).getIndividualName().toLowerCase() == deleteIndividualName.toLowerCase()) {
                individuals.remove(index);
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
        for (individual eachIndividual : individuals) {
            for (points eachIndividualPoints : eachIndividual.getPointsForEachEvent()) {
                if (eventId == eachIndividualPoints.getEventId()) {
                    if (winningPoint < eachIndividualPoints.getPoints()) {
                        winningPoint = eachIndividualPoints.getPoints();
                        winner = eachIndividual.getIndividualName();
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
        for (individual eachIndividual : individuals) {
            if (winningPoint < eachIndividual.getTotalPoints()) {
                winningPoint = eachIndividual.getTotalPoints();
                winner = eachIndividual.getIndividualName();
            }
        }
        return winner;
    }
    
    // Getter
    public ArrayList<individual> getIndividuals() {
        return individuals;
    }

    // Setter
    public void addIndividual(individual newIndividual) {
        individuals.add(newIndividual);
    }
}
