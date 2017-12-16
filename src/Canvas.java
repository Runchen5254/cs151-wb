import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Point;
import java.awt.Graphics;

public class Canvas extends JPanel{
    private Canvas canvas = this;
    private ArrayList<DShape> dShapeArr = new ArrayList();
    private DShape selectedShape;                               //The canvas should have a pointer of a
                                                                //single selected shape at any one time.

    private int selectedX, selectedY;
    private Point movingKnob;
    private Point anchorKnob;


    public Canvas() { //Error: Canvas(WhiteBoard wb)
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Canvas.this.selectedX = e.getX();
                Canvas.this.selectedY = e.getY();

                if (Canvas.this.selectedShape != null){
                    ArrayList<Point> knobPoints = Canvas.this.selectedShape.getKnobs();

                    for(Point point: knobPoints){
                        if ((double)e.getX() <= point.getX() + 4.0D && (double)e.getX() >= point.getX() - 4.0D && (double)e.getY() <= point.getY() + 4.0D && (double)e.getY() >= point.getY() - 4.0D) {
                            Canvas.this.movingKnob = point;
//                            if (Canvas.this.selectedShape instanceof DLine) {
//                                if (((Point)knobPoints.get(0)).equals(Canvas.this.movingKnob)) {
//                                    Canvas.this.anchorKnob = (Point)knobPoints.get(1);
//                                } else if (((Point)knobPoints.get(1)).equals(Canvas.this.movingKnob)) {
//                                    Canvas.this.anchorKnob = (Point)knobPoints.get(0);
//                                }
//                            } else
                                if (((Point)knobPoints.get(0)).equals(Canvas.this.movingKnob)) {
                                Canvas.this.anchorKnob = (Point)knobPoints.get(3);
                            } else if (((Point)knobPoints.get(1)).equals(Canvas.this.movingKnob)) {
                                Canvas.this.anchorKnob = (Point)knobPoints.get(2);
                            } else if (((Point)knobPoints.get(2)).equals(Canvas.this.movingKnob)) {
                                Canvas.this.anchorKnob = (Point)knobPoints.get(1);
                            } else if (((Point)knobPoints.get(3)).equals(Canvas.this.movingKnob)) {
                                Canvas.this.anchorKnob = (Point)knobPoints.get(0);
                            }

                            return;
                        }
                    }
                }

                Canvas.this.anchorKnob = null;
                Canvas.this.setSelectedShape((DShape)null);
                //whiteboard.disableTextButtons();

                for(int i = Canvas.this.dShapeArr.size() - 1; i >= 0; --i) {
                    DShape shape = (DShape)Canvas.this.dShapeArr.get(i);
                    Rectangle bounds = shape.getBounds();
                    if (bounds.contains(Canvas.this.selectedX, Canvas.this.selectedY)) {
                        Canvas.this.setSelectedShape(shape);
                        Canvas.this.selectedShape.drawKnobs(Canvas.this.getGraphics());
//                        if (Canvas.this.selectedShape instanceof DText) {
//                            whiteboard.enableTextButtons();
//                            DTextModel model = (DTextModel)Canvas.this.selectedShape.getModel();
//                            whiteboard.fontSelect.setSelectedIndex(model.getIndex());
//                            whiteboard.inputField.setText(model.getText());
//                        }

                        return;
                    }
                }
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

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for(DShape shape : dShapeArr){
            shape.draw(g);
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

