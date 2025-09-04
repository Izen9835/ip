package ListManager;

public class Deadline extends ListItem{
    private String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        String isDoneText = this.getIsMarked() ? "[X]" : "[ ]";
        
        return "[D]" + isDoneText + " " + this.getDescription() + " (by: " + this.by + ")";
    }
}
