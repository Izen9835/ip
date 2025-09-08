package Bart.Utils;

public class BartUtils {

    public static void print(String msg) {
        System.out.println("    " + msg);
    }

    public static void divider() {
        System.out.println("    ____________________________________________________________");
    }

    public static void printWithDivider(String text) {
        divider();
        print(text);
        divider();
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
}
