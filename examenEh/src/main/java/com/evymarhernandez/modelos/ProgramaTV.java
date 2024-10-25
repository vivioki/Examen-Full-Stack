package com.evymarhernandez.modelos;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="programas")
public class ProgramaTV {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotBlank
	@Size(min=3, message="El título es obligatorio.")
    private String titulo;

	@NotBlank
	@Size(min=3, message="La red es obligatoria.")
    private String red;
	@NotBlank
	@Size(min=3, message="La descripción es obligatoria.")
    private String descripcion;

	//ID CON USUARIO
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    //DATES
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualizacion")
	private Date fecha_actualizacion;
	
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
	
    //CONSTRUCTOR
    public ProgramaTV() {}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getRed() {
		return red;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Usuario getUsuario() {
		return usuario;
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

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setRed(String red) {
		this.red = red;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public void setFecha_actualizacion(Date fecha_actualizacion) {
		this.fecha_actualizacion = fecha_actualizacion;
	}
    
}
