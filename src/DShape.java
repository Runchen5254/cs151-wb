import java.awt.*;
import java.util.ArrayList;
import java.awt.geom.*;

public abstract class DShape implements ModelListener{
    DShapeModel model;
    private Canvas canvas;
    private static final int pixels = 9;    //black squares 9 pixels

    //Constructor--------------------------------------------------------------
    DShape(){}

    //Methods------------------------------------------------------------------
    public abstract void draw(Graphics g);
    public void modelChanged(DShapeModel model){ this.canvas.repaint(); }


    //Getter-------------------------------------------------------------------
    public DShapeModel getModel() { return model; }

    public Rectangle getBounds() { return this.model.getBounds(); }

    //getKnobs:
    //  Returns a list of four Point objects, with each x,y point being 
    //  the pixel just inside the four corners of the shape bounds rectangle. 
    public ArrayList<Point> getKnobs() {
        ArrayList<Point> pts = new ArrayList();

        Point topL = new Point(this.model.getX(), this.model.getY());
        Point topR = new Point(this.model.getX() + this.model.getWidth(), this.model.getY());

        Point botL = new Point(this.model.getX(), this.model.getY() + this.model.getHeight());
        Point botR = new Point(this.model.getX() + this.model.getWidth(), this.model.getY() + this.model.getHeight());

        pts.add(topL);
        pts.add(topR);

        pts.add(botL);
        pts.add(botR);

        return pts;
    }

    //drawKnobs:
    //  Modify the canvas/shape draw code so the selected shape
    //  has black squares 9 pixels(define in a constant)on a side.
    public void drawKnobs(Graphics g) {
        ArrayList<Point> knobs = this.getKnobs();

        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.BLACK);

        Point topL = (Point)knobs.get(0);
        Point topR = (Point)knobs.get(1);
        Point botL = (Point)knobs.get(2);
        Point botR = (Point)knobs.get(3);

        Rectangle2D topLeft = new Rectangle2D.Double(topL.getX() - 4, topL.getY() - 4, pixels, pixels);
        Rectangle2D topRight = new Rectangle2D.Double(topR.getX() - 4, topR.getY() - 4, pixels, pixels);
        Rectangle2D bottomLeft = new Rectangle2D.Double(botL.getX() - 4, botL.getY() - 4, pixels, pixels);
        Rectangle2D bottomRight = new Rectangle2D.Double(botR.getX() - 4, botR.getY() - 4, pixels, pixels);

        g2d.fill(topLeft);
        g2d.fill(topRight);
        g2d.fill(bottomLeft);
        g2d.fill(bottomRight);
    }

    //Setter-------------------------------------------------------------------
    public void setModel(DShapeModel model) { this.model = model; }
}
