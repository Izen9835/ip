package Bart.IO;

import Bart.Exceptions.BartException;
import Bart.ListManager.Deadline;
import Bart.ListManager.Event;
import Bart.ListManager.ListItem;
import Bart.ListManager.Todo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListSaver {
    public static void saveToFile(List<ListItem> items) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
            for (ListItem item : items) {
                writer.write(item.toString());
                writer.newLine();
            }
        }
    }

    public static List<ListItem> parseFromFile() throws BartException {
        List<ListItem> items = new ArrayList<>();
        String fileName = "data.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() < 7) {
                    throw new BartException("Invalid line format: " + line);
                }
                char type = line.charAt(1); // T, E, or D
                boolean isMarked = line.charAt(4) == 'X';

                switch (type) {
                    case 'T': {
                        // Format: [T][ ] description
                        String description = line.substring(7);
                        Todo todo = new Todo(description);
                        if (isMarked) todo.markThis();
                        items.add(todo);
                        break;
                    }
                    case 'E': {
                        // Format: [E][ ] name (from: start to: end)
                        int startIndex = line.indexOf("] ") + 2;
                        int fromIndex = line.indexOf("(from: ");
                        if (fromIndex == -1) {
                            throw new BartException("Missing (from:) in event line: " + line);
                        }
                        String name = line.substring(startIndex, fromIndex - 1);

                        int toIndex = line.indexOf(" to: ");
                        int endIndex = line.indexOf(")", toIndex);
                        if (toIndex == -1 || endIndex == -1) {
                            throw new BartException("Invalid event time format in line: " + line);
                        }

                        String start = line.substring(fromIndex + 7, toIndex);
                        String end = line.substring(toIndex + 5, endIndex);

                        Event event = new Event(name, start, end);
                        if (isMarked) event.markThis();
                        items.add(event);
                        break;
                    }
                    case 'D': {
                        // Format: [D][ ] name (by: due)
                        int startIndex = line.indexOf("] ") + 2;
                        int byIndex = line.indexOf("(by: ");
                        int endIndex = line.indexOf(")", byIndex);
                        if (byIndex == -1 || endIndex == -1) {
                            throw new BartException("Invalid deadline format in line: " + line);
                        }
                        String name = line.substring(startIndex, byIndex - 1);
                        String by = line.substring(byIndex + 5, endIndex);

                        Deadline deadline = new Deadline(name, by);
                        if (isMarked) deadline.markThis();
                        items.add(deadline);
                        break;
                    }
                    default:
                        throw new BartException("Unknown task type in line: " + line);
                }
            }
        } catch (IOException e) {
            throw new BartException("Error reading file: " + e.getMessage());
        }

        return items;
    }

}
