package la3b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application{
	//global variables go here
	private int count = 0;
	private ComboBox border = new ComboBox();
	private List<String> shapeList = new ArrayList<String>();
	private Map<String, MyShape> shapeMap = new HashMap<String, MyShape>();
	private Pane canvas = new Pane();
	

	@Override
	public void start(Stage pstage) throws Exception {
		
		Button newShape = new Button("Add new shape!");
		
		newShape.setOnAction(e -> {
			MyShape s = randShape();
			s.draw(canvas);
			count++;
			shapeList.add(s.getClass().getSimpleName() + " " + count);
			shapeMap.put(s.getClass().getSimpleName() + " " + count, s);
		});
		
		canvas.getChildren().add(newShape);	
		pstage.setHeight(300);
		pstage.setWidth(600);
		pstage.setTitle("javafx shape gallery");
		
		Scene pscene = new Scene(canvas,500, 500);
		pstage.setScene(pscene);
		pstage.show();
		
	}
	
	private MyShape randShape() {
		int rand = (int)(Math.random() * 3);
		double randx = 50 + Math.random() * 500;
		double randy = 50 + Math.random() * 500;
		MyShape s;
		
		switch(rand) {
		case 0 -> s = new MyCircle(randx,randy);
		case 1 -> s = new MyRectangle(randx,randy);
		default -> s = new MyTriangle(randx,randy);
		}
		
		return s;
	}
	
	private void filter() {
		
	}
	
	private void highlight() {
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
;