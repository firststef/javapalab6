package lab6;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import static javax.imageio.ImageIO.read;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame){
        this.frame = frame;
        init();
    }
    private void init(){
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        exitBtn.addActionListener(this::exit);
        resetBtn.addActionListener(this::reset);
    }
    private void save(ActionEvent e){
        try {
            ImageIO.write(frame.canvas.image, "PNG", new FileOutputStream("test.png"));
        }
        catch (IOException ex){
            System.err.println(ex);
        }
    }
    private void load(ActionEvent e){
        try {
            this.frame.canvas.image = ImageIO.read(new File("test.png"));
            frame.canvas.graphics = frame.canvas.image.createGraphics();
            frame.revalidate();
            frame.repaint();
        }
        catch (IOException ex){
            System.err.println(ex);
        }
    }
    private void reset(ActionEvent e){
        this.frame.canvas.createOffScreenImage();
        frame.revalidate();
        frame.repaint();
    }
    private void exit(ActionEvent e){
        System.exit(0);
    }
}
