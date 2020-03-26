package UIMain.Default;

import BaseDatos.Data;
import UIMain.Excepciones.AlertaConfirmacion;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class InterfazInicio extends Application{
	
	
	public static Stage window;//
	static Scene escena; //
	GridPane P1 = new GridPane();
	BorderPane P2 = new BorderPane();
	public static BorderPane P3 = new BorderPane();
	static FlowPane f1 = new FlowPane();
	FlowPane f2 = new FlowPane();
	Button login = new Button("Log In");
	Button signup = new Button("Sign Up");
	Label autores = new Label("AUTORES");
	ImageView imagenViewGenerico = new ImageView();
	Image imagen1 = new Image(getClass().getResourceAsStream("UIMain.Default.Images/tender2.png"));
	ImageView imagenView1 = new ImageView(imagen1);
	Image imagen2 = new Image(getClass().getResourceAsStream("UIMain.Default.Images/comida.jpg"));
	ImageView imagenView2 = new ImageView(imagen2);
	Image imagen3 = new Image(getClass().getResourceAsStream("UIMain.Default.Images/moto.jpg"));
	ImageView imagenView3 = new ImageView(imagen3);
	Image imagen4 = new Image(getClass().getResourceAsStream("UIMain.Default.Images/celular.jpg"));
	ImageView imagenView4 = new ImageView(imagen4);
	Image imagen5 = new Image(getClass().getResourceAsStream("UIMain.Default.Images/completo.jpg"));
	ImageView imagenView5 = new ImageView(imagen5);
	Label generico = new Label("");
	Label mateo = new Label("Mateo Rinc�n Arias\r\n" + 
			"Estudiante\r\n" + 
			"Bachiller cursando el cuarto semestre de educacion superior\r\n" + 
			"Informacion de contacto:\r\n" + 
			"Email:\r\n" + 
			"    rincon.mateo04@gmail.com\r\n" + 
			"Telefono:\r\n" + 
			"    (+57) 321 831 4047\r\n" + 
			"Fecha de nacimiento:\r\n" + 
			"    1999-03-27\r\n" + 
			"Idiomas:\r\n" + 
			"    Ingles\r\n" + 
			"        Nivel avanzado\r\n" + 
			"Educacion:\r\n" + 
			"    Estudiante de Ingenieria de Sistemas e Informatica\r\n" + 
			"        Universidad Nacional de Colombia, sede Medellin\r\n" + 
			"    Estudiante de Ingenieria de Matematica\r\n" + 
			"        Universidad Nacional de Colombia, sede Medellin\r\n" + 
			"    Bachiller\r\n" + 
			"    New Germany Rural High School. New Germany, Canada\r\n" + 
			"    2017\r\n" + 
			"    Bachiller\r\n" + 
			"    San Jose de las Vegas. Medellin, Colombia\r\n" + 
			"    2016");
	Label santiago = new Label("Santiago Tamayo Lopez\r\n" + 
			"Estudiante \r\n" + 
			"\r\n" + 
			"Bachiller cursando el cuarto semestre de educacion superior\r\n" + 
			"\r\n" + 
			"Informacion de contacto:\r\n" + 
			"Email:\r\n" + 
			"	stamayol@unal.edu.co\r\n" + 
			"Telefono:\r\n" + 
			"	(+57) 302 273 2242\r\n" + 
			"Fecha de nacimiento:\r\n" + 
			"	2001-04-21\r\n" + 
			"Idiomas:\r\n" + 
			"	Ingles\r\n" + 
			"		 Nivel Avanzado\r\n" + 
			"Educacion:\r\n" + 
			"	Estudiante de Ingenieria de Sistemas e Informatica\r\n" + 
			"		Universidad Nacional de Colombia, Sede Medellin\r\n" + 
			"	Bachiller\r\n" + 
			"		Colegio Parroquial Emaus. Medellin, Colombia 2017");
	Label guille = new Label("Guillermo Toloza Guzm�n\r\n" + 
			"Estudiante UNAL\r\n" + 
			"Actualmente cursando 3er semestre en la Universidad Nacional de Colombia\r\n" + 
			"Datos de contacto:\r\n" + 
			"Gmail:\r\n" + 
			"gtoloza@unal.edu.co\r\n" + 
			"Fecha de Nacimiento:\r\n" + 
			"02-06-2000\r\n" + 
			"Lugar de Nacimiento:\r\n" + 
			"San Jos� de C�cuta, Norte de Santander\r\n" + 
			"Colombia\r\n" + 
			"Manejo de Idiomas:\r\n" + 
			"Ingles: Nivel Avanzado\r\n" + 
			"Estudios:\r\n" + 
			"Estudios Superiores: \r\n" + 
			"Estudiante de Ingenier�a de Sistemas e Inform�tica, UNAL Sede Medell�n\r\n" + 
			"Bachiller:\r\n" + 
			"Colegio Gimnasio Domingo Savio, san Jos� De C�cuta, Norte de Santander\r\n" + 
			"A�o 2017.");
	Label andre = new Label("Paula Andrea Taborda Jaramillo\r\n" + 
			"Estudiante \r\n" + 
			"Bachiller cursando el cuarto semestre de educacion superior\r\n" + 
			"Informacion de contacto:\r\n" + 
			"Email:\r\n" + 
			"	ptaborda@unal.edu.co\r\n" + 
			"Telefono:\r\n" + 
			"	(+57) 320 752 2464\r\n" + 
			"Fecha de nacimiento:\r\n" + 
			"	2000-05-02\r\n" + 
			"Idiomas:\r\n" + 
			"	Ingles\r\n" + 
			"		 Nivel Avanzado\r\n" + 
			"Educacion:\r\n" + 
			"	Estudiante de Ingenieria de Sistemas e Informatica\r\n" + 
			"		Universidad Nacional de Colombia, Sede Medellin\r\n" + 
			"	Bachiller\r\n" + 
			"		Diego Echavarria Misas. Medellin, Colombia 2017");
	Image [] imagenes = new Image[5];
	
	
	public void start(Stage MyStage) throws Exception{
	
		MyStage.setTitle("RAPPI2");
		
		generico.setStyle("-fx-background-color:POWDERBLUE");
		
		P2.setMinHeight(600);
		P2.setMinWidth(600);
		P3.setMinHeight(600);
		P3.setMinWidth(600);
		
		autores.setStyle("-fx-alignment: center; -fx-background-color:POWDERBLUE");
		autores.setFont(Font.font("Verdana", FontWeight.LIGHT, 20));
		
		
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
		f2.setStyle("-fx-background-color: gray; -fx-flow-lines-visible: true");
		
		P2.setTop(autores);
		P2.setCenter(generico);
		P3.setTop(f1);
		P3.setCenter(imagenViewGenerico);
		
		P1.add(P2, 0, 0);
		P1.add(P3, 1, 0);
		P1.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
	
		imagenView1.setX(30);
		imagenView1.setY(30);
		imagenView1.setFitHeight(200);
		imagenView1.setFitWidth(300);

		imagenView2.setX(30);
		imagenView2.setY(30);
		imagenView2.setFitHeight(200);
		imagenView2.setFitWidth(300);
		
		imagenView3.setX(30);
		imagenView3.setY(30);
		imagenView3.setFitHeight(200);
		imagenView3.setFitWidth(300);
		
		imagenView4.setX(30);
		imagenView4.setY(30);
		imagenView4.setFitHeight(200);
		imagenView4.setFitWidth(300);
		
		imagenView5.setX(30);
		imagenView5.setY(30);
		imagenView5.setFitHeight(200);
		imagenView5.setFitWidth(300);

		
		Scene escena = new Scene(P1, 1200,600);
		MyStage.setScene(escena);
		MyStage.show();
		
		generico.setText(mateo.getText());
		generico.setOnMouseClicked(cambio);
		mateo.setOnMouseClicked(cambio);
		santiago.setOnMouseClicked(cambio);
		guille.setOnMouseClicked(cambio);
		andre.setOnMouseClicked(cambio);
	
		imagenes[0] = imagen1;
		imagenes[1] = imagen2;
		imagenes[2] = imagen3;
		imagenes[3] = imagen4;
		imagenes[4] = imagen5;
		
		imagenViewGenerico.setImage(imagen1);
		imagenViewGenerico.setX(30);
		imagenViewGenerico.setY(30);
		imagenViewGenerico.setFitHeight(200);
		imagenViewGenerico.setFitWidth(300);
		
		imagenViewGenerico.setOnMouseEntered(entrar);
		imagenViewGenerico.setOnMouseEntered(salir);
	}
		
	EventHandler<MouseEvent> cambio = new EventHandler<MouseEvent>() {
		public void handle (MouseEvent mouseEvent) {
			if(generico.getText().equals(mateo.getText())) {
				generico.setText(santiago.getText());
			}
			else if (generico.getText().equals(santiago.getText())) {
				generico.setText(guille.getText());
			}
			else if (generico.getText().equals(guille.getText())) {
				generico.setText(andre.getText());
			}
			else if (generico.getText().equals(andre.getText())) {
				generico.setText(mateo.getText());
			}
		}
	};	
	
	int contador = 0;
	boolean verdad = true;
	EventHandler<MouseEvent> entrar = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			while(verdad) {
				if(contador<5) {
					if (imagenViewGenerico.equals(new ImageView(imagenes[contador]))) {
						contador ++;
						imagenViewGenerico.setImage(imagenes[contador]);
					}
					else {
						contador = 0;
					}
				}
			}
		}
	};
	EventHandler<MouseEvent> salir = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			verdad = false;
		}
	};
	
	public static Scene getScene() { //
		return escena;
	}
	
	public static void setScene(Scene scene) { //
		window.setScene(scene);
		window.show();
	}
	public static void main (String[]args) {
		launch(args);
	}
}
