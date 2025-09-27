package Bart.Ui;

import java.util.Scanner;

public class Ui {

    private final Scanner in;

    public Ui () {
        in = new Scanner(System.in);
    }

    public void print(String msg) {
        System.out.println("    " + msg);
    }

    public void divider() {
        System.out.println("    ____________________________________________________________");
    }

    public void printWithDivider(String text) {
        divider();
        print(text);
        divider();
    }

    public void printASCIIName() {
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

    public void showWelcome() {
        print("Hello from");
        printASCIIName();
        printWithDivider("Hello! I'm Bartholomew, but you can call me Bart.Bart" + System.lineSeparator() + "      What can I do for you?");
    }

    public String readCommand() {
        if (in.hasNextLine()) {
            return in.nextLine();
        } else {
            return null;
        }
    }

}
