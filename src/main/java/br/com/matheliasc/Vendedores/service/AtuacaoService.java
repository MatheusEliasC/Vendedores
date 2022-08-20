package br.com.matheliasc.Vendedores.service;

import br.com.matheliasc.Vendedores.model.Atuacao;
import br.com.matheliasc.Vendedores.model.dto.AtuacaoDTO;
import br.com.matheliasc.Vendedores.model.form.AtuacaoForm;

import java.util.List;

public interface AtuacaoService {

    List<String> getEstadosByRegiao(String regiao);

    Atuacao findByRegiao(String regiao);

    AtuacaoDTO save(AtuacaoForm form);
}
