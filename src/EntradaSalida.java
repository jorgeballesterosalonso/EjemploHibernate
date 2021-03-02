import java.util.List;
import java.util.Scanner;

public class EntradaSalida {
	public static final int INSERTAR = 1;
	public static final int LISTAR = 2;
	public static final int BUSCAR_POR_NOMBRE = 3;
	public static final int ELIMINAR = 4;
	public static final int ASIGNAR_DIRECCION = 6;

	public static void mostrarDirecciones(List<Direccion> listaDirecciones) {
		for (Direccion direccion : listaDirecciones) {
			System.out.println(direccion);
		}
	}

	public static int mostrarMenu() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Escoja una opción");
		System.out.println("1 - Insertar un contacto");
		System.out.println("2 - Listar contactos");
		System.out.println("3 - Buscar por nombre");
		System.out.println("4 - Eliminar contacto");
		System.out.println("5 - Salir");
		int eleccion = sc.nextInt();

		return eleccion;
	}

	public static Contacto pedirDatosContacto() {
		Scanner sc = new Scanner(System.in);
		Contacto contacto = new Contacto();

		System.out.println("Ingrese el nombre del contacto");
		String nombre = sc.nextLine();
		contacto.setNombre(nombre);

		System.out.println("Ingrese el apellido de " + nombre);
		String Apellido = sc.nextLine();
		contacto.setApellido(Apellido);

		System.out.println("Ingrese el email de " + nombre);
		String email = sc.nextLine();
		contacto.setEmail(email);

		return contacto;
	}

	public static String PedirNombre() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el nombre del contacto");
		String nombre = sc.nextLine();
		return nombre;

	}

	public static void mostrarAgenda(List<Contacto> agenda) {
		for (Contacto contacto : agenda) {
			System.out.println(contacto);
		}
	}
}
