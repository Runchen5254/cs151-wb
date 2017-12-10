import java.awt.*;

public abstract class DShape implements ModelListener{
    DShapeModel model;
    private Canvas canvas;

    //Constructor
    DShape(){}

    //Methods
    public abstract void draw(Graphics graphics);
    public void modelChanged(DShapeModel model){ this.canvas.repaint(); }


    //Getter
    public DShapeModel getModel() { return model; }

    //Setter
    public void setModel(DShapeModel model) { this.model = model; }
}
