import java.awt.Graphics;

public class DOval extends DShape {
    public DOval(DShapeModel model) {
        this.model = model;
    }
    public void draw(Graphics g) {
        g.setColor(this.model.getColor());
        g.fillOval(this.model.getX(), this.model.getY(), this.model.getWidth(), this.model.getHeight());
    }
}
