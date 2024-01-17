package org.example;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FileHandler {

    GUI gui;
    String fileName;
    String fileAddress;
    String currentFileName;

    public FileHandler(GUI gui) {
        this.gui = gui;
    }

    public void newFile() {
        gui.textArea.setText("");
        gui.window.setTitle("New File");
    }

    public void openFile() {
        FileDialog fileDialog = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fileDialog.setVisible(true);
        setCurrentFileNameFromFileDialog(fileDialog);
        gui.textArea.setText("");

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
            String line;
            while((line = br.readLine()) != null) {
                gui.textArea.append(line + "\n");
            }
            br.close();
        } catch (Exception e) {
            System.out.println("FILE COULD NOT BE READ");
        }
    }

    public void save() {
        if(fileName == null || fileName.isEmpty()) {
            saveAs();
        } else {
            try(FileWriter fw = new FileWriter(currentFileName)) {
                fw.write(gui.textArea.getText());
            }
            catch (Exception e) {
                System.out.println("SOMETHING IS WRONG");
            }
        }
    }

    public void saveAs() {
        FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);
        setCurrentFileNameFromFileDialog(fd);

        try(FileWriter fw = new FileWriter(currentFileName)) {
            fw.write(gui.textArea.getText());
        }
        catch (Exception e) {
            System.out.println("SOMETHING IS WRONG");
        }
    }

    private void setCurrentFileNameFromFileDialog(FileDialog fileDialog) {
        if(fileDialog.getFile() == null) return;

        fileName = fileDialog.getFile();
        fileAddress = fileDialog.getDirectory();
        currentFileName = fileAddress + fileName;
        gui.window.setTitle(fileName);
    }
}
