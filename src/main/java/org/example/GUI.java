package org.example;

import javax.swing.*;

public class GUI {

    // Note that the layout of this class allows us to compose the GUI using the defined units

    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    protected JFrame window;
    protected JTextArea textArea;
    private JMenu menuFile, menuEdit, menuFormat;
    private JMenu formatFont, formatFontSize;

    FileHandler file = new FileHandler(this);

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        createWindow();
        createTextArea();

        // GUI Controls
        createMenuBar();
        createFileMenu();
        createEditMenu();
        createFormatMenu();

        window.setVisible(true);
    }

    private void createWindow() {
        window = new JFrame("Jotepad");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        // You need this to make the window close when the X button is clicked
        // I thought it was weird why this wasn't the default behaviour, but it's not weird at all - a JFrame doesn't
        // necessarily represent the highest level wrapper of an app. In fact, there is only one case in an application
        // where it should be set to EXIT_ON_CLOSE
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // In the future I could try to implement my own text area - this is a good first pass to make sure the application
    // works
    private void createTextArea() {
        textArea = new JTextArea();
        // Scroll Pane acts as a wrapper around components (usually those that are too large to be rendered in the
        // window
        JScrollPane scrollPane = new JScrollPane(
                textArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuEdit = new JMenu("Edit");
        menuFormat = new JMenu("Format");

        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuFormat);
    }

    private void createFileMenu() {
        JMenuItem fileNew = new JMenuItem("New");
        fileNew.addActionListener(e -> file.newFile());

        JMenuItem fileOpen = new JMenuItem("Open");
        fileOpen.addActionListener(e -> file.openFile());

        JMenuItem fileSave = new JMenuItem("Save");
        fileSave.addActionListener(e -> file.save());

        JMenuItem fileSaveAs = new JMenuItem("Save As");
        fileSaveAs.addActionListener(e -> file.saveAs());

        JMenuItem fileExit = new JMenuItem("Exit");
        fileExit.addActionListener(e -> System.exit(130));

        menuFile.add(fileNew);
        menuFile.add(fileOpen);
        menuFile.add(fileSave);
        menuFile.add(fileSaveAs);
        menuFile.add(fileExit);
    }

    private void createEditMenu() {
        JMenuItem editUndo = new JMenuItem("Undo");
        editUndo.addActionListener(e -> {});

        JMenuItem editRedo = new JMenuItem("Redo");
        editUndo.addActionListener(e -> {});

        menuEdit.add(editUndo);
        menuEdit.add(editRedo);
    }

    private void createFormatMenu() {
        JMenuItem formatWordWrap = new JMenuItem("Word Wrap");
        formatWordWrap.addActionListener(e -> {});

        menuFormat.add(formatWordWrap);
    }
}
