import java.util.ArrayList;
import java.util.List;

public class ListManager {
    private List<ListItem> items;

    public ListManager() {
        this.items = new ArrayList<>();
    }

    public String addTodo(String name) {
        ListItem todo = new Todo(name);
        items.add(todo);
        return todo.toString();
    }

    public String addDeadline(String name, String by) {
        ListItem deadline = new Deadline(name, by);
        items.add(deadline);
        return deadline.toString();
    }

    public String addEvent(String name, String start, String end) {
        ListItem event = new Event(name, start, end);
        items.add(event);
        return event.toString();
    }

    public void markItem(int index) {
        items.get(index).markThis();
    }

    public void unmarkItem(int index) {
        items.get(index).unmarkThis();
    }

    public void printItems() {
        for (int i = 0; i < items.toArray().length; i++) {
            System.out.print("       ");
            System.out.print(i+1);
            System.out.print(". ");

            System.out.println(items.get(i).toString());
        }
    }
}
