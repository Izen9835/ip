import java.util.ArrayList;
import java.util.List;

class ListItem {
    private boolean isMarked = false;
    private String name;

    public ListItem(String name){
        this.isMarked = false;
        this.name = name;
    }

    public boolean getIsMarked() {
        return this.isMarked;
    }

    public void markThis() {
        this.isMarked = true;
    }

    public void unmarkThis() {
        this.isMarked = false;
    }

    public String getName() {
        return this.name;
    }
}

public class ListManager {
    private List<ListItem> items;

    public ListManager() {
        this.items = new ArrayList<>();
    }

    public void addItem(String name) {
        items.add(new ListItem(name));
    }

    public void markItem(int index) {
        items.get(index).markThis();
    }

    public void unmarkItem(int index) {
        items.get(index).unmarkThis();
    }

    public void printItems() {
        for (int i = 0; i < items.toArray().length; i++) {
            System.out.print("  ");
            System.out.print(i+1);
            System.out.print(". ");

            if (items.get(i).getIsMarked()) System.out.print("[X] ");
            else System.out.print("[ ] ");

            System.out.println(items.get(i).getName());
        }
    }
}
