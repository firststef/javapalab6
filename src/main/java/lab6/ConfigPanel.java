package lab6;
import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sides;
    JSpinner sidesSpinner;
    JLabel shape;
    JComboBox shapeCombo;
    JLabel color;
    JComboBox colorCombo;
    JLabel size;
    JSpinner sizeSpinner;


    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        sides = new JLabel("Number of sides:");
        sidesSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesSpinner.setValue(6);

        shape = new JLabel("Number of shapes:");
        shapeCombo = new JComboBox(new String[]{"Circle", "Square", "Polygon"});

        color = new JLabel("Number of colors:");
        colorCombo = new JComboBox(new String[]{"Random", "Black"});

        size = new JLabel("Size:");
        sizeSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));

        add(sides);
        add(sidesSpinner);
        add(shape);
        add(shapeCombo);
        add(color);
        add(colorCombo);
        add(size);
        add(sizeSpinner);
    }
}