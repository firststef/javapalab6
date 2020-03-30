package lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrownFiguresPanel extends JPanel {
    final MainFrame frame;
    GridBagConstraints gbc;

    public DrownFiguresPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        gbc = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        gbc.gridwidth = GridBagConstraints.REMAINDER;
    }

    public void addFigure(DrownShape x) {
        JButton button = new JButton(x.toString());
        add(button, gbc);
        frame.revalidate();
        frame.repaint();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.canvas.shapes.remove(x);
                remove(button);
                frame.canvas.drawAll();
                frame.revalidate();
                frame.repaint();
            }
        });
    }

}
