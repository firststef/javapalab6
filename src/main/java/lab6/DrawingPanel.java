package lab6;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;

    List<DrownShape> shapes=new ArrayList<>();


    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame){
        this.frame = frame;
        createOffScreenImage();
        init();
    }
    private void createOffScreenImage(){
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,W, H);
    }
    private void init(){
        setPreferredSize(new Dimension(W,H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }


    private void drawShape(int x, int y) {
        int radius = (int) ((Integer)frame.configPanel.sizeField.getValue()*10);
        String shape=frame.configPanel.shapeCombo.getSelectedItem().toString();
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color color = new Color(r, g, b, (float) 0.5);
        if (shape.compareTo("Circle")==0){
            drawCircle(color,x,y,radius);
        }else if (shape.compareTo("Star")==0){
            drawStar(color, x, y, radius);
        }else if (shape.compareTo("Random")==0){
            double random=Math.random();
            if (random<=0.33)
                drawCircle(color, x, y, radius);
            else if (random >=0.66)
                drawStar(color, x, y, radius);
            else
                drawPolygon(color, x, y, radius);
        }else{
            drawPolygon(color, x, y, radius);
        }
        drawLast();
        frame.figuresPanel.addFigure(shapes.get(shapes.size()-1));
    }
    private void drawLast(){
        DrownShape shape=shapes.get(shapes.size()-1);
        graphics.setColor(shape.color);
        if (shape.shape instanceof Circle){
            graphics.fillOval(((Circle) shape.shape).x, ((Circle) shape.shape).y,2*((Circle) shape.shape).radius, 2*((Circle) shape.shape).radius);
        }
        else
            graphics.fill(shape.shape);
    }
    void drawAll(){
        reset();
        for (DrownShape d : shapes){
            graphics.setColor(d.color);
            if (d.shape instanceof Circle){
                graphics.fillOval(((Circle) d.shape).x, ((Circle) d.shape).y,2*((Circle) d.shape).radius, 2*((Circle) d.shape).radius);
            }
            else
                graphics.fill(d.shape);
        }
    }

    private void drawCircle(Color color, int x, int y, int radius){
        DrownShape shape=new DrownShape((Shape) new Circle(x,y,radius), color);
        shapes.add(shape);
    }
    private void drawStar(Color color, int x, int y, int radius){
        DrownShape shape=new DrownShape(new Star(x,y,radius), color);
        shapes.add(shape);
    }
    private void drawPolygon(Color color, int x, int y, int radius){
        int sides = (Integer)frame.configPanel.sidesField.getValue();
        DrownShape shape=new DrownShape(new RegularPolygon(x,y,radius, sides), color);
        shapes.add(shape);
    }
    @Override
    public void update(Graphics f){

    }
    @Override
    protected void paintComponent(Graphics g){
        g.drawImage(image, 0,0, this);
    }

    /**
     * reapelez functia de desenare a DrawingPanelului
     */
    protected void reset(){createOffScreenImage();}
}

