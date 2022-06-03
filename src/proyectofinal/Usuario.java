
package proyectofinal;

/**
 * Fecha de creación: 11 de mayo
 * @author Jose Manuel Quintero Rodriguez
 *
 * Esta clase define a un usuario el cuál tiene un método que permite validar credenciales de autenticación una vez que el usuario ingrese al sistema
 */
public class Usuario {

	// Atributos privados de la clase
	private String nombre;
	private String contrasena;

	/*Método constructor que al invocar, creamos un objeto con atributos inicializados
    @author José Manuel Quintero Rodríguez*/
	public Usuario() {
		this.nombre = "";
		this.contrasena = "";
	}

	/*Métodos get que sirven para recibir el nombre que hemos ingresado
    @author José Manuel Quintero Rodriguez*/
	public String getNombre() {
		return nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	/*Métodos set que se encargan de enviar parametros ingresados a los atributos
    @author José Manuel Quintero Rodríguez*/
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/*Esté método se encarga de confirmar la autenticacion del usuario mediante nombre y contraseña
    @author Jose Manuel Quintero Rodriguez*/
	public boolean autenticar(String n, String p) { // Pasando como parametros el nombre y la contraseña
		if (getNombre().equals(n) && getContrasena().equals(p)) {
			return true;
		} else {
			return false;
		}
	}
}
