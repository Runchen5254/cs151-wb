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
        Box container = Box.createVerticalBox();
        Box addBox = this.getInputShapeBox();

        container.setSize(500,500);
        container.add(Box.createVerticalStrut(5));
        container.add(addBox);

        this.buttonBoxArr.add(container);
        this.buttonBoxArr.add(addBox);

        this.getContentPane().add("West",container);


    }

    public Box getInputShapeBox(){
        Box InputBox = Box.createHorizontalBox();
        InputBox.setSize(500,50);

        JLabel label = new JLabel("Add Shape: ");
        InputBox.add(label);

        InputBox.add(Box.createRigidArea(new Dimension(5,0)));
        JButton rectBtn = new JButton("Rectangle");
        rectBtn.setSize(80,40);
        InputBox.add(rectBtn);
        rectBtn.addActionListener(e -> {
            System.out.println("It works!");
        });
        return InputBox;
    }

}
