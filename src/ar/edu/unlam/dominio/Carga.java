package ar.edu.unlam.dominio;

import java.util.Objects;

public class Carga {

	private Double peso;
	private Long id;

	public Carga(double peso) {
		this.peso = peso;
	}

	public Carga(Long id, double peso) {
		this.peso = peso;
		this.id = id;
	}

	public Double getPeso() {
		return this.peso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, peso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) // Si es el mismo objeto o instancia
			return true;
		
		if (obj == null) //Comprueba que exista el parametro
			return false;
		
		if (getClass() != obj.getClass())
			return false;  // Comprueba que sean de la misma clase
		
		Carga other = (Carga) obj;
		return this.id.equals(other.id) && this.peso.equals(other.peso);  /// todo se pone solo menos esta parte que es manual
	}
	
	
	

}
