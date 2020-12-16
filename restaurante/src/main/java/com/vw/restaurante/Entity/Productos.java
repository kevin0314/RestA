package com.vw.restaurante.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "productos")
public class Productos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int IdProductos;
	
	@JoinColumn (name = "IdCategoria_FK")
	@ManyToOne(fetch = FetchType.EAGER)
	public Categoria IdCategoria_FK;
	
	@JoinColumn (name = "IdTipoPlatillo_FK")
	@ManyToOne(fetch = FetchType.EAGER)
	public Tipo_Platillo IdTipoPlatillo_FK;
	
	@JoinColumn (name = "IdTipoBebida_FK")
	@ManyToOne(fetch = FetchType.EAGER)
	public Tipo_Bebida IdTipoBebida_FK;
	
	public String descripcion;
	public double precio;
	public String nombre;
	public String tamanio;
	public String imagen;
	
	public Productos() {
		// TODO Auto-generated constructor stub
	}

	public Productos(int idProductos, Categoria idCategoria_FK, Tipo_Platillo idTipoPlatillo_FK,
			Tipo_Bebida idTipoBebida_FK, String descripcion, double precio, String nombre, String tamanio, String imagen) {
		
		IdProductos = idProductos;
		IdCategoria_FK = idCategoria_FK;
		IdTipoPlatillo_FK = idTipoPlatillo_FK;
		IdTipoBebida_FK = idTipoBebida_FK;
		this.descripcion = descripcion;
		this.precio = precio;
		this.nombre = nombre;
		this.tamanio = tamanio;
		this.imagen = imagen;
	}
	
	public Productos( Categoria idCategoria_FK, Tipo_Platillo idTipoPlatillo_FK,
			Tipo_Bebida idTipoBebida_FK, String descripcion, double precio, String nombre, String tamanio, String imagen) {
		
		IdCategoria_FK = idCategoria_FK;
		IdTipoPlatillo_FK = idTipoPlatillo_FK;
		IdTipoBebida_FK = idTipoBebida_FK;
		this.descripcion = descripcion;
		this.precio = precio;
		this.nombre = nombre;
		this.tamanio = tamanio;
		this.imagen = imagen;
	}

	public int getIdProductos() {
		return IdProductos;
	}

	public void setIdProductos(int idProductos) {
		IdProductos = idProductos;
	}

	public Categoria getIdCategoria_FK() {
		return IdCategoria_FK;
	}

	public void setIdCategoria_FK(Categoria idCategoria_FK) {
		IdCategoria_FK = idCategoria_FK;
	}

	public Tipo_Platillo getIdTipoPlatillo_FK() {
		return IdTipoPlatillo_FK;
	}

	public void setIdTipoPlatillo_FK(Tipo_Platillo idTipoPlatillo_FK) {
		IdTipoPlatillo_FK = idTipoPlatillo_FK;
	}

	public Tipo_Bebida getIdTipoBebida_FK() {
		return IdTipoBebida_FK;
	}

	public void setIdTipoBebida_FK(Tipo_Bebida idTipoBebida_FK) {
		IdTipoBebida_FK = idTipoBebida_FK;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	

}
