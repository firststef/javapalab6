package lab6;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;

    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame){
        this.frame = frame;
        createOffScreenImage();
        init();
    }
    void createOffScreenImage(){
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
    private void drawShape(int x, int y){
        int radius = (int)this.frame.configPanel.sizeSpinner.getValue();
        int sides  = (int)this.frame.configPanel.sidesSpinner.getValue();
        //Color color = (int)this.frame.configPanel.colorB.getValue();
        Color color = new Color(0x4C37767D, true);
        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x,y,radius,sides));
    }

    @Override
    public void update(Graphics f){

    }
    @Override
    protected void paintComponent(Graphics g){
        g.drawImage(image, 0,0, this);
    }
}

