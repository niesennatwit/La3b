package la3b;

import javafx.scene.layout.Pane;

public abstract class MyShape {
	double x;
	double y;
	
	abstract void draw(Pane p);
	abstract void highlight(Pane p);
}
