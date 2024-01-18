package org.example;

import java.awt.*;

public class FormatHandler {
    GUI gui;
    SupportedFonts currentFont;
    SupportedFontSizes currentFontSize;

    public enum SupportedFonts {
        ARIAL           ("Arial"),
        TIMES_NEW_ROMAN ("Times New Roman"),
        COMIC_SANS      ("Comic Sans MS"),
        COURIER_NEW     ("Courier New");

        final String name;
        SupportedFonts(String name) {
            this.name = name;
        }
    }

    public enum SupportedFontSizes {
        _8  (8),
        _12 (12),
        _16 (16),
        _20 (20),
        _24 (24);

        final int size;

        SupportedFontSizes(int size) {
            this.size = size;
        }
    }

    public FormatHandler(GUI gui) {
        this.gui = gui;
        currentFont = SupportedFonts.ARIAL;
        currentFontSize = SupportedFontSizes._12;
    }

    public void toggleWordWrap() {
        boolean isLineWrapOn = gui.textArea.getLineWrap();
        gui.textArea.setLineWrap(!isLineWrapOn);
        gui.formatWordWrap.setText(String.format("Word Wrap: %s", !isLineWrapOn ? "On" : "Off"));
    }

    public void setFont(SupportedFonts supportedFont) {
        this.currentFont = supportedFont;
        Font font = new Font(currentFont.name, Font.PLAIN, currentFontSize.size);
        gui.textArea.setFont(font);
    }

    public void setFontSize(SupportedFontSizes supportedFontSize) {
        this.currentFontSize = supportedFontSize;
        Font font = new Font(currentFont.name, Font.PLAIN, currentFontSize.size);
        gui.textArea.setFont(font);
    }
}
