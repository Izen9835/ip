
# Bart Chatbot User Guide

Welcome to **Bart**, your friendly command-line task manager chatbot! Bart helps you keep track of your todos, deadlines, and events, all from a simple text interface.

---

## Getting Started

Simply run the program. Bart will greet you and wait for your commands. Type your commands and press Enter to interact.

---

## Features

### 1. Add a Todo
Add a simple task to your list.

**Usage:**
```
todo <description>
```
**Example:**
```
todo read book
```

---

### 2. Add a Deadline
Add a task with a due date.

**Usage:**
```
deadline <description> /by <due date>
```
**Example:**
```
deadline submit report /by 2025-10-01
```

---

### 3. Add an Event
Add a task with a start and end time.

**Usage:**
```
event <description> /from <start> /to <end>
```
**Example:**
```
event project meeting /from 2025-10-01 14:00 /to 2025-10-01 16:00
```

---

### 4. List All Tasks
See all your current tasks.

**Usage:**
```
list
```

---

### 5. Mark a Task as Done
Mark a task as completed.

**Usage:**
```
mark <task number>
```
**Example:**
```
mark 2
```

---

### 6. Unmark a Task
Mark a task as not done.

**Usage:**
```
unmark <task number>
```
**Example:**
```
unmark 2
```

---

### 7. Delete a Task
Remove a task from your list.

**Usage:**
```
delete <task number>
```
**Example:**
```
delete 3
```

---

### 8. Find Tasks by Keyword
Search for tasks containing a specific word.

**Usage:**
```
find <keyword>
```
**Example:**
```
find report
```

---

### 9. Exit Bart
Say goodbye to Bart and close the program.

**Usage:**
```
bye
```

---

## Notes
- Dates and times can be entered in any format you prefer, but be consistent for your own reference.
- Task numbers refer to the number shown in the `list` command.
- Your tasks are automatically saved between sessions.

---

Enjoy using **Bart** to organize your tasks!