import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Whiteboard extends JFrame{

    private Canvas canvas = new Canvas();//Error: new Canvas(this)
    private JFrame frame = this;
    private ArrayList<Container> buttonBoxArr = new ArrayList();



    //frame---------------------------------------------------------------------
    public static void main(String[] args){
            Whiteboard whiteboard = new Whiteboard();
            whiteboard.setVisible(true);

    }

    //Constructor--------------------------------------------------------------
    public Whiteboard(){
        this.setTitle("WhiteBoard");
        this.setSize(900,400);
        this.addCanvas();
        this.addControls();
    }

    //Methods------------------------------------------------------------------
    public void addCanvas(){
        this.canvas.setBackground(Color.WHITE);
        this.canvas.setMaximumSize(new Dimension(400,400));
        this.canvas.setMinimumSize(new Dimension(400,400));
        this.getContentPane().add("Center", this.canvas);
    }

    public void addControls(){
        Box boxContainer = Box.createVerticalBox();
        Box addBox = this.getBoxShape();

        boxContainer.setSize(400,400);
        boxContainer.add(Box.createVerticalStrut(5));
        boxContainer.add(addBox);

        this.buttonBoxArr.add(boxContainer);
        this.buttonBoxArr.add(addBox);

        this.getContentPane().add("West",boxContainer);


    }

    public Box getBoxShape(){
        //Box Shape
        Box boxShape = Box.createHorizontalBox();
        boxShape.setMaximumSize(new Dimension(400,40));

        //Label
        JLabel addShapeLabel = new JLabel("Add Shape: ");
        boxShape.add(addShapeLabel);

        //Rectangle button
        JButton rectBtn = new JButton("Rectangle");
        rectBtn.setMaximumSize(new Dimension(80,80));
        boxShape.add(rectBtn);

        //Oval button
        JButton ovalBtn = new JButton("Oval");
        ovalBtn.setMaximumSize(new Dimension(80,80));
        boxShape.add(ovalBtn);

        //Line button
        JButton lineBtn = new JButton("Line");
        lineBtn.setMaximumSize(new Dimension(80,80));
        boxShape.add(lineBtn);

        //Text
        JButton textBtn = new JButton("Text");
        textBtn.setMaximumSize(new Dimension(80,80));
        boxShape.add(textBtn);

        //Listeners
        rectBtn.addActionListener(e -> {
            DRectModel rect = new DRectModel();
            this.createDefaultShape(rect);
            this.canvas.addShape(rect);
        });

        return boxShape;
    }

    //createDefaultShape:
    //  When calling this method, set x, y, height, and width
    //  of a shape to a default value.

    public void createDefaultShape(DShapeModel model){
        model.setX(15);
        model.setY(15);
        model.setHeight(15);
        model.setWidth(15);
    }

}
