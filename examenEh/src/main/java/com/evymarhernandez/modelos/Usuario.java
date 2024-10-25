package com.evymarhernandez.modelos;

import java.util.Date;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotBlank
	@Size(min=3, message="Por favor proporciona tu nombre.")
    private String nombre;

	@NotBlank
	@Email(message="Por favor proporciona un correo válido.")
    @Column(unique = true)
    private String correo;

	@NotBlank
	@Size(min=3, message="La contraseña necesita tener 8 caracteres.")
    private String password;
	
	
	// 
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ProgramaTV> programatv;  
	
	
	//DATES
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualizacion")
	private Date fecha_actualizacion;
	
	
	//CONSTRUCTOR
	public Usuario() {}
	
	//PARA ACTUALIZAR FECHA DE CREACION Y ACTUALIZACION
	@PrePersist
	protected void onCreate() {
		this.fechaCreacion = new Date();
		this.fecha_actualizacion = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.fecha_actualizacion = new Date();
	}

	//GETTERS SETTERS
	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public String getPassword() {
		return password;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public Date getFecha_actualizacion() {
		return fecha_actualizacion;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public void setFecha_actualizacion(Date fecha_actualizacion) {
		this.fecha_actualizacion = fecha_actualizacion;
	}

	public List<ProgramaTV> getProgramatv() {
		return programatv;
	}

	public void setProgramatv(List<ProgramaTV> programatv) {
		this.programatv = programatv;
	}

	
}
