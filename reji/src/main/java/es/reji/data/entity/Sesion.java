package es.reji.data.entity;

import java.time.LocalDateTime;
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
public class Sesion extends AbstractEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
    private LocalDateTime fecha;
    @OneToMany(mappedBy = "sesion", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Entrada> entradas;
    @ManyToOne
    @JoinColumn(name = "id_sala")
    private Sala sala;
    @ManyToOne
    @JoinColumn(name = "id_pelicula")
    private Pelicula pelicula;

	public void setIdSala(Sala sala) { this.sala = sala; }
    public void setPelicula(Pelicula pelicula) { this.pelicula = pelicula; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
	@Override
	public Integer getId() { return id; }
    public Sala getSala() { return sala; }
    public Pelicula getPelicula() { return pelicula; }
    public LocalDateTime getFecha() { return fecha; }
}
