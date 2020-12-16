package com.vw.restaurante.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="usuario")

public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	@Column(name = "nombre")
	String nombre;
	
	@Column(name = "nick")
	String nick;
	
	@Column(name = "clave")
	String clave;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "imagen")
	String imagen;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(
			name = "usuario_roles",
			joinColumns = @JoinColumn(
				name = "idUsuario", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
				name = "idRol", referencedColumnName = "id"))
	private List<Rol> roles= new ArrayList<>();

	public Usuario(int id, String nombre, String nick, String clave, String email, String imagen, List<Rol> roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nick = nick;
		this.clave = clave;
		this.email = email;
		this.imagen = imagen;
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}


	

}
