package es.reji.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import es.reji.data.AbstractEntity;

@Entity
public class Entrada extends AbstractEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
    @ManyToOne()
	@JoinColumn(name = "id_sesion")
	private Sesion sesion;
    @ManyToOne()
	@JoinColumn(name = "id_Carrito")
	private Carrito carrito;

	@Override
	public Integer getId() { return id; }
	public Sesion getSesion() { return sesion; }
	public Carrito getCarrito() { return carrito; }

}