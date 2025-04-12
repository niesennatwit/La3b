package la3b;

import java.util.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application{
	//global variables go here
	private int[] count = {0,0,0};
	private int current = 0;
	private ComboBox<String> filter = new ComboBox<String>();
	private ListView<String> shapeListView = new ListView<String>();
	private List<MyShape> shapeList = new ArrayList<MyShape>();
	private Map<String, MyShape> shapeMap = new HashMap<String, MyShape>();
	private Pane canvas = new Pane();
	

	@Override
	public void start(Stage pstage) throws Exception {
		
		Button newShape = new Button("Add new shape!");
		
		filter.getItems().addAll("All", "MyCircle", "MyRectangle", "MyTriangle");
        filter.setValue("All");
		
		newShape.setOnAction(e -> {
			MyShape s = randShape();
			s.draw(canvas);
			shapeList.add(s);
			shapeListView.getItems().add(s.getClass().getSimpleName() + " " + count[current]);
			shapeMap.put(s.getClass().getSimpleName() + " " + count[current], s);
		});
		
		filter.setOnAction(e -> {
			String value = filter.getValue();
            shapeListView.getItems().clear();
            canvas.getChildren().clear();
            for (Map.Entry<String, MyShape> entry : shapeMap.entrySet()) {
                if (value.equals("All") || entry.getValue().getClass().getSimpleName().equals(value)) {
                    shapeListView.getItems().add(entry.getKey());
                    entry.getValue().draw(canvas);
                }
            }
		});
		
        shapeListView.setOnMouseClicked(e -> {
            String name = shapeListView.getSelectionModel().getSelectedItem();
            if (name != null) {
                MyShape selected = shapeMap.get(name);
                String value = filter.getValue();
                canvas.getChildren().clear();
                for (MyShape s : shapeList) {
                	if (value.equals("All") || s.getClass().getSimpleName().equals(value)) {
	                	s.draw(canvas);
                	}
                }
                selected.highlight(canvas);
            }
        });
		
		VBox UI = new VBox(10, newShape, filter, shapeListView);
        HBox root = new HBox(10, UI, canvas);
        
        root.setStyle("-fx-padding: 50");
		pstage.setHeight(300);
		pstage.setWidth(600);
		pstage.setTitle("javafx shape gallery");
		
		Scene pscene = new Scene(root,500, 500);
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
		
		current = rand;
		count[current]++;
		
		return s;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
;