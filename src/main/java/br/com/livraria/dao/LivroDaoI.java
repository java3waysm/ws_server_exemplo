package br.com.livraria.dao;

import java.util.List;

import br.com.livraria.bean.Livro;

public interface LivroDaoI {
	public List<Livro> select();
	
	public Livro select(Livro l);
	
	public Boolean insert(Livro l);
	
	public Boolean remove(Livro l);

}
