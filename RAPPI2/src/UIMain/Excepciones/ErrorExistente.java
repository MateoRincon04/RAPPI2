package UIMain.Excepciones;

public class ErrorExistente extends ErrorAplicacion {
	public ErrorExistente() {
		super("Ya existe un Usuario con este identificador");
	}
}
