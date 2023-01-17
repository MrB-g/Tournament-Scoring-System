import java.util.Scanner;
import java.util.regex.*;
import systempackage.*;

public class app {
    private static int totalEvents = 5;

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
            String eventTitle = "";
            String eventName;
            if (eventId + 1 == 1) {
                eventTitle = (eventId + 1) + "st";
            } else if (eventId + 1 == 2) {
                eventTitle = (eventId + 1) + "nd";
            } else if (eventId + 1 == 3) {
                eventTitle = (eventId + 1) + "rd";
            } else {
                eventTitle = (eventId + 1) + "th";
            }
            do {
                System.out.print("Enter " + eventTitle + " Event Name : ");
                eventName = userInput.nextLine().trim();
                if(checkUserInputString(eventName) == false){
                    System.out.println("Invalid name. Please only type text.");
                }
            } while (checkUserInputString(eventName) == false);
            event newEvent = new event(eventId, eventName);
            events.addNewEvent(newEvent);
        }

        // Allow User to Choose Team or Individual
        String type;
        do {
            System.out.print("Type this system is used for (Team, Individual) : ");
            type = userInput.nextLine().trim();
            if (checkUserInputString(type) == false) {
                System.out.println("Your input is invalid. Please only type text.");
            }
        } while (checkUserInputString(type) == false);
        System.out.println(type.toLowerCase());

        
    }

    // Main Method
    public static void main(String[] args) {
        startTheProgram();
    }
}
