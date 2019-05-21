package br.unisul.pweb.quarta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.quarta.domain.Estado;
import br.unisul.pweb.quarta.repository.EstadoRepository;

@Service //estereótipo da classe
public class EstadoService {

	@Autowired //evita instanciar variáveis repetidamente
	private EstadoRepository rep; //variável gerenciada pelo framework
	
	//BUSCAR POR ID
		public Estado find (Integer id) {
			Optional<Estado> obj = rep.findById(id);
			return obj.orElse(null);
		}
	
		//INSERIR
		public Estado insert (Estado obj) {
			obj.setId(null);
			return rep.save(obj);
		}

		//ATUALIZAR
		public Estado update (Estado obj) {
			find(obj.getId());
			return rep.save(obj);
		}

		//DELETAR
		public void delete (Integer id) {
			find(id);
			rep.deleteById(id);
		}
		
		//LISTAR TODAS
		public List<Estado> findAll(){
			return rep.findAll();
		}
		
		//BUSCAR POR NOME ((((NOVO))))	
		public List<Estado> findByName(String nome){
			List<Estado> list = rep.findLikeNome(nome);
			return list;
		}
}
