package es.reji.data.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import es.reji.data.AbstractEntity;

@Entity
public class Sala extends AbstractEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private int numSala;
	@OneToMany(mappedBy = "sala", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Sesion> sesiones;
	@ManyToOne()
	@JoinColumn(name = "id_cine")
	private Cine cine;

	public void setNumSala(int numSala) { this.numSala = numSala; }
	@Override
	public Integer getId() { return id; }
	public Cine getCine() { return cine; }
	public int getNumSala() { return numSala; }

}
