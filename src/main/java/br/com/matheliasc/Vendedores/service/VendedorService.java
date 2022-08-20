package br.com.matheliasc.Vendedores.service;

import br.com.matheliasc.Vendedores.model.dto.VendedorDTO;
import br.com.matheliasc.Vendedores.model.dto.VendedorIdDTO;
import br.com.matheliasc.Vendedores.model.form.VendedorForm;

import java.util.List;

public interface VendedorService {

    List<VendedorDTO> findAll();

    VendedorDTO save(VendedorForm form);

    VendedorIdDTO findById(Integer id);
}
