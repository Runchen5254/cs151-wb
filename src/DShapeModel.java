import java.awt.*;
import java.util.ArrayList;

/*
* Model for DShape class
*
*/
public class DShapeModel {
    //Private variables
    private int x;
    private int y;
    private int height;
    private int width;
    private Color color;
    private ArrayList<ModelListener> modelListenerArr = new ArrayList();

    //Constructor
    public DShapeModel(){

    }

    //Getters
    public int getX() { return x; }
    public int getY() { return y; }
    public int getHeight() { return height; }
    public int getWidth() { return width; }
    public Color getColor() { return color; }
    public ArrayList<ModelListener> getModelListenerArr() { return modelListenerArr; }

    //Setters
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setHeight(int height) { this.height = height; }
    public void setWidth(int width) { this.width = width; }
    public void setColor(Color color) { this.color = color; }
    public void setModelListenerArr(ArrayList<ModelListener> modelListenerArr) { this.modelListenerArr = modelListenerArr; }
}
