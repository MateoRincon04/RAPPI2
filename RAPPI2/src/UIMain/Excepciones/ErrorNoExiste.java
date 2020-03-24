package UIMain.Excepciones;

public class ErrorNoExiste extends ErrorAplicacion {
	public ErrorNoExiste(String tipo, String nombre) {
		super("El usuario "+ nombre + " No Ha sido registrado como " + tipo);
	}
}
