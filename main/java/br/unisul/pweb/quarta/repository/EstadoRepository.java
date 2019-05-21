package br.unisul.pweb.quarta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.unisul.pweb.quarta.domain.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {

	@Query("SELECT estado FROM Estado estado WHERE estado.nome LIKE %:nome%")
	List<Estado> findLikeNome(String nome);
	
}
