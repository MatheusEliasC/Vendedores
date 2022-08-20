package br.com.matheliasc.Vendedores.service.Impl;

import br.com.matheliasc.Vendedores.model.Vendedor;
import br.com.matheliasc.Vendedores.model.dto.VendedorDTO;
import br.com.matheliasc.Vendedores.model.dto.VendedorIdDTO;
import br.com.matheliasc.Vendedores.model.form.VendedorForm;
import br.com.matheliasc.Vendedores.repository.VendedorRepository;
import br.com.matheliasc.Vendedores.service.AtuacaoService;
import br.com.matheliasc.Vendedores.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VendedorServiceImpl implements VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private AtuacaoService atuacaoService;

    @Override
    public List<VendedorDTO> findAll() {
        List<Vendedor> vendedores = vendedorRepository.findAll();
        if(vendedores.isEmpty())
            throw new NoSuchElementException();
        List<VendedorDTO> vendedoresDTO = new ArrayList<>();
        vendedores.forEach(vendedor -> {
            vendedoresDTO.add(new VendedorDTO(vendedor, atuacaoService.getEstadosByRegiao(vendedor.getRegiao())));
        });
        return vendedoresDTO;
    }

    @Override
    public VendedorDTO save(VendedorForm form) {
        List<String> listaRegiao = atuacaoService.getEstadosByRegiao(form.getRegiao());
        Vendedor vendedor = vendedorRepository.save(form.converterParaVendedor());
        return new VendedorDTO(vendedor,listaRegiao);
    }

    @Override
    public VendedorIdDTO findById(Integer id) {
        Vendedor vendedor = vendedorRepository.findById(id).orElseThrow();
        List<String> listaRegiao = atuacaoService.getEstadosByRegiao(vendedor.getRegiao());
        return new VendedorIdDTO(vendedor,listaRegiao);
    }
}
