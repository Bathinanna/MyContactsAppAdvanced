package com.mycontactsapp.command;

import java.util.Stack;

public class CommandManager {

    private Stack<EditContactCommand> undoStack = new Stack<>();
    private Stack<EditContactCommand> redoStack = new Stack<>();


    public void execute(EditContactCommand command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }


    public void undo() {
        if(!undoStack.isEmpty()) {
            EditContactCommand cmd = undoStack.pop();
            cmd.undo();
            redoStack.push(cmd);
        }
    }


    public void redo() {
        if(!redoStack.isEmpty()) {
            EditContactCommand cmd = redoStack.pop();
            cmd.execute();
            undoStack.push(cmd);
        }
    }
}