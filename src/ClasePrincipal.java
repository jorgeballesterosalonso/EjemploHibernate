import java.util.List;

public class ClasePrincipal {

	public static void main(String[] args) {

		int eleccion = EntradaSalida.mostrarMenu();

		while (eleccion != 5) {
			switch (eleccion) {

			case EntradaSalida.INSERTAR:
				Contacto c = EntradaSalida.pedirDatosContacto();
				AccesoADatos.insertarContacto(c);
				break;

			case EntradaSalida.BUSCAR_POR_NOMBRE:
				String nombre = EntradaSalida.PedirNombre();
				List<Contacto> agendaPorNombre = AccesoADatos.buscarPorNombre(nombre);
				EntradaSalida.mostrarAgenda(agendaPorNombre);
				break;

			case EntradaSalida.ELIMINAR:
				String nombre2 = EntradaSalida.PedirNombre();
				AccesoADatos.eliminarContacto(nombre2);
				break;

			case EntradaSalida.LISTAR:
				List<Contacto> agenda = AccesoADatos.listarAgenda();
				EntradaSalida.mostrarAgenda(agenda);
				break;
			}
			eleccion = EntradaSalida.mostrarMenu();
		}
	}

}
