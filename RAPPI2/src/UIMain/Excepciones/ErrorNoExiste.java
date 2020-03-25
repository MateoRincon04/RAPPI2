package UIMain.Excepciones;

public class ErrorNoExiste extends ErrorAplicacion {
	public ErrorNoExiste(String tipo, String nombre) {
		super("El usuario "+ nombre + " No Ha sido registrado como " + tipo);
	}
	public ErrorNoExiste(String restaurante) {
		super("Aun no se han entregado pedidos en "+ restaurante);
	}
}
