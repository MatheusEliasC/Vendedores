package br.com.matheliasc.Vendedores.controller;

import br.com.matheliasc.Vendedores.model.Vendedor;
import br.com.matheliasc.Vendedores.repository.VendedorRepository;
import br.com.matheliasc.Vendedores.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

    @Autowired
    private VendedorService service;

    @GetMapping
    public ResponseEntity<?> listarVendedores(){
        List<Vendedor> vendedores = service.findAll();
        return ResponseEntity.ok(vendedores);
    }
}
