package Main.main;

import Main.main.Controller.PessoaController;
import Main.main.Entity.Pessoa;
import Main.main.Repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Assertions;


import java.util.Optional;

@SpringBootTest
class LembreteApplicationTests {

	@MockBean
	PessoaRepository pessoaRepository;

	@Autowired
	private  PessoaController pessoaController;

	@BeforeEach
	void injectData(){
		Optional<Pessoa> pessoa = Optional.of(new Pessoa(1L, "Cleyton"));
		Long id = 1L;
		Mockito.when(pessoaRepository.findById(id)).thenReturn(pessoa);
	}

	@Test
	@DisplayName("Caso de Uso FindById Classe Pessoa")
	void testFindByIdPessoaTest(){
		var controller = pessoaController.findById(1L);
		Long id = controller.getBody().getId().longValue();
		System.out.println(id);
		Assertions.assertEquals(1L, id, 0);
	}

}
