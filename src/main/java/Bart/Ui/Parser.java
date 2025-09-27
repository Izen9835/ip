package Bart.Ui;

import Bart.Commands.*;
import Bart.Exceptions.InvalidCommandException;

public class Parser {

    public static Command parse(String input) throws InvalidCommandException {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidCommandException("Input cannot be empty");
        }

        String trimmedInput = input.trim();
        String commandWord = trimmedInput.split("\\s+", 2)[0]; // first word of input

        switch (commandWord) {
            case "bye":
                return new ExitCommand();

            case "list":
                return new ListCommand();

            case "mark":
                return new MarkCommand(trimmedInput);

            case "unmark":
                return new UnmarkCommand(trimmedInput);

            case "todo":
                return new TodoCommand(trimmedInput);

            case "deadline":
                return new DeadlineCommand(trimmedInput);

            case "event":
                return new EventCommand(trimmedInput);

            case "delete":
                return new DeleteCommand(trimmedInput);

            case "find":
                return new FindCommand(trimmedInput);

            default:
                throw new InvalidCommandException("input keyword not found");
        }
    }
}
