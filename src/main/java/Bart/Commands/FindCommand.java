package Bart.Commands;

import Bart.Exceptions.InvalidCommandException;
import Bart.ListManager.ListItem;
import Bart.ListManager.TaskList;
import Bart.Ui.Ui;

import java.util.List;

public class FindCommand implements Command {
    private final String keyword;

    public FindCommand(String trimmedInput) throws InvalidCommandException {
        // Extract the keyword after "find "
        if (trimmedInput.length() <= 5) {
            throw new InvalidCommandException("The find command requires a keyword.");
        }
        this.keyword = trimmedInput.substring(5).trim();
        if (keyword.isEmpty()) {
            throw new InvalidCommandException("The find keyword cannot be empty.");
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        // Call find method in TaskList to get matching tasks
        List<ListItem> results = tasks.find(keyword);

        ui.divider();

        ui.print("Here are the matching tasks in your list:");

        int i = 1;
        for (ListItem item : results) {
            ui.print(i + "." + item.toString());
            i++;
        }

        if (results.isEmpty()) {
            ui.print("No matching tasks found.");
        }

        ui.divider();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
