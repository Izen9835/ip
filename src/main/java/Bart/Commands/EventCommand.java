package Bart.Commands;

import Bart.Exceptions.InvalidCommandException;
import Bart.ListManager.TaskList;
import Bart.Ui.Ui;

public class EventCommand implements Command {


    private final String description;
    private final String start;
    private final String end;

    public EventCommand(String trimmedInput) throws InvalidCommandException {
        // remove the "event " in front
        // for parsing input
        String input = trimmedInput.substring(6).trim();

        // find indices of the keywords
        int fromIndex = input.indexOf(" /from ");
        int toIndex = input.indexOf(" /to ");

        if (fromIndex == -1) { // keyword is missing
            throw new InvalidCommandException("/from parameter missing!");
        }

        if (toIndex == -1) { // keyword is missing
            throw new InvalidCommandException("/to parameter missing!");
        }

        // parse task description between "event " and "/from"
        description = input.substring(0, fromIndex);

        // parse start time after "/from " and before "/to"
        start = input.substring(fromIndex + " /from ".length(), toIndex);

        // parse end time after "/to "
        end = input.substring(toIndex + " /to ".length());
    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws InvalidCommandException {
        String itemToString = tasks.addEvent(description, start, end);
        ui.printWithDivider("event added." + System.lineSeparator() + "  " + itemToString);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
