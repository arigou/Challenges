package ar.com.ada.apis.nasachallenge.nasachall;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.ada.apis.nasachallenge.nasachall.Services.PaisService;
import ar.com.ada.apis.nasachallenge.nasachall.Services.PaisService.PaisValidationType;
import ar.com.ada.apis.nasachallenge.nasachall.entities.Pais;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	PaisService paisService; 

	@Test
	void contextLoads() {
	}

/**
 * el resultado q da tiene q ser pais invalido para q el test este bien!
 * "guarda" en validationType el resultado que nos da y con el assertEquals compara
 * si es el resultado esperado, esta bien el test.
 */
	@Test
	void verificarPaisInvalidoPoCodigoPais() {
		
		Pais pais = new Pais();

		pais.setNombrePais("xxxxx");
		pais.setCodigoPais(-3);

		PaisValidationType validationType = paisService.verificarPais(pais);
		
		assertEquals(PaisValidationType.PAIS_DATOS_INVALIDOS, validationType);
	}

	@Test
	void verificarPaisInvalidoPoNombre() {
		
		Pais pais = new Pais();
		
		pais.setCodigoPais(32);

		PaisValidationType validationType = paisService.verificarPais(pais);
		
		assertEquals(PaisValidationType.PAIS_DATOS_INVALIDOS, validationType);
	}

	@Test
	void verificarPaisDuplicado() { 

		Pais pais = new Pais(); 

		pais.setCodigoPais(32);
		
		PaisValidationType validationType = paisService.verificarPais(pais);
		
		assertEquals(PaisValidationType.PAIS_DATOS_INVALIDOS, validationType);
	}

}
