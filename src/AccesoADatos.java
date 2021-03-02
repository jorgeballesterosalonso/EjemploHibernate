import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class AccesoADatos {

	static StandardServiceRegistry s = null;
	static SessionFactory sf = null;
	static Session sesion = null;
	static Transaction t = null;

	public static void conectarBBDD() {
		s = new StandardServiceRegistryBuilder().configure().build();
		sf = new MetadataSources(s).buildMetadata().buildSessionFactory();
		sesion = sf.openSession();

	}

	public static void insertarContacto(Contacto contacto) {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "");
			String insert = "INSERT INTO agenda VALUES('" + contacto.getId() + "','" + contacto.getNombre() + "','"
					+ contacto.getApellido() + "','" + contacto.getEmail() + "')";
			Statement stmt = c.createStatement();
			stmt.executeUpdate(insert);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static List<Contacto> buscarPorNombre(String nombre) {
		List<Contacto> agenda = new ArrayList<Contacto>();
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "");
			String query = "SELECT * FROM agenda WHERE Nombre LIKE '" + nombre + "'";
			Statement stmt = c.createStatement();
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {
				Contacto cn = new Contacto();
				cn.setNombre(rset.getString(2));
				cn.setId(rset.getInt(1));
				cn.setApellido(rset.getString(3));
				cn.setEmail(rset.getString(4));
				agenda.add(cn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return agenda;
	}

	public static List<Contacto> listarAgenda() {
		List<Contacto> agenda = new ArrayList<Contacto>();
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "");
			String query = "SELECT * FROM agenda ";
			Statement stmt = c.createStatement();
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {
				Contacto cn = new Contacto();
				cn.setNombre(rset.getString(2));
				cn.setId(rset.getInt(1));
				cn.setApellido(rset.getString(3));
				cn.setEmail(rset.getString(4));
				agenda.add(cn);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return agenda;
	}

	public static void eliminarContacto(String nombre2) {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "");
			String query = "DELETE FROM agenda WHERE Nombre = '" + nombre2 + "'";
			Statement stmt = c.createStatement();
			stmt.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List buscarPorNombreHibernate(String nombre) {

		Contacto c = new Contacto();
		Query q = sesion.createNamedQuery("consulta_por_nombre").setString("nombre", nombre);
		List<Contacto> lista = q.getResultList();
		return lista;

	}

	public static void insertarContactoHibernate(Contacto contacto) {
		t = sesion.beginTransaction();
		sesion.save(contacto);
		sesion.save(contacto.getDireccion());
		t.commit();

	}

	public static List listarDirecciones() {
		Query q = sesion.createQuery("FROM Direccion");
		List lista = q.getResultList();
		return lista;
	}

	public static List listarContactos() {

		Query q = sesion.createQuery("FROM Contacto");
		List lista = q.getResultList();
		return lista;

	}

}
