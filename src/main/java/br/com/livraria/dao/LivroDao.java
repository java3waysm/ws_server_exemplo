package br.com.livraria.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import br.com.livraria.bean.Livro;

@Controller
public class LivroDao implements LivroDaoI {

	private List<Livro> livros;

	public LivroDao() {
		livros = new ArrayList<Livro>();

		this.livros.add(new Livro(1, "A arte da guerra", 5));
		this.livros.add(new Livro(2, "O livro dos 5 aneis", 4));
		this.livros.add(new Livro(3, "Game of Thrones", 1));
		this.livros.add(new Livro(4, "Herry Potter", 1));

	}

	public List<Livro> select() {
		return this.livros;
	}

	public Livro select(Livro l) {
		Livro retorno = null;
		for (Livro livro : livros) {
			if (l.getId().equals(livro.getId())) {
				retorno = l;
			}
		}
		return retorno;
	}

	public Boolean insert(Livro l) {
		this.livros.add(l);
		return true;
	}

	public Boolean remove(Livro l) {
		Boolean retorno = false;
		for (Livro livro : livros) {
			if (l.getId().equals(livro.getId())) {
				this.livros.remove(livro);
				retorno = true;
				break;
			}
		}
		return retorno;
	}

}
