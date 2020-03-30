package lab6;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.SwingConstants.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init("");
    }

    private void init(String str) {
        configPanel = new ConfigPanel(this, str);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(canvas, BorderLayout.CENTER);
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        pack();
    }

    private void change(ActionEvent actionEvent) {
        System.out.println("aici");
        String str=this.configPanel.shapeCombo.getSelectedItem().toString();
        this.configPanel.repaintConfig(str);
    }


}