import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;
import systempackage.*;

public class app {
    private static int totalEvents = 5;
    private static int totalTeams = 4;
    private static int totalIndividuals = 20;

    public static boolean checkUserInputString(String userInput) {
        Pattern pattern = Pattern.compile("^[A-Za-z, ]++$");
        if (!pattern.matcher(userInput).matches()) {
            return false;
        }
        return true;
    }

    public static void startTheProgram() {
        // Headers
        eventCollector events = new eventCollector();
        Scanner userInput = new Scanner(System.in);

        // Display Welcome Message
        System.out.println(""); 
        System.out.println("Welcome From Tournament Scoring System");

        // Get Event Name Input
        for (int eventId = 0; eventId < totalEvents; eventId++) {
            String eventName;
            do {
                System.out.print("Enter Name for Event " + (eventId + 1) + " : ");
                eventName = userInput.nextLine().trim();
                if(checkUserInputString(eventName) == false){
                    System.out.println("Invalid name. Please only type text.");
                }
            } while (checkUserInputString(eventName) == false);
            event newEvent = new event(eventId, eventName);
            events.addNewEvent(newEvent);
        }

        // Allow User to Choose Team or Individual
        System.out.println("");
        String type;
        do {
            System.out.print("Type this system is used for (Team, Individual) : ");
            type = userInput.nextLine().trim().toLowerCase();
            if (checkUserInputString(type) == false) {
                System.out.println("Your input is invalid. Please only type text.");
            }
        } while (checkUserInputString(type) == false);
        System.out.println("");

        // User Choose Team
        if (type.equals("team")) {
            String finalWinner;

            // Add Name for Each Team
            teamCollector teams = new teamCollector();
            for (int teamId = 0; teamId < totalTeams; teamId++) {
                String teamName;
                do {
                    System.out.print("Enter Name for Team " + (teamId + 1) + " : ");
                    teamName = userInput.nextLine().trim();
                    if (checkUserInputString(teamName) == false) {
                        System.out.println("Invalid name. Please only type text.");
                    }
                } while (checkUserInputString(teamName) == false);
                team newTeam = new team(teamId, teamName);
                teams.addNewTeam(newTeam);
            }

            System.out.println("");
            for (event singleEvent : events.getEvents()) {
                System.out.println("Points for " + singleEvent.getEventName() + " Event");
                ArrayList<Integer> userInputPoints = new ArrayList<Integer>();
                String currentWinner;
                int currentWinnerId;

                // Add Point for Each Team
                for (team singleTeam : teams.getTeams()) {
                    String userInputPoint = "0";
                    int point;
                    while (true) {
                        System.out.print("Add " + singleTeam.getTeamName() + " Team Point : ");
                        try {
                            userInputPoint = userInput.nextLine();
                            if (checkUserInputString(userInputPoint)) {
                                System.out.println("Invalid point. Only add numbers.");
                            } else if(userInputPoint == ""){
                                System.out.println("Empty point can't be added.");
                            } else {
                                point = Integer.parseInt(userInputPoint);
                                if (point < 0) {
                                    System.out.println("Only add positive numbers.");
                                } else {
                                    if (userInputPoints.contains(point)) {
                                        System.out.println("You can't add duplicated points.");
                                    } else {
                                        userInputPoints.add(point);
                                        break;
                                    }
                                }
                            }
                        } catch (Exception error) {
                            System.out.println("Invalid point. Try Again.");
                        }
                    }
                    points newPoint = new points(point, singleEvent.getEventId());
                    singleTeam.addPointsForEachEvent(newPoint);
                }

                // Get Winner of Current Event
                currentWinnerId = teams.getWinnerForSpecificEvent(singleEvent.getEventId());
                currentWinner = teams.getTeamNameById(currentWinnerId);
                winner newWinner = new winner(singleEvent.getEventId(), currentWinnerId);
                events.addWinnerForEachEvent(newWinner);
                System.out.println("Winner for " + singleEvent.getEventName() + " Event is " + currentWinner + ".");
                System.out.println("");
                
                // Deletet Team that want to Leave
                String userChoice;
                while (true) {
                    System.out.print("Is there any team that want to leave? Yes, No | ");
                    userChoice = userInput.nextLine().trim().toLowerCase();
                    if (checkUserInputString(userChoice)) {
                        if (!userChoice.equals("yes") && !userChoice.equals("no")) {
                            System.out.println("Please only type yes or no.");
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("Please input the valid answer.");
                    }
                }

                if (userChoice.equals("yes")) {
                    String deleteTeamName;
                    while (true) {
                        System.out.print("Type Team Name : ");
                        deleteTeamName = userInput.nextLine().trim().toLowerCase();
                        if(teams.deleteTeam(deleteTeamName) == false){
                            System.out.println("Your input team is not existed.");
                        } else {
                            System.out.println("Successfully Deleted!");
                            System.out.println("");
                            break;
                        }
                    }
                } else if (userChoice.equals("no")) {
                    System.out.println("");
                }
            }

            // Get Winner for All Events
            finalWinner = teams.getWinnerForAllEvents();
            events.addWinnerForAllEvent(finalWinner);
            System.out.println("The Final Winner is " + finalWinner + " Team.");
            System.out.println("");
        }
        
        // User Choose Individual
        else if (type.equals("individual")) {
            String finalWinner;

            // Add Name for Each Individual
            individualCollector individuals = new individualCollector();
            for (int individualId = 0; individualId < totalIndividuals; individualId++) {
                String individualName;
                do {
                    System.out.print("Enter Name for Individual " + (individualId + 1) + " : ");
                    individualName = userInput.nextLine().trim();
                    if (checkUserInputString(individualName) == false) {
                        System.out.println("Invalid name. Please only type text.");
                    }
                } while (checkUserInputString(individualName) == false);
                individual newIndividual = new individual(individualId, individualName);
                individuals.addNewIndividual(newIndividual);
            }

            System.out.println("");
            for (event singleEvent : events.getEvents()) {
                System.out.println("Points for " + singleEvent.getEventName() + " Event");
                ArrayList<Integer> userInputPoints = new ArrayList<Integer>();
                String currentWinner;
                int currentWinnerId;

                // Add Point for Each Individual
                for (individual singleIndividual : individuals.getIndividuals()) {
                    String userInputPoint = "0";
                    int point;
                    while (true) {
                        System.out.print("Add " + singleIndividual.getIndividualName() + " Point : ");
                        try {
                            userInputPoint = userInput.nextLine();
                            if (checkUserInputString(userInputPoint)) {
                                System.out.println("Invalid point. Only add numbers.");
                            } else if (userInputPoint == "") {
                                System.out.println("Empty point can't be added.");
                            } else {
                                point = Integer.parseInt(userInputPoint);
                                if (point < 0) {
                                    System.out.println("Only add positive numbers.");
                                } else {
                                    if (userInputPoints.contains(point)) {
                                        System.out.println("You can't add duplicated points.");
                                    } else {
                                        userInputPoints.add(point);
                                        break;
                                    }
                                }
                            }
                        } catch (Exception error) {
                            System.out.println("Invalid point. Try again.");
                        }
                    }
                    points newPoint = new points(point, singleEvent.getEventId());
                    singleIndividual.addPointsForEachEvent(newPoint);
                }

                // Get Winner of Current Event
                currentWinnerId = individuals.getWinnerForSpecificEvent(singleEvent.getEventId());
                currentWinner = individuals.getIndividualNameById(currentWinnerId);
                winner newWinner = new winner(singleEvent.getEventId(), currentWinnerId);

                events.addWinnerForEachEvent(newWinner);
                System.out.println("Winner for " + singleEvent.getEventName() + " Event is " + currentWinner + ".");
                System.out.println("");
                
                // Deletet Team that want to Leave
                String userChoice;
                while (true) {
                    System.out.print("Is there any individual that want to leave? Yes, No | ");
                    userChoice = userInput.nextLine().trim().toLowerCase();
                    if (checkUserInputString(userChoice)) {
                        if (!userChoice.equals("yes") && !userChoice.equals("no")) {
                            System.out.println("Please only type yes or no.");
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("Please input the valid answer.");
                    }
                }

                if (userChoice.equals("yes")) {
                    String deleteIndividualName;
                    while (true) {
                        System.out.print("Type Individual Name : ");
                        deleteIndividualName = userInput.nextLine().trim().toLowerCase();
                        if(individuals.deleteIndividual(deleteIndividualName) == false){
                            System.out.println("Your input individual is not existed.");
                        } else {
                            System.out.println("Successfully Deleted!");
                            System.out.println("");
                            break;
                        }
                    }
                } else if (userChoice.equals("no")) {
                    System.out.println("");
                }
            }

            // Get Winner for All Events
            finalWinner = individuals.getWinnerForAllEvents();
            events.addWinnerForAllEvent(finalWinner);
            System.out.println("The Final Winner is " + finalWinner + " .");
            System.out.println("");
        }
        
        // Restart or Not
        String userAnswer;
        while (true) {
            System.out.print("Want to restart the process or not | Yes, No : ");
            userAnswer = userInput.nextLine().trim().toLowerCase();
            if (checkUserInputString(userAnswer)) {
                if (!userAnswer.equals("yes") && !userAnswer.equals("no")) {
                    System.out.println("Please only type yes or no.");
                } else {
                    break;
                }
            } else {
                System.out.println("Please input the valid answer.");
            }
        }

        if (userAnswer.equals("yes")) {
            startTheProgram();
        } else if (userAnswer.equals("no")) {
            System.out.println("Hope to see you again.");
            System.out.println("");
            userInput.close();
            System.exit(0);
        }
    }

    // Main Method
    public static void main(String[] args) {
        startTheProgram();
    }
}
