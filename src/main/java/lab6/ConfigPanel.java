package lab6;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JLabel sizeLabel;
    JSpinner sizeField;
    JSpinner sidesField;
    JComboBox colorCombo;
    JLabel sidesLabel;
    JLabel colorLabel;
    JLabel shapeLabel;
    JComboBox shapeCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init("Random");
    }
    public ConfigPanel(MainFrame frame, String string) {
        this.frame = frame;
        init("Random");
    }
    private void init(String str) {
        removeObj();
        addSize();
        addSides();
        addColor();
        addShape(str);
        this.frame.revalidate();
        this.frame.repaint();
    }
    private void circleConfigPanel(){
        removeObj();
        addSize();
        addColor();
        addShape("Circle");
        this.frame.revalidate();
        this.frame.repaint();
    }
    private void starConfigPanel(){
        removeObj();
        addSize();
        addColor();
        addShape("Star");
        this.frame.revalidate();
        this.frame.repaint();
    }
    private void addShape(String str){
        shapeLabel = new JLabel("Choose shape:");
        shapeCombo= new JComboBox(new String[]{"Random", "Circle", "Polygon", "Star"});
        shapeCombo.setSelectedItem(str);
        add(shapeLabel);
        add(shapeCombo);
        shapeCombo.addActionListener(this::change);
    }

    private void addColor(){
        colorLabel=new JLabel("Choose color:");
        colorCombo=new JComboBox(new String[]{"Random", "Black","Red","Blue","Yellow"});
        add(colorLabel);
        add(colorCombo);
    }
    private void addSides(){
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(3, 3, 100, 1));
        sidesField.setValue(6);
        add(sidesLabel);
        add(sidesField);
    }
    private void addSize(){
        sizeLabel=new JLabel("Size: ");
        sizeField=new JSpinner(new SpinnerNumberModel(5,  0, 20, 1));
        add(sizeLabel);
        add(sizeField);
    }
    public void removeObj(){
        this.removeAll();
    }

    public void repaintConfig(String string){
        if (string.compareTo("Circle")==0)
            circleConfigPanel();
        else if (string.compareTo("Star")==0)
            starConfigPanel();
        else
            init(string);

    }

    private void change(ActionEvent actionEvent) {

        String str=shapeCombo.getSelectedItem().toString();
        repaintConfig(str);
    }
}