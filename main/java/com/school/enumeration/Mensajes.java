package com.school.enumeration;

public enum Mensajes {

	SIN_ALUMNOS("No existen alumnos");
	
	private final String mensaje;

	public String getMensaje() {
		return mensaje;
	}

	private Mensajes(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
