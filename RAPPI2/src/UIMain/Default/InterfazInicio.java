import javafx.application.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class InterfazInicio extends Application{
	
	public void start(Stage MyStage) throws Exception{
		
		MyStage.setTitle("RAPPI2");
		
		GridPane P1 = new GridPane();
		GridPane P2 = new GridPane();
		BorderPane P3 = new BorderPane();
		FlowPane f1 = new FlowPane();
		FlowPane f2 = new FlowPane();
		Button login = new Button("Log In");
		Button signup = new Button("Sign Up");
		TextField autores = new TextField("AUTORES");
		Image imagen2 = new Image(getClass().getResourceAsStream("images/tender2.png"));
		ImageView imageView2 = new ImageView(imagen2);
		
		P2.setMinHeight(600);
		P2.setMinWidth(600);
		P3.setMinHeight(600);
		P3.setMinWidth(600);
	
		login.setMaxWidth(Double.MAX_VALUE);
		signup.setMaxWidth(Double.MAX_VALUE);
		autores.setMaxWidth(Double.MAX_VALUE);
	
		f1.getChildren().add(new Label("  "));
		f1.getChildren().add(login);
		f1.getChildren().add(signup);
		f1.setHgap(4);
		f1.setVgap(4);
		f1.setMinWidth(Double.MAX_VALUE);

		f2.getChildren().add(new Label("  "));
		f2.getChildren().add(autores);
		
		P2.add(f2, 0, 0);
		
		P3.setTop(f1);
		P3.setCenter(imageView2);
		
		P1.add(P2, 0, 0);
		P1.add(P3, 1, 0);
		P1.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
	
		imageView2.setX(30);
		imageView2.setY(30);
		imageView2.setFitHeight(200);
		imageView2.setFitWidth(300);

		
		Scene escena = new Scene(P1, 1200,600);
		MyStage.setScene(escena);
		MyStage.show();
		
	}
	public static void main (String[]args) {
		launch(args);
	}
}
