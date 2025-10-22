package lld.textEditor;

import java.util.*;

// Command Interface
interface Command {
    void execute();
    void undo();
}

// Text Editor class
class TextEditor {
    private StringBuilder text = new StringBuilder();
    private Deque<Command> undoStack = new ArrayDeque<>();
    private Deque<Command> redoStack = new ArrayDeque<>();

    // Append text
    public void append(String str) {
        executeCommand(new AppendCommand(this, str));
    }

    // Delete last n characters
    public void delete(int count) {
        executeCommand(new DeleteCommand(this, count));
    }

    // Undo last command
    public void undo() {
        if (!undoStack.isEmpty()) {
            Command cmd = undoStack.pop();
            cmd.undo();
            redoStack.push(cmd);
        } else {
            System.out.println("Nothing to undo");
        }
    }

    // Redo last undone command
    public void redo() {
        if (!redoStack.isEmpty()) {
            Command cmd = redoStack.pop();
            cmd.execute();
            undoStack.push(cmd);
        } else {
            System.out.println("Nothing to redo");
        }
    }

    // Internal method to execute command
    private void executeCommand(Command cmd) {
        cmd.execute();
        undoStack.push(cmd);
        redoStack.clear(); // clear redo history after new command
    }

    // Internal methods to manipulate text
    protected void appendText(String str) {
        text.append(str);
    }

    protected void deleteText(int count) {
        if (count > text.length()) count = text.length();
        text.delete(text.length() - count, text.length());
    }

    public String getText() {
        return text.toString();
    }
}

// Append Command
class AppendCommand implements Command {
    private TextEditor editor;
    private String str;

    public AppendCommand(TextEditor editor, String str) {
        this.editor = editor;
        this.str = str;
    }

    @Override
    public void execute() {
        editor.appendText(str);
    }

    @Override
    public void undo() {
        editor.deleteText(str.length());
    }
}

// Delete Command
class DeleteCommand implements Command {
    private TextEditor editor;
    private int count;
    private String deletedText;

    public DeleteCommand(TextEditor editor, int count) {
        this.editor = editor;
        this.count = count;
    }

    @Override
    public void execute() {
        String current = editor.getText();
        int start = Math.max(current.length() - count, 0);
        deletedText = current.substring(start);
        editor.deleteText(count);
    }

    @Override
    public void undo() {
        editor.appendText(deletedText);
    }
}

// Demo
public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.append("Hello");
        System.out.println(editor.getText()); // Hello

        editor.append(" World");
        System.out.println(editor.getText()); // Hello World

        editor.delete(6);
        System.out.println(editor.getText()); // Hello

        editor.undo();
        System.out.println(editor.getText()); // Hello World

        editor.redo();
        System.out.println(editor.getText()); // Hello
    }
}
