package Bart.Commands;

import Bart.Exceptions.InvalidCommandException;
import Bart.ListManager.TaskList;
import Bart.Ui.Ui;

public class TodoCommand implements Command {
    private final String name;

    public TodoCommand(String trimmedInput) throws InvalidCommandException {
        try {
            name = trimmedInput.substring(5).trim();
        }
        catch (StringIndexOutOfBoundsException e) {
            throw new InvalidCommandException("no todo item was specified");
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws InvalidCommandException {
        if (name.isBlank()) {
            throw new InvalidCommandException("no todo item was specified.");
        }

        String itemToString = tasks.addTodo(name);
        ui.printWithDivider("todo added." + System.lineSeparator() + "  " + itemToString);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
