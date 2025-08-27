package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class MontaCarga {

	private ArrayList<Carga> cargas = new ArrayList<>();
	private Double pesoMaximoPermitido;
	private HashSet<Carga> cargasSinDuplicados;

	public MontaCarga(Double pesoMaximoPermitido) {
		this.pesoMaximoPermitido = pesoMaximoPermitido;
		this.cargasSinDuplicados = new HashSet<>();
	}

	public Double getPesoMaximoPermitido() {

		return this.pesoMaximoPermitido;
	}

	public void cargar(Carga carga) {
		this.cargas.add(carga);
	}

	public Integer obtenerCantidadDeCargas() {
		return this.cargas.size();
	}
	
	public Double obtenerPesoCargado() {
		Double sumaDeCargas = 0.0;
		for (Carga carga : this.cargas) {
			sumaDeCargas += carga.getPeso();
		}
		
		return sumaDeCargas;
	}

	public void vaciar() {
		this.cargas.clear();
		
	}

	public boolean agregarCarga(Carga carga) {
		
		return this.cargasSinDuplicados.add(carga);
	}

}
