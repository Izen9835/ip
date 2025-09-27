package Bart.ListManager;

import Bart.Exceptions.BartException;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages a list of tasks, including todos, deadlines, and events.
 * Provides methods to add, mark, unmark, and print tasks.
 */
public class TaskList {
    private List<ListItem> items;

    public TaskList() {
        this.items = new ArrayList<>();
    }

    public List<ListItem> getItems() {
        return items;
    }

    public void updateItems(List<ListItem> items) {
        this.items = items;
    }

    /**
     * Adds a new Todo item to the list.
     *
     * @param name The name or description of the Todo.
     * @return toString() of the added Todo
     */
    public String addTodo(String name) {
        ListItem todo = new Todo(name);
        items.add(todo);

        return todo.toString();
    }

    /**
     * Adds a new Deadline item to the list.
     *
     * @param name The name or description of the Deadline.
     * @param by   The due date of the Deadline.
     * @return toString() of the added Deadline.
     */
    public String addDeadline(String name, String by) {
        ListItem deadline = new Deadline(name, by);
        items.add(deadline);

        return deadline.toString();
    }

    /**
     * Adds a new Event item to the list.
     *
     * @param name  The name or description of the Event.
     * @param start The start time of the Event.
     * @param end   The end time of the Event.
     * @return toString() of the added Event
     */
    public String addEvent(String name, String start, String end) {
        ListItem event = new Event(name, start, end);
        items.add(event);

        return event.toString();
    }

    public String deleteItem(int index) {
        ListItem item = items.get(index);
        items.remove(index);

        return item.toString();
    }

    public void markItem(int index) {
        items.get(index).markThis();
    }

    public void unmarkItem(int index) {
        items.get(index).unmarkThis();
    }

    /**
     * Prints all items in the list with their indices and details.
     */
    public void printItems() {
        for (int i = 0; i < items.toArray().length; i++) {
            // show index
            int index = i + 1;
            System.out.print("       " + index + ". ");

            // toString includes e.g. [D][ ] do this task (by: 8 Jan 2028)
            System.out.println(items.get(i).toString());
        }
    }
}
