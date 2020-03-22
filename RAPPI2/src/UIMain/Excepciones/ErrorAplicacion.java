package UIMain.Excepciones;

public class ErrorAplicacion extends Exception{
	
	public ErrorAplicacion(String tx){
		super("Manejo de errores de la Aplicación:" + tx);
	}

}
