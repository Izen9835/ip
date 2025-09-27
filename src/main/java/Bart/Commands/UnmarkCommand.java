package Bart.Commands;

import Bart.Exceptions.InvalidCommandException;
import Bart.ListManager.TaskList;
import Bart.Ui.Ui;

public class UnmarkCommand implements Command {
    private final int index;

    public UnmarkCommand(String trimmedInput) throws InvalidCommandException {
        try {
            String numberStr = trimmedInput.substring(7).trim();
            index = Integer.parseInt(numberStr);

        } catch (NumberFormatException e) {
            throw new InvalidCommandException("Invalid number format after 'mark'. Please enter a valid index.");

        } catch (StringIndexOutOfBoundsException e) {
            throw new InvalidCommandException("No index provided after 'mark'.");
        }

    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        tasks.unmarkItem(index - 1); // convert to 0 indexing
        ui.printWithDivider("Unmarked item " + index);

    }

    @Override
    public boolean isExit() {
        return false;
    }
}
