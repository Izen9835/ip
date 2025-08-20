public class Bart {

    public static void print(String msg) {
        System.out.println(msg);
    }

    public static void divider() {
        System.out.println("____________________________________________________________");
    }

    public static void main(String[] args) {
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
        print("Bye. Hope to see you again soon!");
        divider();
    }
}


