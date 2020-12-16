package com.vw.restaurante.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="DetalleOrden")
public class Detalle_Orden {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdDetOrden;
	@JoinColumn (name = "IdProducto_FK")
	@ManyToOne(fetch = FetchType.EAGER)
	
	private Productos IdProducto_FK;
	private int cantidad;
	private double total;
	
	
	
	
	public Detalle_Orden() {
		
	}




	public Detalle_Orden(int idDetOrden, Productos idProducto_FK, int cantidad, double total) {
		super();
		IdDetOrden = idDetOrden;
		IdProducto_FK = idProducto_FK;
		this.cantidad = cantidad;
		this.total = total;
	}




	public int getIdDetOrden() {
		return IdDetOrden;
	}




	public void setIdDetOrden(int idDetOrden) {
		IdDetOrden = idDetOrden;
	}




	public Productos getIdProducto_FK() {
		return IdProducto_FK;
	}




	public void setIdProducto_FK(Productos idProducto_FK) {
		IdProducto_FK = idProducto_FK;
	}




	public int getCantidad() {
		return cantidad;
	}




	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}




	public double getTotal() {
		return total;
	}




	public void setTotal(double total) {
		this.total = total;
	}
	
	
}


