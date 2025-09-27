package Bart.Commands;

import Bart.ListManager.TaskList;
import Bart.Ui.Ui;

public class ListCommand implements Command {
    @Override
    public void execute(TaskList tasks, Ui ui) {
        ui.divider();
        tasks.printItems();
        ui.divider();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
