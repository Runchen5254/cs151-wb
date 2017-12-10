import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/*
* Model for DShape class
*
*/
public class DShapeModel {

    // Private variables-------------------------------------------------------
    // DShapeModel should store a conceptual "bounds" rectangle
    // defined by 4 ints:x,y,width,height, and a Color. 

    private int x;
    private int y;
    private int height;
    private int width;
    private Color color;
    private ArrayList<ModelListener> modelListenerArr = new ArrayList();

    //Constructor--------------------------------------------------------------
    public DShapeModel(){this.setColor(Color.GRAY);}

    public DShapeModel(int x, int y, int height, int width, Color color){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.color = color;
    }

    //Methods------------------------------------------------------------------

    // addModelListener:
    //  Add a model listener to a new shape.
    //  Before adding, check if modelListenerArr
    //  is empty.

    public void addModelListener(ModelListener modelListener){
        if(this.modelListenerArr.isEmpty()) {
            this.modelListenerArr = new ArrayList();
            this.modelListenerArr.add(modelListener);
        }
        else
            this.modelListenerArr.add(modelListener);
    }

    public Rectangle getBounds(){ return new Rectangle(getX(), getY(), getWidth(), getHeight()); }

    public void notifyChanged(){
        for(ModelListener listener: modelListenerArr)
            listener.modelChanged(DShapeModel.this);
    }

    //Getters------------------------------------------------------------------
    public int getX() { return x; }
    public int getY() { return y; }
    public int getHeight() { return height; }
    public int getWidth() { return width; }
    public Color getColor() { return color; }
    public ArrayList<ModelListener> getModelListenerArr() { return modelListenerArr; }

    //Setters------------------------------------------------------------------
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setHeight(int height) { this.height = height; }
    public void setWidth(int width) { this.width = width; }
    public void setColor(Color color) { this.color = color; }
    public void setModelListenerArr(ArrayList<ModelListener> modelListenerArr) { this.modelListenerArr = modelListenerArr; }
}
