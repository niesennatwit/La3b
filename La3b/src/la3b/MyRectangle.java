package la3b;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MyRectangle extends MyShape{

	Rectangle r;
	
	MyRectangle(double x, double y) {
		this.x = x;
		this.y = y;
		r = new Rectangle(x,y, 20, 30);
		r.setFill(Color.PURPLE);
	}
	
	@Override
	void draw(Pane p) {
		p.getChildren().add(r);
	}

	@Override
	void highlight() {
		r.setFill(Color.YELLOW);
	}

}
