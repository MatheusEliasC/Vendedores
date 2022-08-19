package br.com.matheliasc.Vendedores.service.Impl;

import br.com.matheliasc.Vendedores.model.Vendedor;
import br.com.matheliasc.Vendedores.repository.VendedorRepository;
import br.com.matheliasc.Vendedores.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VendedorServiceImpl implements VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Override
    public List<Vendedor> findAll() {
        List<Vendedor> vendedores = vendedorRepository.findAll();
        if(vendedores.isEmpty())
            throw new NoSuchElementException();
        return vendedores;
    }
}
