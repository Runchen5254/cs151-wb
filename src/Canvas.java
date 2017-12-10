import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Canvas extends JPanel{
    private Canvas canvas = this;
    private ArrayList<DShape> dShapeArr = new ArrayList();
    private DShape selectedShape;                               //The canvas should have a pointer of a
                                                                //single selected shape at any one time.

    private int selectedX, selectedY;


    public Canvas() { //Error: Canvas(WhiteBoard wb)
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Canvas.this.setSize(400,400);
                Canvas.this.selectedX = e.getX();
                Canvas.this.selectedY = e.getY();
                Canvas.this.setBackground(Color.WHITE);
                Canvas.this.setVisible(true);
            }
        });


    }

    //Methods------------------------------------------------------------------

    //addShape:
    //  When calling addShape, add a shape to the canvas.
    //  This shape will be set to a default value.

    public void addShape(DShapeModel model){
        if (model instanceof DRectModel) {
            DRect rect = new DRect(model);
            this.setSelectedShape(rect);
        }

        this.dShapeArr.add(this.getSelectedShape());
        this.selectedShape.getModel().addModelListener(this.selectedShape);
        this.repaint();
    }


    // paintComponent:
    //  Loop through all the shapes and draw them.

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        for(DShape shape : dShapeArr){
            shape.draw(graphics);
        }
    }


    //Getters------------------------------------------------------------------
    public ArrayList<DShape> getdShapeArr() { return dShapeArr; }
    public DShape getSelectedShape() { return selectedShape; }
    public int getSelectedX() { return selectedX; }
    public int getSelectedY() { return selectedY; }
    public Canvas getCanvas() { return canvas; }


    //Setters------------------------------------------------------------------
    public void setdShapeArr(ArrayList<DShape> dShapeArr) { this.dShapeArr = dShapeArr; }
    public void setSelectedShape(DShape selectedShape) { this.selectedShape = selectedShape; }
    public void setSelectedX(int selectedX) { this.selectedX = selectedX; }
    public void setSelectedY(int selectedY) { this.selectedY = selectedY; }
    public void setCanvas(Canvas canvas) { this.canvas = canvas; }



}

