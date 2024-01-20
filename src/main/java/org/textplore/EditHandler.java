package org.textplore;

public class EditHandler {

    GUI gui;

    public EditHandler(GUI gui) {
        this.gui = gui;
    }

    public void undo() {
        gui.um.undo();
    }

    public void redo() {
        gui.um.redo();
    }
}
