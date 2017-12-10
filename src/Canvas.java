import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Canvas extends JPanel{
    private ArrayList<DShape> dShapeArr = new ArrayList();
    private DShape selectedShape;                               //The canvas should have a pointer of a
                                                                //single selected shape at any one time.
    private int selectedX, selectedY;

    private Canvas canvas = this;

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
}
