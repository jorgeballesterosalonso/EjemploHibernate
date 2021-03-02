import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@NamedQuery(name = "direccion_por_id", query = "FROM Direccion WHERE id =: id")
@Entity
@Table(name = "direccion")
public class Direccion {
	private String calle;
	private int cp;
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;
	

	public Direccion() {
		super();
	}

	public Direccion(String calle, int cp) {
		super();
		this.calle = calle;
		this.cp = cp;

	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", cp=" + cp + ", id=" + id + "]";
	}

}
