package org.soto.copy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.soto.dto.PersonaDTO;
import org.soto.model.Persona;
import org.soto.util.BaseUtil;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseUtilTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void copiarAtributos() {
		PersonaDTO personaDTO = new PersonaDTO("Nestor Alejandro", "Soto", "Amezcua", true);
		Persona persona = new Persona();
		System.out.println("---------------- ANTES DE COPIAR ATRIBUTOS ----------------");
		System.out.println(personaDTO);
		System.out.println(persona);
		
		BaseUtil.copyProperties(persona,personaDTO);
		
		System.out.println("---------------- DESPUES DE COPIAR ATRIBUTOS ----------------");
		System.out.println(personaDTO);
		System.out.println(persona);
	}

}
