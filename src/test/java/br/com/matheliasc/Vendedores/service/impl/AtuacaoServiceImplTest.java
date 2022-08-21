package br.com.matheliasc.Vendedores.service.impl;

import br.com.matheliasc.Vendedores.model.Atuacao;
import br.com.matheliasc.Vendedores.model.dto.AtuacaoDTO;
import br.com.matheliasc.Vendedores.model.form.AtuacaoForm;
import br.com.matheliasc.Vendedores.repository.AtuacaoRepository;
import br.com.matheliasc.Vendedores.service.AtuacaoService;
import br.com.matheliasc.Vendedores.service.Impl.AtuacaoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AtuacaoServiceImplTest {

    private AtuacaoService service;

    @Mock
    private AtuacaoRepository repository;

    @BeforeEach
    public void setup() {
        repository = mock(AtuacaoRepository.class);
        service = new AtuacaoServiceImpl(repository);
    }

    @Test
    public void deveRetornarListaDeEstadosQuandoRecebeRegiao(){
        Atuacao atuacao = getAtuacao();
        when(repository.findByRegiao("sudeste")).thenReturn(Optional.of(atuacao));
        List<String> estados = service.getEstadosByRegiao("sudeste");
        Assertions.assertEquals(estados,List.of("SP","RJ"));
    }

    @Test
    public void deveRetornarNoSuchElementExceptionQuandoNaoEncontrarAtuacao(){
        Assertions.assertThrows(NoSuchElementException.class,() -> service.findByRegiao("sudeste"));
    }

    @Test
    public void deveRetornarRuntimeExceptionQuandoNaoObterConexaoComBD(){
        when(repository.findByRegiao("sudeste")).thenThrow(RuntimeException.class);
        Assertions.assertThrows(RuntimeException.class,() -> service.getEstadosByRegiao("sudeste"));
    }

    @Test
    public void deveRetornarAtuacaoDTOQuandoSalvarAtuacaoForm(){
        when(repository.save(any())).thenReturn(getAtuacao());
        AtuacaoDTO dto = service.save(getAtuacaoForm());
        Assertions.assertNotNull(dto);
    }

    private Atuacao getAtuacao(){
        return Atuacao.builder()
                .regiao("sudeste")
                .estados(List.of("SP","RJ"))
                .build();
    }

    private AtuacaoForm getAtuacaoForm(){
        AtuacaoForm form = new AtuacaoForm();
        form.setRegiao("sudeste");
        form.setEstados(List.of("SP","RJ"));
        return form;
    }

}
