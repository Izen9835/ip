package Bart.Commands;

import Bart.Exceptions.BartException;
import Bart.Exceptions.InvalidCommandException;
import Bart.ListManager.TaskList;
import Bart.Ui.Ui;

public class DeleteCommand implements Command {
    private final int index;

    public DeleteCommand(String trimmedInput) throws InvalidCommandException {
        try {
            // Extract the number after "delete "
            String numberStr = trimmedInput.substring(7).trim();
            index = Integer.parseInt(numberStr);

        } catch (NumberFormatException e) {
            throw new InvalidCommandException("Invalid number format after 'mark'. Please enter a valid index.");

        }

    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        String itemText = tasks.deleteItem(index - 1); // convert to 0 indexing
        ui.printWithDivider("Task Removed: " + itemText);

    }

    @Override
    public boolean isExit() {
        return false;
    }
}
