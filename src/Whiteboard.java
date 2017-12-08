import javax.swing.*;
import java.awt.*;

public class Whiteboard extends JFrame{

    private Canvas canvas = new Canvas(this);
    private JFrame main = this;



    //main---------------------------------------------------------------------
    public static void main(String[] args){

            Whiteboard whiteboard = new Whiteboard();
            whiteboard.setVisible(true);

    }

    //Constructor--------------------------------------------------------------
    public Whiteboard(){
        super("WhiteBoard");
        this.setSize(900,400);
        this.showCanvas();

    }

    //Methods------------------------------------------------------------------
    public void showCanvas(){
        this.canvas.setBackground(Color.WHITE);
        this.canvas.setMaximumSize(new Dimension(400, 400));
        this.canvas.setMinimumSize(new Dimension(400, 400));
        this.getContentPane().add("Center", this.canvas);
    }

}
