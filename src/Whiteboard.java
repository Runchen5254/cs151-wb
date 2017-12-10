import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Whiteboard extends JFrame{

    private Canvas canvas = new Canvas();//Error: new Canvas(this)
    private JFrame main = this;
    private ArrayList<Container> buttonBoxArr = new ArrayList();



    //main---------------------------------------------------------------------
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
    public void addCanvas(){ this.getContentPane().add("Center", this.canvas); }

    public void addControls(){
        Box boxContainer = Box.createVerticalBox();
        Box addBox = this.getBoxShape();

        boxContainer.setSize(500,500);
        boxContainer.add(Box.createVerticalStrut(5));
        boxContainer.add(addBox);

        this.buttonBoxArr.add(boxContainer);
        this.buttonBoxArr.add(addBox);

        this.getContentPane().add("West",boxContainer);


    }

    public Box getBoxShape(){
        Box boxShape = Box.createHorizontalBox();
        boxShape.setSize(500,50);

        JLabel label = new JLabel("Add Shape: ");
        boxShape.add(label);

        boxShape.add(Box.createRigidArea(new Dimension(5,0)));
        JButton rectBtn = new JButton("Rectangle");
        rectBtn.setSize(80,40);
        boxShape.add(rectBtn);
        rectBtn.addActionListener(e -> {
            System.out.println("It works!");
        });
        return boxShape;
    }

}
