package br.com.ebac.padrao_estrangulamento.repositorios;

import org.springframework.data.repository.CrudRepository;

import br.com.ebac.padrao_estrangulamento.entidades.Usuario;

public interface RepositorioUsuario extends CrudRepository<Usuario, Long> {

}
