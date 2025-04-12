package la3b;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MyRectangle extends MyShape{

	Rectangle r;
	
	MyRectangle(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	void draw(Pane p) {
		r = new Rectangle(x,y, 60, 30);
		r.setFill(Color.RED);
		p.getChildren().add(r);
	}

	@Override
	void highlight(Pane p) {
		r.setFill(Color.YELLOW);
		p.getChildren().add(r);
	}

}
