package br.com.matheliasc.Vendedores.controller;

import br.com.matheliasc.Vendedores.model.dto.AtuacaoDTO;
import br.com.matheliasc.Vendedores.model.form.AtuacaoForm;
import br.com.matheliasc.Vendedores.service.AtuacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/atuacao")
public class AtuacaoController {

    @Autowired
    private AtuacaoService atuacaoService;

    @PostMapping
    public ResponseEntity<AtuacaoDTO> salvaAtuacao(@RequestBody AtuacaoForm form, UriComponentsBuilder uriBuilder){
        AtuacaoDTO atuacao = atuacaoService.save(form);
        URI uri = uriBuilder.path("/atuacao/{regiao}").buildAndExpand(atuacao.getRegiao()).toUri();
        return ResponseEntity.created(uri).body(atuacao);
    }

}
