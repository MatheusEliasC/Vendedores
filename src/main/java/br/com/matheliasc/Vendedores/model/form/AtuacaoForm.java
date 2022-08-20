package br.com.matheliasc.Vendedores.model.form;

import br.com.matheliasc.Vendedores.model.Atuacao;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class AtuacaoForm {

    @NotBlank
    private String regiao;
    @NotEmpty
    private List<String> estados;

    public Atuacao converterParaAtuacao(){
        return Atuacao.builder()
                .regiao(this.regiao)
                .estados(this.estados)
                .build();
    }
}
