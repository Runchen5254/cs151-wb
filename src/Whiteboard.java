import javax.swing.*;

public class Whiteboard extends JFrame{

    private JFrame main = this;

    /*main-----------------------------------------------------------*/
    public static void main(String[] args){

            Whiteboard whiteboard = new Whiteboard();
            whiteboard.setVisible(true);

    }

    public Whiteboard(){
        super("WhiteBoard");
        this.setSize(900,400);
    }

}
