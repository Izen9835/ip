package Bart.Commands;

import Bart.Exceptions.InvalidCommandException;
import Bart.ListManager.TaskList;
import Bart.Ui.Ui;

public class DeadlineCommand implements Command {
    private final String description;
    private final String by;

    public DeadlineCommand(String trimmedInput) throws InvalidCommandException {
        // remove "deadline "
        // for parsing
        String input = trimmedInput.substring(9).trim();

        // find index of "/by"
        int byIndex = input.indexOf(" /by ");

        if (byIndex == -1) {
            throw new InvalidCommandException("/by not specified!");
        }

        description = input.substring(0, byIndex);
        by = input.substring(byIndex + " /by ".length());

    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws InvalidCommandException {
        String itemToString = tasks.addDeadline(description, by);
        ui.printWithDivider("deadline added." + System.lineSeparator() + "    " + itemToString);

    }

    @Override
    public boolean isExit() {
        return false;
    }
}
