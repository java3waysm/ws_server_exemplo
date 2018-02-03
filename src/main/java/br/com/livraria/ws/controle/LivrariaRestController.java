package br.com.livraria.ws.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.livraria.bean.Livro;
import br.com.livraria.dao.LivroDaoI;

@RestController
public class LivrariaRestController {

	@Autowired
	private LivroDaoI dao;

	@GetMapping("/select_livros")
	public List<Livro> getCustomers() {
		return dao.select();
	}
	// http://viralpatel.net/blogs/spring-4-mvc-rest-example-json/

	

	@GetMapping("/select_livros/{id}")
	public ResponseEntity getCustomer(@PathVariable("id") Integer id) {

		Livro l = new Livro(id);
		Livro retorno = dao.select(l);

		if (retorno == null) {
			return new ResponseEntity("Livro não cadastrado " + id, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity(retorno, HttpStatus.OK);
		}
	}

	@PostMapping(value = "/teste_post")
	public List<Livro> teste_p() {
		System.out.println("cadastrar livro");
		return dao.select();

	}

	@PostMapping(value = "/cadastrar_livro")
	public ResponseEntity createCustomer(@RequestBody Livro l) {
		System.out.println("cadastrar livro");

		dao.insert(l);
		return new ResponseEntity(l, HttpStatus.OK);
	}

	@GetMapping("/deletar_livro/{id}")
	public ResponseEntity deleteCustomer(@PathVariable Integer id) {
		Livro l = new Livro(id);
		dao.remove(l);
		return new ResponseEntity(id, HttpStatus.OK);

	}
}
