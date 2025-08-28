import java.util.Scanner;

public class Bart {

    public static void print(String msg) {
        System.out.println("    " + msg);
    }

    public static void divider() {
        System.out.println("    ____________________________________________________________");
    }

    public static String getUserInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();

    }

    public static void main(String[] args) {
        ListManager _listManager = new ListManager();

        String logo = " ____             _   _           _                               \n" +
                "| __ )  __ _ _ __| |_| |__   ___ | | ___  _ __ ___   _____      __\n" +
                "|  _ \\ / _` | '__| __| '_ \\ / _ \\| |/ _ \\| '_ ` _ \\ / _ \\ \\ /\\ / /\n" +
                "| |_) | (_| | |  | |_| | | | (_) | | (_) | | | | | |  __/\\ V  V / \n" +
                "|____/ \\__,_|_|   \\__|_| |_|\\___/|_|\\___/|_| |_| |_|\\___| \\_/\\_/  ";
        print("Hello from\n" + logo);
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

                    } else {
                        // adds item to list
                        _listManager.addItem(userInput);
                        divider();
                        print("Added: " + userInput);
                        divider();
                    }
            }
        }

        divider();
        print("Bye. Hope to see you again soon!");
        divider();
    }
}


