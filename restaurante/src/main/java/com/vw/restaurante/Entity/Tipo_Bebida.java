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
@Table(name = "TipoBebida")
public class Tipo_Bebida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int IdTipoBebida;
	private String tipo;
	
	public Tipo_Bebida() {
		// TODO Auto-generated constructor stub
	}

	public Tipo_Bebida(int idTipoBebida, String tipo) {
		super();
		IdTipoBebida = idTipoBebida;
		this.tipo = tipo;
	}

	public int getIdTipoBebida() {
		return IdTipoBebida;
	}

	public void setIdTipoBebida(int idTipoBebida) {
		IdTipoBebida = idTipoBebida;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "IdTipoBebida_FK", cascade = CascadeType.ALL)
	public List<Productos>IdTipoBebida_FK;
	
}
