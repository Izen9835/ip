import java.util.Scanner;

public class Bart {

    public static void print(String msg) {
        System.out.println("    " + msg);
    }

    public static void divider() {
        System.out.println("    ____________________________________________________________");
    }

    public static void printASCIIName() {
        String[] logo = {
            " ____             _   _           _                               ",
            "| __ )  __ _ _ __| |_| |__   ___ | | ___  _ __ ___   _____      __",
            "|  _ \\ / _` | '__| __| '_ \\ / _ \\| |/ _ \\| '_ ` _ \\ / _ \\ \\ /\\ / /",
            "| |_) | (_| | |  | |_| | | | (_) | | (_) | | | | | |  __/\\ V  V / ",
            "|____/ \\__,_|_|   \\__|_| |_|\\___/|_|\\___/|_| |_| |_|\\___| \\_/\\_/  "};

        for (int i = 0; i < logo.length; i++) {
            System.out.println(logo[i]);
        }
    }

    public static String getUserInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static void main(String[] args) {
        ListManager _listManager = new ListManager();

        print("Hello from\n");
        printASCIIName();
        divider();
        print("Hello! I'm Bartholomew, but you can call me Bart");
        print("What can I do for you?");
        divider();

        _listManager.printItems();


        boolean isAnswering = true;

        while (isAnswering) {
            String userInput = getUserInput();

            switch (userInput) {
            case "bye":
                isAnswering = false;
                break;
            case "list":
                divider();
                _listManager.printItems();
                divider();
                break;
            default:
                if (userInput.startsWith("mark ")) {
                    try {
                        // Extract the number after "mark "
                        String numberStr = userInput.substring(5).trim();
                        int index = Integer.parseInt(numberStr);
                        _listManager.markItem(index-1); // convert to 0 indexing
                        divider();
                        print("Marked item " + index);
                        divider();
                    } catch (NumberFormatException e) {
                        divider();
                        print("Invalid number format after 'mark'. Please enter a valid index.");
                        divider();
                    }
                } else if (userInput.startsWith("unmark ")) {
                    try {
                        // Extract the number after "mark "
                        String numberStr = userInput.substring(7).trim();
                        int index = Integer.parseInt(numberStr);
                        _listManager.unmarkItem(index-1); // convert to 0 indexing
                        divider();
                        print("Unmarked item " + index);
                        divider();
                    } catch (NumberFormatException e) {
                        divider();
                        print("Invalid number format after 'mark'. Please enter a valid index.");
                        divider();
                    }

                } else if (userInput.startsWith("todo ")) {
                    String name = userInput.substring(5).trim();

                    if (name.isBlank()) {
                        divider();
                        print("no todo item was specified.");
                        divider();

                    } else {
                        String itemToString = _listManager.addTodo(name);
                        divider();
                        print("todo added.");
                        print("  " + itemToString);
                        divider();
                    }


                } else if (userInput.startsWith("deadline ")) {
                    // remove "deadline "
                    // for parsing
                    String input = userInput.substring(9).trim();

                    // find index of "/by"
                    int byIndex = input.indexOf(" /by ");

                    if (byIndex == -1) { // keyword is not found
                        divider();
                        print("input format incorrect");
                        divider();

                    } else {
                        String description = input.substring(0, byIndex);

                        String by = input.substring(byIndex + " /by ".length());

                        // add to list
                        String itemToString = _listManager.addDeadline(description, by);
                        divider();
                        print("deadline added.");
                        print("  " + itemToString);
                        divider();
                    }

                } else if (userInput.startsWith("event ")) {
                    // remove the "event " in front
                    // for parsing input
                    String input = userInput.substring(6).trim();

                    // find indices of the keywords
                    int fromIndex = input.indexOf(" /from ");
                    int toIndex = input.indexOf(" /to ");

                    if (fromIndex == -1 || toIndex == -1) { // keyword is missing
                        divider();
                        print("input format incorrect");
                        divider();

                    } else {
                        // parse task description between "event " and "/from"
                        String description = input.substring(0, fromIndex);

                        // parse start time after "/from " and before "/to"
                        String start = input.substring(fromIndex + " /from ".length(), toIndex);

                        // parse end time after "/to "
                        String end = input.substring(toIndex + " /to ".length());

                        // add to list
                        String itemToString = _listManager.addEvent(description, start, end);
                        divider();
                        print("event added.");
                        print("  " + itemToString);
                        divider();
                    }

                } else {
                    divider();
                    print("input keyword not found");
                    divider();
                }
            }
        }

        divider();
        print("Bye. Hope to see you again soon!");
        divider();
    }
}


