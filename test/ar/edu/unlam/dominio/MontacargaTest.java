package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MontacargaTest {

	@Test
	public void dadoQueExisteUnMontaCargasQueNoAdmiteCargasDuplicadasCuandoAgregoUnaCargaDuplicadaObtengoUnResultadoFalso() {

		Double pesoMaximoPermitido = 1000.0;
		MontaCarga montaCarga = new MontaCarga(pesoMaximoPermitido);
		Carga carga = new Carga(1L, 10);
		
		boolean cargaAgregada = montaCarga.agregarCarga(carga);
		boolean segundaCargaAgregada = montaCarga.agregarCarga(carga);
		
		assertTrue(cargaAgregada);
		assertFalse(segundaCargaAgregada);
	}

	@Test
	public void test() {
		Carga carga = new Carga(1L, 100000D);
		Integer hashCarga = carga.hashCode();

		Carga otraCarga = new Carga(1L, 100000D);
		Integer hashOtraCarga = otraCarga.hashCode();

		assertTrue(hashCarga.equals(hashOtraCarga));
	}

	@Test
	public void metodoParaExplicarEquals() {
		String valorEsperado = "Algo";

		String valorObtenido = new String("Algo");

		assertTrue(valorEsperado.equals(valorObtenido));

		Carga carga = new Carga(1L, 10);
		Carga otraCarga = new Carga(1L, 10);

		assertEquals(carga, otraCarga);
//		assertTrue(carga.equals(carga));
//		assertTrue(carga.equals(otraCarga));
	}

	@Test
	public void dadoQueNoExisteUnaCargaAlCrearLaMismaSePuedeObtenerSuPeso() {

		Double peso = 100.0;
		Carga carga = new Carga(peso);
		Double valorEsperado = 100.0;
		Double valorObtenido = carga.getPeso();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void dadoQueNoExisteUnMontaCargaAlCrearElMismoSePuedeObtenerSuPesoMaximoPermitido() {

		Double pesoMaximoPermitido = 1000.0;
		MontaCarga montaCarga = new MontaCarga(pesoMaximoPermitido);
		Double valorEsperado = 1000.0;
		Double valorObtenido = montaCarga.getPesoMaximoPermitido();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void dadoQueExisteUnMontaCargaYVerificarQueSePuedaSubirUnaCarga() {

		Double peso = 100.0;
		Carga carga = new Carga(peso);
		Double pesoMaximoPermitido = 1000.00;
		MontaCarga montaCarga = new MontaCarga(pesoMaximoPermitido);

		montaCarga.cargar(carga);

		Integer valorEsperado = 1;
		Integer valorObtenido = montaCarga.obtenerCantidadDeCargas();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void dadoQueExisteUnMontaCargaYUnaCargaCuandoSuboLaCargaAlMismoVerificarElPesoCargado() {

		Double peso = 100.0;
		Carga carga = new Carga(peso);
		Carga carga2 = new Carga(200.0);
		Double pesoMaximoPermitido = 1000.00;
		MontaCarga montaCarga = new MontaCarga(pesoMaximoPermitido);

		montaCarga.cargar(carga);
		montaCarga.cargar(carga2);

		Double valorEsperado = 300.0;
		Double valorObtenido = montaCarga.obtenerPesoCargado();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void dadoQueExisteUnMontaCargaConVariasCargasAlVaciarloObtengoComoPesoCargadoIgualACero() {

		Double peso = 100.0;
		Carga carga = new Carga(peso);
		Carga carga2 = new Carga(200.0);
		Double pesoMaximoPermitido = 1000.00;
		MontaCarga montaCarga = new MontaCarga(pesoMaximoPermitido);

		montaCarga.cargar(carga);
		montaCarga.cargar(carga2);

		montaCarga.vaciar();

		Double valorEsperado = 0.0;
		Double valorObtenido = montaCarga.obtenerPesoCargado();
		assertEquals(valorEsperado, valorObtenido);

		Integer valorEsperado2 = 0;
		Integer valorObtenido2 = montaCarga.obtenerCantidadDeCargas();
		assertEquals(valorEsperado2, valorObtenido2);

	}

}
