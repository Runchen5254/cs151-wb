import java.awt.*;

public class DRect extends DShape{
    public DRect(DShapeModel model){
        this.model = model;
    }
    public void draw(Graphics g){
        g.setColor(this.model.getColor());
        g.fillRect(this.model.getX(), this.model.getY(), this.model.getWidth(), this.model.getHeight());
    }
}
