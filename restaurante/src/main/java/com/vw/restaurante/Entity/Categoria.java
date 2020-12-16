package com.vw.restaurante.Entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name = "Categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int IdCategoria;
	private String nombre;
	private String imagen;

	public Categoria() {
		// TODO Auto-generated constructor stub
	}

	public Categoria(int idCategoria, String nombre, String imagen) {
		super();
		IdCategoria = idCategoria;
		this.nombre = nombre;
		this.imagen = imagen;
	}

	public int getIdCategoria() {
		return IdCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		IdCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
