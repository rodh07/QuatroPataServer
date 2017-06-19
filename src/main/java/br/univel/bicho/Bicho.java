package br.univel.bicho;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;

@Entity
@Table(name = "cad_bicho")
public class Bicho implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	@Version
	@Column(name = "version")
	private int version;

	@Column(length = 20)
	private String Nome;

	@Column(length = 20)
	private String Especie;

	@Column(length = 50)
	private String Dono;

	@Column(length = 100)
	private String emailDono;

	public int getId() {
		return this.id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	public String getEspecie() {
		return Especie;
	}

	public void setEspecie(String Especie) {
		this.Especie = Especie;
	}

	public String getDono() {
		return Dono;
	}

	public void setDono(String Dono) {
		this.Dono = Dono;
	}

	public String getemailDono() {
		return emailDono;
	}

	public void setemailDono(String emailDono) {
		this.emailDono = emailDono;
	}

	@Override
	public String toString() {
		String resultado = getClass().getSimpleName() + " ";
		if (Nome != null && !Nome.trim().isEmpty())
			resultado += "Nome: " + Nome;
		if (Especie != null && !Especie.trim().isEmpty())
			resultado += ", Especie: " + Especie;
		if (Dono != null && !Dono.trim().isEmpty())
			resultado += ", Dono: " + Dono;
		if (emailDono != null && !emailDono.trim().isEmpty())
			resultado += ", emailDono: " + emailDono;
		return resultado;
	}
}