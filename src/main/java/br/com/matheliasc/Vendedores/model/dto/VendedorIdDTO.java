package br.com.matheliasc.Vendedores.model.dto;

import br.com.matheliasc.Vendedores.model.Vendedor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class VendedorIdDTO {

    private String nome;
    private LocalDate dataInclusao;
    private List<String> estados;

    public VendedorIdDTO(Vendedor vendedor, List<String> listaEstados){
        this.nome = vendedor.getNome();
        this.dataInclusao = vendedor.getDataInclusao();
        this.estados = listaEstados;
    }

}
