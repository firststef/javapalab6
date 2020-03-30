package lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrownFiguresPanel extends JPanel {
    final MainFrame frame;
    GridBagConstraints gbc;
    JPanel panel2;
    JScrollPane scrollPane;
    public DrownFiguresPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        gbc = new GridBagConstraints();
        this.setLayout(new BorderLayout());
        panel2=new JPanel();
        this.panel2.setLayout(new GridBagLayout());
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        scrollPane = new JScrollPane(panel2,   ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.add(scrollPane);
    }

    public void addFigure(DrownShape x) {
        JButton button = new JButton(x.toString());
        panel2.add(button, gbc);


        frame.revalidate();
        frame.repaint();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.canvas.shapes.remove(x);
                panel2.remove(button);
                frame.canvas.drawAll();
                frame.revalidate();
                frame.repaint();
            }
        });
    }

}
