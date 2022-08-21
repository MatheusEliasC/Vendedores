package br.com.matheliasc.Vendedores.service.Impl;

import br.com.matheliasc.Vendedores.model.Atuacao;
import br.com.matheliasc.Vendedores.model.dto.AtuacaoDTO;
import br.com.matheliasc.Vendedores.model.form.AtuacaoForm;
import br.com.matheliasc.Vendedores.repository.AtuacaoRepository;
import br.com.matheliasc.Vendedores.service.AtuacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtuacaoServiceImpl implements AtuacaoService {

    private AtuacaoRepository atuacaoRepository;

    @Autowired
    public AtuacaoServiceImpl(AtuacaoRepository atuacaoRepository) {
        this.atuacaoRepository = atuacaoRepository;
    }

    @Override
    public List<String> getEstadosByRegiao(String regiao) {
        Atuacao atuacao = findByRegiao(regiao);
        return atuacao.getEstados();
    }

    @Override
    public Atuacao findByRegiao(String regiao) {
        return atuacaoRepository.findByRegiao(regiao).orElseThrow();
    }

    @Override
    public AtuacaoDTO save(AtuacaoForm form) {
        Atuacao atuacao = atuacaoRepository.save(form.converterParaAtuacao());
        return new AtuacaoDTO(atuacao);
    }
}
