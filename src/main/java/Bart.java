import java.util.Scanner;
import ListManager.ListManager;
import Utils.BartUtils;

/**
 * The main entry point for the Bart chatbot application.
 * Handles user input, command parsing, and interaction with the ListManager.
 */
public class Bart {

    /**
     * Starts the Bart chatbot application.
     * Initializes the ListManager and processes user commands in a loop until "bye" is entered.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListManager _listManager = new ListManager();

        BartUtils.print("Hello from");
        BartUtils.printASCIIName();
        BartUtils.printWithDivider("Hello! I'm Bartholomew, but you can call me Bart" + System.lineSeparator() + "      What can I do for you?");

        _listManager.printItems(); 


        boolean isAnswering = true;

        while (isAnswering) {

            // read user input
            if (!in.hasNextLine()) {
                break; // end input gracefully if no more lines
            }
            String userInput = in.nextLine();

            if (userInput.equals("bye")) {
                isAnswering = false;
                break;

            } else if (userInput.equals("list")) {
                BartUtils.divider();
                _listManager.printItems();
                BartUtils.divider();
                
            } else if (userInput.startsWith("mark ")) {
                handleMark(userInput, _listManager);

            } else if (userInput.startsWith("unmark ")) {
                handleUnmark(userInput, _listManager);

            } else if (userInput.startsWith("todo ")) {
                handleTodo(userInput, _listManager);

            } else if (userInput.startsWith("deadline ")) {
                handleDeadline(userInput, _listManager);

            } else if (userInput.startsWith("event ")) {
                handleEvent(userInput, _listManager);

            } else { 
                // key word unrecognised.
                BartUtils.printWithDivider("input keyword not found");
            }
        }
        BartUtils.printWithDivider("Bye. Hope to see you again soon!");

    }

    /**
     * Handles the "mark" command to mark a task as done.
     *
     * @param userInput The full user input string.
     * @param _listManager The ListManager instance to update.
     */
    private static void handleMark(String userInput, ListManager _listManager) {
        try {
            // Extract the number after "mark "
            String numberStr = userInput.substring(5).trim();
            int index = Integer.parseInt(numberStr);
            _listManager.markItem(index-1); // convert to 0 indexing
            BartUtils.printWithDivider("Marked item " + index);

        } catch (NumberFormatException e) {
            BartUtils.printWithDivider("Invalid number format after 'mark'. Please enter a valid index.");

        }
    }

    /**
     * Handles the "unmark" command to mark a task as not done.
     *
     * @param userInput The full user input string.
     * @param _listManager The ListManager instance to update.
     */
    private static void handleUnmark(String userInput, ListManager _listManager) {
        try {
            // Extract the number after "mark "
            String numberStr = userInput.substring(7).trim();
            int index = Integer.parseInt(numberStr);
            _listManager.unmarkItem(index-1); // convert to 0 indexing
            BartUtils.printWithDivider("Unmarked item " + index);
            
        } catch (NumberFormatException e) {
            BartUtils.printWithDivider("Invalid number format after 'mark'. Please enter a valid index.");

        }
    }

    /**
     * Handles the "todo" command to add a new todo task.
     *
     * @param userInput The full user input string.
     * @param _listManager The ListManager instance to update.
     */
    private static void handleTodo(String userInput, ListManager _listManager) {
        String name = userInput.substring(5).trim();

        if (name.isBlank()) {
            BartUtils.printWithDivider("no todo item was specified.");

        } else {
            String itemToString = _listManager.addTodo(name);
            BartUtils.printWithDivider("todo added." + System.lineSeparator() + "  " + itemToString);

        }
    }

    /**
     * Handles the "deadline" command to add a new deadline task.
     *
     * @param userInput The full user input string.
     * @param _listManager The ListManager instance to update.
     */
    private static void handleDeadline(String userInput, ListManager _listManager) {
        // remove "deadline "
        // for parsing
        String input = userInput.substring(9).trim();

        // find index of "/by"
        int byIndex = input.indexOf(" /by ");

        if (byIndex == -1) { // keyword is not found
            BartUtils.printWithDivider("input format incorrect");


        } else {
            String description = input.substring(0, byIndex);

            String by = input.substring(byIndex + " /by ".length());

            // add to list
            String itemToString = _listManager.addDeadline(description, by);
            BartUtils.printWithDivider("deadline added." + System.lineSeparator() + "    " + itemToString);

        }
    }

    /**
     * Handles the "event" command to add a new event task.
     *
     * @param userInput The full user input string.
     * @param _listManager The ListManager instance to update.
     */
    private static void handleEvent(String userInput, ListManager _listManager) {
        // remove the "event " in front
        // for parsing input
        String input = userInput.substring(6).trim();

        // find indices of the keywords
        int fromIndex = input.indexOf(" /from ");
        int toIndex = input.indexOf(" /to ");

        if (fromIndex == -1 || toIndex == -1) { // keyword is missing
            BartUtils.printWithDivider("input format incorrect");

        } else {
            // parse task description between "event " and "/from"
            String description = input.substring(0, fromIndex);

            // parse start time after "/from " and before "/to"
            String start = input.substring(fromIndex + " /from ".length(), toIndex);

            // parse end time after "/to "
            String end = input.substring(toIndex + " /to ".length());

            // add to list
            String itemToString = _listManager.addEvent(description, start, end);
            BartUtils.printWithDivider("event added." + System.lineSeparator() + "  " + itemToString);

        }
    }
}


