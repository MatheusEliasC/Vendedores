package br.com.matheliasc.Vendedores.service.impl;

import br.com.matheliasc.Vendedores.model.Vendedor;
import br.com.matheliasc.Vendedores.model.dto.VendedorDTO;
import br.com.matheliasc.Vendedores.model.dto.VendedorIdDTO;
import br.com.matheliasc.Vendedores.model.form.VendedorForm;
import br.com.matheliasc.Vendedores.repository.VendedorRepository;
import br.com.matheliasc.Vendedores.service.AtuacaoService;
import br.com.matheliasc.Vendedores.service.Impl.VendedorServiceImpl;
import br.com.matheliasc.Vendedores.service.VendedorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class VendedorServiceImplTest {

    private VendedorService service;

    @Mock
    private VendedorRepository repository;

    @Mock
    private AtuacaoService atuacaoService;

    @BeforeEach
    public void setup(){
        repository = mock(VendedorRepository.class);
        atuacaoService = mock(AtuacaoService.class);
        service = new VendedorServiceImpl(repository,atuacaoService);
    }

    @Test
    public void deveRetornarListaVendedorDTOAoEncontrarVendedoresNoBD(){
        List<Vendedor> listaVendedores = getListaVendedor();
        when(repository.findAll()).thenReturn(listaVendedores);
        when(atuacaoService.getEstadosByRegiao("sudeste")).thenReturn(getListaEstados());
        when(atuacaoService.getEstadosByRegiao("nordeste")).thenReturn(List.of("MA","CE"));
        List<VendedorDTO> listaDTOS = service.findAll();
        Assertions.assertNotNull(listaDTOS);
        Assertions.assertEquals(listaDTOS.get(0).getNome(),listaVendedores.get(0).getNome());
        Mockito.verify(atuacaoService, times(2)).getEstadosByRegiao(anyString());
    }

    @Test
    public void deveRetornarNoSuchElementExceptionQuandoNaoEncontrarVendedores(){
        Assertions.assertThrows(NoSuchElementException.class,()->service.findAll());
    }

    @Test
    public void deveRetornarVendedorDTOAoSalvarNovoVendedor(){
        VendedorForm form = getVendedorForm();
        when(atuacaoService.getEstadosByRegiao("sudeste")).thenReturn(getListaEstados());
        when(repository.save(any())).thenReturn(form.converterParaVendedor());
        VendedorDTO vendedorDTO = service.save(form);
        Assertions.assertNotNull(vendedorDTO);
        Assertions.assertEquals(vendedorDTO.getNome(),form.getNome());
    }

    @Test
    public void deveRetornarExceptionQuandoNaoEncontrarRegiaoAoTentarSalvarNovoVendedor(){
        when(atuacaoService.getEstadosByRegiao(anyString())).thenThrow(NoSuchElementException.class);
        Assertions.assertThrows(NoSuchElementException.class,()->service.save(getVendedorForm()));
    }

    @Test
    public void deveRetornarVendedorDTOAoBuscarPorID(){
        VendedorForm form = getVendedorForm();
        when(repository.findById(1)).thenReturn(Optional.of(form.converterParaVendedor()));
        when(atuacaoService.getEstadosByRegiao(anyString())).thenReturn(getListaEstados());
        VendedorIdDTO vendedorIdDTO = service.findById(1);
        Assertions.assertEquals(vendedorIdDTO.getNome(),form.getNome());
    }

    @Test
    public void deveRetornarExceptionQuandoNaoEncontrarVendedorAoBuscarPorID(){
        Assertions.assertThrows(NoSuchElementException.class,()->service.findById(1));
    }

    private List<String> getListaEstados(){
        return List.of("SP","RJ");
    }

    private VendedorForm getVendedorForm() {
        VendedorForm vendedorForm = new VendedorForm();
        vendedorForm.setNome("Jose");
        vendedorForm.setRegiao("sudeste");
        return vendedorForm;
    }

    private List<Vendedor> getListaVendedor(){
        Vendedor v1 = Vendedor.builder()
                .nome("Jose")
                .regiao("sudeste")
                .build();
        Vendedor v2 = Vendedor.builder()
                .nome("Maria")
                .regiao("nordeste")
                .build();
        return List.of(v1, v2);
    }

}