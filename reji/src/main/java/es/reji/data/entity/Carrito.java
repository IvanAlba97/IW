package es.reji.data.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import es.reji.data.AbstractEntity;
import es.reji.views.registration.domain.Registration;

@Entity
public class Carrito extends AbstractEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	@OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Entrada> entradas;
	@JoinColumn(name = "id_usuario")
	@OneToOne(fetch = FetchType.LAZY)
	private Usuario usuario;
	@JoinColumn(name = "id_registration")
	@OneToOne(fetch = FetchType.LAZY)
	private Registration registration;
	private double precioTotal;
    private int nEntradas;
    private int nPalomitas;
    private int nBebidas;

	public void setPrecioTotal(double precioTotal) { this.precioTotal = precioTotal; }
    public void setNEntradas(int nEntradas) { this.nEntradas = nEntradas; }
    public void setNPalomitas(int nPalomitas) { this.nPalomitas = nPalomitas; }
    public void setNBebidas(int nBebidas) { this.nBebidas = nBebidas; }
	@Override
	public Integer getId() { return id; }
	public int getNEntradas() { return nEntradas; }
	public int getNPalomitas() { return nPalomitas; }
	public int getNBebidas() { return nBebidas; }
	public double getPrecioTotal() { return precioTotal; }

}