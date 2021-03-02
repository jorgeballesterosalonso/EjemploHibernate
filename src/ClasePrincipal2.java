import java.util.List;
import java.util.Scanner;

public class ClasePrincipal2 {

	public static void main(String[] args) {

		AccesoADatos.conectarBBDD();

		Direccion d1 = new Direccion("Amargura", 353234);
		Direccion d2 = new Direccion("Penurias", 34785);
		Direccion d3 = new Direccion("MalaLeche", 5664353);

		int opcion = EntradaSalida.mostrarMenu();

		while (opcion != 5) {
			switch (opcion) {

			case EntradaSalida.BUSCAR_POR_NOMBRE: {
				String nombre = EntradaSalida.PedirNombre();
				List listaContactosNombre = AccesoADatos.buscarPorNombreHibernate(nombre);
				EntradaSalida.mostrarAgenda(listaContactosNombre);
				break;
			}
			case EntradaSalida.INSERTAR: {
				Contacto c = EntradaSalida.pedirDatosContacto();

				Scanner sc = new Scanner(System.in);
				int id2 = sc.nextInt();
				// c.setDireccion();
				AccesoADatos.insertarContactoHibernate(c);
				break;
			}

			case EntradaSalida.LISTAR: {

				EntradaSalida.mostrarAgenda(AccesoADatos.listarContactos());
				break;
			}
			}
			opcion = EntradaSalida.mostrarMenu();
		}

		// sesion.save(c);
		//
		// Para recuperar los contactos:/
		// Query q=sesion.createQuery("FROM Contacto");//Query usando JPQL/

	}

}
