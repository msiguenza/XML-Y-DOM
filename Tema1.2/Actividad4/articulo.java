package Actividad4;


import java.io.Serializable;

public class articulo implements Serializable {

	private String titulo;

	private String descripcion;

	private String texto;

	private String imagen;


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public String toString() {
		return ("\n Titulo: "+getTitulo() + "   Descripción: " + getDescripcion() + "  Texto: " + getTexto() + "  Imagen: " + getImagen());
	}

	
}