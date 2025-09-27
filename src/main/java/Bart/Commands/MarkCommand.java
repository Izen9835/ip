package Bart.Commands;

import Bart.Exceptions.InvalidCommandException;
import Bart.ListManager.TaskList;
import Bart.Ui.Ui;

public class MarkCommand implements Command {
    private final int index;

    public MarkCommand(String trimmedInput) throws InvalidCommandException{
        try {
            // Extract the number after "mark "
            String numberStr = trimmedInput.substring(5).trim();
            this.index = Integer.parseInt(numberStr) - 1;  // zero-based index
            if (index < 0) {
                throw new InvalidCommandException("Index must be positive.");
            }
        } catch (NumberFormatException e) {
            throw new InvalidCommandException("Invalid number format after 'mark'. Please enter a valid index.");
        } catch (StringIndexOutOfBoundsException e) {
            throw new InvalidCommandException("No index provided after 'mark'.");
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        tasks.markItem(index - 1); // convert to 0 indexing
        ui.printWithDivider("Marked item " + index);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
