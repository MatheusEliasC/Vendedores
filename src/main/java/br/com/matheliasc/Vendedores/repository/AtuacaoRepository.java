package br.com.matheliasc.Vendedores.repository;

import br.com.matheliasc.Vendedores.model.Atuacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AtuacaoRepository extends JpaRepository<Atuacao,String> {

    Optional<Atuacao> findByRegiao (String regiao);

}
