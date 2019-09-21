package com.aws.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "survey")
public class Survey {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	private String apellido;
	
	private String lenguaje_prog;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getLenguaje_prog() {
		return lenguaje_prog;
	}

	public void setLenguaje_prog(String lenguaje_prog) {
		this.lenguaje_prog = lenguaje_prog;
	}

	@Override
	public String toString() {
		return "Survey [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", lenguaje_prog=" + lenguaje_prog
				+ "]";
	}
	
	


}
