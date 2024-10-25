package com.evymarhernandez.modelos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UsuarioLogin {

	@NotBlank
	@Email(message="Por favor proporciona un correo válido.")
	private String usuarioCorreo;
	
	@NotBlank
	private String usuarioPassword;

	
	//CONSTRUCTOR
	public UsuarioLogin() {	
	}

	//GETTERS SETTERS
	public String getUsuarioCorreo() {
		return usuarioCorreo;
	}

	public String getUsuarioPassword() {
		return usuarioPassword;
	}

	public void setUsuarioCorreo(String usuarioCorreo) {
		this.usuarioCorreo = usuarioCorreo;
	}

	public void setUsuarioPassword(String usuarioPassword) {
		this.usuarioPassword = usuarioPassword;
	}

	
}
