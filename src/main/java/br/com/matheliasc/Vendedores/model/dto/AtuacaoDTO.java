package br.com.matheliasc.Vendedores.model.dto;

import br.com.matheliasc.Vendedores.model.Atuacao;
import lombok.Data;

import java.util.List;

@Data
public class AtuacaoDTO {

    private String regiao;
    private List<String> estados;

    public AtuacaoDTO(Atuacao atuacao){
        this.regiao = atuacao.getRegiao();
        this.estados = atuacao.getEstados();
    }

}
