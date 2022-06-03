	 
package proyectofinal;

import javax.swing.JOptionPane;
// Estos formatos sirven para determinar la hora y la fecha actuales
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Fecha de creación: 3 de mayo
 *
 * @author Jose Manuel Quintero Rodriguez Esta clase se encargará de pedir los datos para una reserva y generar una boleta por reserva realizada
 */
public class Reserva {

	 /* Atributos de la clase
		 @Author Jose Manuel Quintero Rodriguez*/
	 String nombreComplejo, nombrePelicula;
	 double precio;
	 int calificacion, numeroSala;
	 LocalDate fechaVenta = LocalDate.now();
	 LocalTime horaFuncion = LocalTime.now(); 
	/**
	 * La hora funcion deberia pedirse en los datos de la programación
	 */

	 /* Método constructor que lo único que hace es inicializar los valores de los atrubutos
		@author José Manuel Quintero Rodriguez*/
	 public Reserva() {
			nombreComplejo = "";
			nombrePelicula = "";
			precio = 0;
			calificacion = 0;
			numeroSala = 0;
	 }

	 /* Este método permite ingresar la informacion de la boleta
		 @author Jose Manuel Quintero Rodriguez*/
	 public void pedirDatosBoleta() {
			nombreComplejo = JOptionPane.showInputDialog("Ingrese el nombre del complejo");
			nombrePelicula = JOptionPane.showInputDialog("Ingrese el nombre de la pelicula");
			numeroSala = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de la sala"));
			precio = Double.parseDouble(JOptionPane.showInputDialog("Digite el precio de la boleta"));
			do {
				 calificacion = Integer.parseInt(JOptionPane.showInputDialog("Como califica la pelicula de 1 a 10"));
				 if (calificacion < 0 || calificacion > 10) {
						JOptionPane.showMessageDialog(null, "Calificacion no valida", "ERROR", JOptionPane.ERROR_MESSAGE);
				 }
			} while (calificacion < 0 || calificacion > 10);
	 }

	 /*Esté método se encargará de generar la boleta al hacer una reserva
		@author Jose Manuel Quintero Rodriguez*/
	 public void generarBoleta() {
			JOptionPane.showMessageDialog(null, "Nombre del complejo: " + nombreComplejo
			+ "\nNombre de la pelicula: " + nombrePelicula
			+ "\nNúmero de la sala: " + numeroSala
			+ "\nFecha de la venta: " + fechaVenta
			+ "\nHora de la función: " + horaFuncion
			+ "\nPrecio de la boleta: " + precio);
	 }
}
