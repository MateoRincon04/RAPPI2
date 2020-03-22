package UIMain.Excepciones;

public class AlertaConfirmacion extends ErrorAplicacion{
	
	public AlertaConfirmacion(String tx){
		super(tx);
	}
	public AlertaConfirmacion() {
		super("Se detecto un problema al consultar esta funcionalidad");
	}
}
