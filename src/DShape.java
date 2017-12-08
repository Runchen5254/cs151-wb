import java.awt.*;

public abstract class DShape implements ModelListener{
    DShapeModel model;

    //Constructor
    DShape(){}

    //Getter
    public DShapeModel getModel() { return model; }

    //Setter
    public void setModel(DShapeModel model) { this.model = model; }
}
