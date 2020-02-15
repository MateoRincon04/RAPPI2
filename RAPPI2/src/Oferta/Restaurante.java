package Oferta;

/* En esta clase, el restaurante es aquel que prepara los platos
 * tiene datos propios como el nombre de restaurante, celular de contacto, dirección
 * qué pedidos están disponibles y un booleano que define si el pedido esta listo para ser
 * despachado o no.
 */
	public class Restaurante {
		private String nombre;
		private String [] direccion;
		private String celular;
		private Pedido pedido;
		private boolean estaListo;
		private Plato[] menu;
		public void setNombre(String nombre) {
			this.nombre=nombre;
		}
		public String getNombre() {
			return (nombre);
		}
		public void setDireccion(String [] direccion) {
			this.direccion=direccion;
		}
		public String[] getDireccion() {
			return(direccion);
		}
		public void setCelular(String celular) {
			this.celular=celular;
		}
		public void setEstaListo(boolean estaListo) {
			this.estaListo=estaListo;
		}
		public boolean getEstaListo() {
			return estaListo;
		}
		
	}
