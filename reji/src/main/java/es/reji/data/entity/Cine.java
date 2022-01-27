package es.reji.data.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import es.reji.data.AbstractEntity;
import java.util.List;

@Entity
public class Cine extends AbstractEntity{

    private Integer id;
    private String nombre;
	private String direccion;
    @OneToMany(mappedBy = "cine", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Sala> salas;
    public void setIdCine(Integer id) { this.id = id; }
    public void setNombre(String nombre) {this.nombre = nombre; }
	public void setDireccion(String direccion) { this.direccion = direccion; }
    @Override
    public Integer getId() { return id; }
    public String getNombre() { return nombre; }
	public String getDireccion() { return direccion; }
    
}
