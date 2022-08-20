package br.com.matheliasc.Vendedores.service.Impl;

import br.com.matheliasc.Vendedores.model.Atuacao;
import br.com.matheliasc.Vendedores.model.dto.AtuacaoDTO;
import br.com.matheliasc.Vendedores.model.form.AtuacaoForm;
import br.com.matheliasc.Vendedores.repository.AtuacaoRepository;
import br.com.matheliasc.Vendedores.service.AtuacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AtuacaoServiceImpl implements AtuacaoService {

    @Autowired
    private AtuacaoRepository atuacaoRepository;

    @Override
    public List<String> getEstadosByRegiao(String regiao) {
        Atuacao atuacao = findByRegiao(regiao);
        return atuacao.getEstados();
    }

    @Override
    public Atuacao findByRegiao(String regiao) {
        Optional<Atuacao> atuacaoOPT = atuacaoRepository.findByRegiao(regiao);
        if(atuacaoOPT.isEmpty())
            throw new NoSuchElementException("Regiao fornecida não corresponde a uma Atuacao válida!");
        return atuacaoOPT.get();
    }

    @Override
    public AtuacaoDTO save(AtuacaoForm form) {
        Atuacao atuacao = atuacaoRepository.save(form.converterParaAtuacao());
        return new AtuacaoDTO(atuacao);
    }
}
