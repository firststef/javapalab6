package lab6;

import java.awt.*;

public class Star extends Polygon {

    public Star(int x0, int y0, int radius){
        this.addPoint(x0, y0-2*radius);

        this.addPoint(x0-radius, y0+radius);

        this.addPoint(x0+(int)(1.3*radius), y0-radius);

        this.addPoint(x0-(int)(1.3*radius), y0-radius);

        this.addPoint(x0+radius, y0+radius);

    }
}
