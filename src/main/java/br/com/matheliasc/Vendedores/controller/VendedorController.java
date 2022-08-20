package br.com.matheliasc.Vendedores.controller;

import br.com.matheliasc.Vendedores.model.Vendedor;
import br.com.matheliasc.Vendedores.model.dto.VendedorDTO;
import br.com.matheliasc.Vendedores.model.form.VendedorForm;
import br.com.matheliasc.Vendedores.service.AtuacaoService;
import br.com.matheliasc.Vendedores.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

    @Autowired
    private VendedorService service;

    @Autowired
    private AtuacaoService atuacaoService;

    @GetMapping
    public ResponseEntity<List<VendedorDTO>> listarVendedores(){
        List<VendedorDTO> vendedores = service.findAll();
        return ResponseEntity.ok(vendedores);
    }

    @PostMapping
    public ResponseEntity<VendedorDTO> salvaVendedor(@RequestBody VendedorForm form, UriComponentsBuilder uriBuilder){
        VendedorDTO vendedor = service.save(form);
        URI uri = uriBuilder.path("/vendedor/{id}").buildAndExpand(vendedor.getId()).toUri();
        return ResponseEntity.created(uri).body(vendedor);
    }
}
