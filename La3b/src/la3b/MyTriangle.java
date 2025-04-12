package la3b;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class MyTriangle extends MyShape{

	Polygon t;
	
	MyTriangle(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	void draw(Pane p) {
		t = new Polygon(x,y, x+30,y+40, x-30,y+40);
		t.setFill(Color.GREEN);
		p.getChildren().add(t);
	}

	@Override
	void highlight(Pane p) {
		t.setFill(Color.YELLOW);
		p.getChildren().add(p);
	}


}
