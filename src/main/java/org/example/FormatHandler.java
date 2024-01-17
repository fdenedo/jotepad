package org.example;

public class FormatHandler {
    GUI gui;

    public FormatHandler(GUI gui) {
        this.gui = gui;
    }

    public void toggleWordWrap() {
        boolean isLineWrapOn = gui.textArea.getLineWrap();
        gui.textArea.setLineWrap(!isLineWrapOn);
        gui.formatWordWrap.setText(String.format("Word Wrap: %s", !isLineWrapOn ? "On" : "Off"));
    }
}
