package com.vw.restaurante.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TipoPlatillo")
public class Tipo_Platillo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdTipoPlatillo;
	private String tipo;
	
	public Tipo_Platillo() {
		// TODO Auto-generated constructor stub
	}

	public Tipo_Platillo(int idTipoPlatillo, String tipo) {
		super();
		IdTipoPlatillo = idTipoPlatillo;
		this.tipo = tipo;
	}

	public int getIdTipoPlatillo() {
		return IdTipoPlatillo;
	}

	public void setIdTipoPlatillo(int idTipoPlatillo) {
		IdTipoPlatillo = idTipoPlatillo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "IdTipoPlatillo_FK", cascade = CascadeType.ALL)
	public List<Productos>IdTipoPlatillo_FK;
	
}
