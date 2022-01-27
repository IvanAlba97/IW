package es.reji.data.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import es.reji.data.AbstractEntity;

@Entity
public class Pelicula extends AbstractEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	@OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Sesion> sesiones;
	private String titulo;
	@Type(type="org.hibernate.type.TextType")
	private String sinopsis;
	private String url;
	private String genero;
	private int pegi;

	public void setTitulo(String titulo) { this.titulo = titulo; }
	public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }
	public void setUrl(String url) { this.url = url; }
	public void setGenero(String genero) { this.genero = genero; }
	public void setPegi(int pegi) { this.pegi = pegi; }
	@Override
	public Integer getId() { return id; }
	public String getTitulo() { return titulo; }
	public String getSinopsis() { return sinopsis; }
	public String getUrl() { return url; }
	public String getGenero() { return genero; }
	public int getPegi() { return pegi; }
	//public List<Sesion> getSesion(Integer id) { return sesiones; }

}
