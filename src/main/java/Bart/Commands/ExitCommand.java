package Bart.Commands;

import Bart.Exceptions.InvalidCommandException;
import Bart.ListManager.TaskList;
import Bart.Ui.Ui;

public class ExitCommand implements Command {

    @Override
    public void execute(TaskList tasks, Ui ui) throws InvalidCommandException {
        ui.printWithDivider("Bye. Hope to see you again soon!");

    }

    @Override
    public boolean isExit() {
        return true;
    }
}
