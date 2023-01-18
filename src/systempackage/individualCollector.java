package systempackage;

import java.util.ArrayList;

public class individualCollector {
    private ArrayList<individual> individuals = new ArrayList<individual>();

    // Additional Methods
    public int getTotalIndividuals() {
        return individuals.size();
    }

    public boolean deleteIndividual(String deleteIndividualName) {
        boolean foundIndex = false;
        int deleteIndex = 0;
        for (int index = 0; index < this.getIndividuals().size(); index++) {
            if (this.getIndividuals().get(index).getIndividualName().toLowerCase().equals(deleteIndividualName)) {
                deleteIndex = index;
                foundIndex = true;
            }
        }
        if (foundIndex) {
            this.getIndividuals().remove(deleteIndex);
            foundIndex = true;
        }
        return foundIndex;
    }
    
    public int getWinnerForSpecificEvent(int eventId) {
        int winningPoint = 0;
        int winnerId = 0;
        for (individual eachIndividual : individuals) {
            for (points eachIndividualPoints : eachIndividual.getPointsForEachEvent()) {
                if (eventId == eachIndividualPoints.getEventId()) {
                    if (winningPoint <= eachIndividualPoints.getPoints()) {
                        winningPoint = eachIndividualPoints.getPoints();
                        winnerId = eachIndividual.getIndividualId();
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
        for (individual eachIndividual : individuals) {
            if (winningPoint < eachIndividual.getTotalPoints()) {
                winningPoint = eachIndividual.getTotalPoints();
                finalWinner = eachIndividual.getIndividualName();
            }
        }
        return finalWinner;
    }

    public String getIndividualNameById(int individualId) {
        String individualName = "";
        for (individual eachIndividual : individuals) {
            if (eachIndividual.getIndividualId() == individualId) {
                individualName = eachIndividual.getIndividualName();
                break;
            }
        }
        return individualName;
    }
    
    // Getter
    public ArrayList<individual> getIndividuals() {
        return individuals;
    }

    // Setter
    public void addNewIndividual(individual newIndividual) {
        individuals.add(newIndividual);
    }
}
