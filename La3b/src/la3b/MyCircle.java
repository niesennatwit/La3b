package la3b;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MyCircle extends MyShape{
	
	Circle c;
	
	MyCircle(double x, double y) {
		this.x = x;
		this.y = y;
		c = new Circle(x,y,30);
		c.setFill(Color.PURPLE);
	}
	
	@Override
	void draw(Pane p) {
		p.getChildren().add(c);
	}

	@Override
	void highlight() {
		c.setFill(Color.YELLOW);
	}

}
