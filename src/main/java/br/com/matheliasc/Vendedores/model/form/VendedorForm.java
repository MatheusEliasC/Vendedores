package br.com.matheliasc.Vendedores.model.form;

import br.com.matheliasc.Vendedores.model.Vendedor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class VendedorForm {

    @NotBlank
    private String nome;
    @NotBlank
    private String telefone;
    @NotNull
    private Integer idade;
    @NotBlank
    private String cidade;
    @NotBlank
    private String estado;
    @NotBlank
    private String regiao;

    public Vendedor converterParaVendedor(){
        return Vendedor.builder()
                .nome(this.nome)
                .telefone(this.telefone)
                .idade(this.idade)
                .cidade(this.cidade)
                .estado(this.estado)
                .regiao(this.regiao)
                .dataInclusao(LocalDate.now())
                .build();
    }
}
